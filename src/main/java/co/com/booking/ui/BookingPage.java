package co.com.booking.ui;


import co.com.booking.utils.Dates;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.poi.ss.formula.functions.T;

public class BookingPage {

    public static final Target TXT_CIUDAD = Target.the("ingresar ciudad").locatedBy("//input[@name='ss']");

    public static final Target BTN_FECHAS = Target.the("Seleccionar fechas").locatedBy("//div[@class='c92e2bd0cb']");

    public static final Target TXT_FECHA_ENTRADA = Target.the("Fecha de entrada").locatedBy(String.format("//span[@data-date=\"%s\"]", Dates.obtenerFechaMasDias(2)));

    public static final Target TXT_FECHA_SALIDA = Target.the("Fecha de salida").locatedBy(String.format("//span[@data-date=\"%s\"]",Dates.obtenerFechaMasDias(7)));

    public static final Target BTN_PERSONAS_HABITACIONES = Target.the("Seleccionar acompañantes y número de habitaciones").locatedBy("//div[@class='a6391e882c']");

    public static final Target BTN_ADULTOS_AUMENTAR = Target.the("Aumentar número de adultos").locatedBy("(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[1]");

    public static final Target BTN_ADULTOS_DISMINUIR = Target.the("Disminuir número de adultos").locatedBy("(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb af4d87ec2f'])[1]");

    public static final Target BTN_NINOS_AUMENTAR = Target.the("Aumentar número de niños").locatedBy("(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[2]");

    public static final Target BTN_HABITACIONES = Target.the("Aumentar número de habitaciones").locatedBy("(//button[@class='dba1b3bddf e99c25fd33 aabf155f9a f42ee7b31a a86bcdb87f e137a4dfeb d1821e6945'])[3]");


    public static Target listaEdades(int index) {
        return Target.the("Lista de edades")
                .locatedBy("(//div[@class='d14b6d33e7 a5ae2c307d'])[" + index + "]");
    }

    public static Target seleccionarEdad(int index) {
        return Target.the("Seleccionar edad niño")
                .locatedBy("(//option[@data-key='" + index + "'])[" + index + "]");
    }

    public static final Target BTN_BUSCAR = Target.the("Botón de buscar").locatedBy("//button[@type='submit']");

    public static final Target BTN_IZQUIERDO_PRECIO = Target.the("Botón izquierdo filtro precio").locatedBy("(//div[@class='d19f1471e1'])[1]");

    public static final Target BTN_DERECHO_PRECIO = Target.the("Botón derecho filtro precio").locatedBy("(//div[@class='d19f1471e1'])[2]");

    public static final Target TXT_IZQUIERDO_PRECIO = Target.the("Obtener valor del precio lado izquiero del slider").locatedBy("(//input[@class='a3ad3bc9e4'])[1]");

    public static final Target TXT_DERECHO_PRECIO = Target.the("Obtener valor del precio lado derecho del slider").locatedBy("(//input[@class='a3ad3bc9e4'])[2]");

    public static final Target BTN_CATEGORIA_TRES = Target.the("Filtro categoria 3").locatedBy("(//*[text()='3 estrellas'])[1]");

    public static final Target BTN_CATEGORIA_CUATRO = Target.the("Filtro categoria 4").locatedBy("(//*[text()='4 estrellas'])[1]");

    public static final Target BTN_CATEGORIA_CINCO = Target.the("Filtro categoria 5").locatedBy("(//*[text()='5 estrellas'])[1]");

    public static final Target BTN_FILTROS = Target.the("Botón Filtros").locatedBy("//button[@class='dba1b3bddf f202e3a5e2']");

    public static final Target FILTRO_PRECIO_BAJO = Target.the("Filtro precio mas bajo").locatedBy("(//button[@class='dba1b3bddf da38b23449 c944eb558d a2ce59f28d'])[3]");

    public static final Target SELECCION_HOTEL = Target.the("Seleccion hotel mas barato").locatedBy("(//div[@class='e01df12ddf a0914461b0 d46a3604b5 ba1c6fdc7f f550b7da28 b9a2fd8068 cb4a416743'])[1]");

    public static final Target ASERCION = Target.the("Asercion").locatedBy("//*[text()='Vista general']");
}

