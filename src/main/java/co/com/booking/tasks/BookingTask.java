package co.com.booking.tasks;

import co.com.booking.interactions.ClickAndDrag;
import co.com.booking.interactions.SwitchToNewTab;
import co.com.booking.models.Data;
import co.com.booking.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class BookingTask implements Task {

    Data data;

    public BookingTask(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(data.getCiudad()).into(BookingPage.TXT_CIUDAD));
        actor.attemptsTo(Click.on(BookingPage.BTN_FECHAS));
        actor.attemptsTo(Click.on(BookingPage.TXT_FECHA_ENTRADA));
        actor.attemptsTo(Click.on(BookingPage.TXT_FECHA_SALIDA));
        actor.attemptsTo(Click.on(BookingPage.BTN_PERSONAS_HABITACIONES));
        seleccionarAdultos(actor);
        seleccionarNinos(actor);
        seleccionarHabitaciones(actor);
        actor.attemptsTo(Click.on(BookingPage.BTN_BUSCAR));
        actor.attemptsTo(Click.on(BookingPage.BTN_CATEGORIA_TRES));
        actor.attemptsTo(Click.on(BookingPage.BTN_CATEGORIA_CUATRO));
        actor.attemptsTo(Click.on(BookingPage.BTN_CATEGORIA_CINCO));
        actor.attemptsTo(ClickAndDrag.onElement(BookingPage.BTN_IZQUIERDO_PRECIO,BookingPage.TXT_IZQUIERDO_PRECIO,data.getPrecioMinimo(),"right",10));
        actor.attemptsTo(ClickAndDrag.onElement(BookingPage.BTN_DERECHO_PRECIO,BookingPage.TXT_DERECHO_PRECIO,data.getPrecioMaximo(),"left",-10));
        actor.attemptsTo(Click.on(BookingPage.BTN_FILTROS));
        actor.attemptsTo(Click.on(BookingPage.FILTRO_PRECIO_BAJO));
        actor.attemptsTo(Click.on(BookingPage.SELECCION_HOTEL));
        actor.attemptsTo(SwitchToNewTab.switchToNewTab());

    }

    public static BookingTask registro(Data data) {
        return Tasks.instrumented(BookingTask.class, data);
    }

    public <T extends Actor> void seleccionarAdultos(T actor) {

        int num_adulto_base = 2;
        int num_adulto_feature_mayor = data.getAdultos() - num_adulto_base;
        int num_adulto_feature_menor = num_adulto_base - data.getAdultos();

        if (num_adulto_base < data.getAdultos()) {
            for (int i = 0; i < num_adulto_feature_mayor; i++) {
                actor.attemptsTo(Click.on(BookingPage.BTN_ADULTOS_AUMENTAR));
            }
        } else {
            for (int i = 0; i < num_adulto_feature_menor; i++) {
                actor.attemptsTo(Click.on(BookingPage.BTN_ADULTOS_DISMINUIR));
            }
        }

    }

    public <T extends Actor> void seleccionarNinos(T actor) {

        for (int i = 0; i < data.getNinos(); i++) {
            actor.attemptsTo(Click.on(BookingPage.BTN_NINOS_AUMENTAR));
        }

        for (int i = 0; i < data.getNinos(); i++) {
            actor.attemptsTo(Click.on(BookingPage.listaEdades(i + 1)));
            actor.attemptsTo(Click.on(BookingPage.seleccionarEdad(i + 1)));
        }
    }

    public <T extends Actor> void seleccionarHabitaciones(T actor) {
        for (int i = 0; i < data.getHabitaciones(); i++) {
            actor.attemptsTo(Click.on(BookingPage.BTN_HABITACIONES));
        }
    }
}
