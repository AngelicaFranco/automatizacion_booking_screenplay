package co.com.booking.stepdefinitions;

import co.com.booking.interactions.CloseWindow;
import co.com.booking.models.Data;
import co.com.booking.questions.CompareLogin;
import co.com.booking.tasks.LoginTask;
import co.com.booking.utils.Constants;
import co.com.booking.utils.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginStepDefinition {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Angelica");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("que el usuario ingresa a la página de Booking")
    public void queElUsuarioIngresaALaPáginaDeBooking() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.booking.com/"));

    }

    @Cuando("ingresa las credenciales correctas")
    public void ingresaLasCredencialesCorrectas() throws IOException {
        CloseWindow.cerrarVentanaEmergente();
        Data data = ExcelReader.readSheet(Constants.FILE_PATH).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.inicioSesion(data));
    }

    @Entonces("el sistema permitirá ingresar a la página de Booking")
    public void elSistemaPermitiráIngresarALaPáginaDeBooking() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareLogin.compareLogin(),Matchers.is("Pruebas Automatizacion")));

    }
}
