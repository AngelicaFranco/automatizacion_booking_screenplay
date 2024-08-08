package co.com.booking.questions;

import co.com.booking.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CompareBooking implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(BookingPage.ASERCION).answeredBy(actor);
    }

    public static CompareBooking compareBooking(){
        return new CompareBooking();
    }
}
