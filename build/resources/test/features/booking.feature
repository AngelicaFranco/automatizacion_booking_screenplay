#language: es

Característica: Realizar reservas en hoteles
  Como usuario web
  Quiero realizar una reserva
  Para seleccionar el mejor hotel y al mejor precio

  @Login
  Escenario: Inicio de sesión exitoso
    Dado que el usuario ingresa a la página de Booking
    Cuando ingresa las credenciales correctas
    Entonces el sistema permitirá ingresar a la página de Booking

  @Reserva
  Escenario:  Realizar una reserva exitosa en la pagina de Booking
    Dado que un usuario se encuentra en la pagina de Booking
    Cuando ingrese la información solicitada para realizar la reserva
    Entonces el sistema visualizará lista de hoteles y elegirá el mas barato