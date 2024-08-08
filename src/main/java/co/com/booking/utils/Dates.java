package co.com.booking.utils;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static String obtenerFechaMasDias(Integer dias){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaActualMasDias = fechaActual.plusDays(dias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActualMasDias.format(formatter);
        return fechaFormateada;

    }
}
