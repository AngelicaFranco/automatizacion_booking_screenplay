package co.com.booking.stepdefinitions;

import co.com.booking.interactions.CloseWindow;
import co.com.booking.models.Data;
import co.com.booking.questions.CompareBooking;
import co.com.booking.tasks.BookingTask;
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

public class BookingStepDefinition {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Angelica");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("que un usuario se encuentra en la pagina de Booking")
    public void queUnUsuarioSeEncuentraEnLaPaginaDeBooking() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.booking.com/"));

    }

    @Cuando("ingrese la información solicitada para realizar la reserva")
    public void ingreseLaInformaciónSolicitadaParaRealizarLaReserva() throws IOException {
        CloseWindow.cerrarVentanaEmergente();
        Data data = ExcelReader.readSheet(Constants.FILE_PATH).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(BookingTask.registro(data));

    }

    @Entonces("el sistema visualizará lista de hoteles y elegirá el mas barato")
    public void elSistemaVisualizaráListaDeHotelesYElegiráElMasBarato() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareBooking.compareBooking(),
                Matchers.is("Vista general")));
    }

}
