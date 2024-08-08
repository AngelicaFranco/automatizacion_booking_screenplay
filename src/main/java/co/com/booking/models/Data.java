package co.com.booking.models;

import io.cucumber.java.sl.In;

public class Data {

    private String correo;
    private String contrasena;
    private String ciudad;
    private Integer adultos;
    private Integer ninos;
    private Integer habitaciones;
    private Integer precioMinimo;
    private Integer precioMaximo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getAdultos() {
        return adultos;
    }

    public void setAdultos(Integer adultos) {
        this.adultos = adultos;
    }

    public Integer getNinos() {
        return ninos;
    }

    public void setNinos(Integer ninos) {
        this.ninos = ninos;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Integer getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(Integer precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public Integer getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(Integer precioMaximo) {
        this.precioMaximo = precioMaximo;
    }
}
