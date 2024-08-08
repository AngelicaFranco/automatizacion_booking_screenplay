package co.com.booking.ui;


import net.serenitybdd.screenplay.targets.Target;


public class LoginPage {

    public static final Target BTN_INICIO_SESION = Target.the("Botón inicio de sesión").locatedBy("(//*[contains(text(),'Inicia sesión')])[1]");

    public static final Target TXT_CORREO = Target.the("Ingresar correo").locatedBy("//input[@type='email']");

    public static final Target BTN_CONTINUAR_EMAIL = Target.the("Botón continuar con email").locatedBy("(//span[@class='TKez1AxowpXXm_eCa_Bz'])[2]");

    public static final Target TXT_CONTRASENA = Target.the("Ingresar contraseña").locatedBy("//input[@type='password']");

    public static final Target BTN_INICIAR_SESION = Target.the("Botón iniciar sesión").locatedBy("//button[@type='submit']");

    public static final Target ASERSION = Target.the("Asersion").locatedBy("//*[text()='Pruebas Automatizacion']");
}
