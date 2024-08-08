package co.com.booking.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;

import java.util.Set;

public class SwitchToNewTab implements Task {


    public static SwitchToNewTab switchToNewTab() {
        return Tasks.instrumented(SwitchToNewTab.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String originalWindow = actor.usingAbilityTo(BrowseTheWeb.class).getDriver().getWindowHandle();
        Set<String> windowHandles = actor.usingAbilityTo(BrowseTheWeb.class).getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                actor.attemptsTo(Switch.toWindow(windowHandle));
                break;
            }
        }
    }
}