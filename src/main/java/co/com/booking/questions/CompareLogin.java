package co.com.booking.questions;

import co.com.booking.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CompareLogin implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(LoginPage.ASERSION).answeredBy(actor);
    }

    public static CompareLogin compareLogin(){
        return new CompareLogin();
    }
}
