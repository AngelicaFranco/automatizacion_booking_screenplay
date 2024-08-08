package co.com.booking.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAndDrag implements Interaction {

    private final Target target;
    private final Target text;
    private final Integer limit;
    private final String type;
    private final int moveX;

    public ClickAndDrag(Target element, Target text, Integer limit, String type, int moveX) {
        this.target = element;
        this.text = text;
        this.limit = limit;
        this.type = type;
        this.moveX = moveX;
    }

    public static ClickAndDrag onElement(Target element, Target texto, Integer limit, String type, int moveX) {
        return Tasks.instrumented(ClickAndDrag.class, element, texto, limit, type, moveX);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);
        WebElement element = target.resolveFor(actor);

        boolean isNegative = true;
        while (isNegative){
            WebElement t = text.resolveFor(actor);
            String value = t.getAttribute("value");
            if(type.equals("right") && Integer.valueOf(value) >= limit){
                isNegative = false;
            } else if (type.equals("left") && Integer.valueOf(value) <= limit) {
                isNegative = false;
            }
            actions.clickAndHold(element)
                    .moveByOffset(moveX, 0)
                    .release()
                    .perform();
        }
    }
}
