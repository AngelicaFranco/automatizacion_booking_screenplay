package co.com.booking.interactions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CloseWindow {

    public static void cerrarVentanaEmergente(){

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }
}
