package co.com.booking.tasks;

import co.com.booking.interactions.WaitElement;
import co.com.booking.models.Data;
import co.com.booking.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


public class LoginTask implements Task {

    Data data;

    public LoginTask (Data data){
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.BTN_INICIO_SESION));
        WaitElement.waitSeconds(5000);
        actor.attemptsTo(Enter.theValue(data.getCorreo()).into(LoginPage.TXT_CORREO));
        actor.attemptsTo(Click.on(LoginPage.BTN_CONTINUAR_EMAIL));
        WaitElement.waitSeconds(2000);
        actor.attemptsTo(Enter.theValue(data.getContrasena()).into(LoginPage.TXT_CONTRASENA));
        WaitElement.waitSeconds(5000);
        actor.attemptsTo(Click.on(LoginPage.BTN_INICIAR_SESION));

    }

    public static LoginTask inicioSesion(Data data){
        return Tasks.instrumented(LoginTask.class,data);
    }
}
