package org.example;

public class CalculadoraPedido {

  public double calcularTotal(double precioUnitario, int cantidad) {

    if (precioUnitario <= 0) {
      throw new IllegalArgumentException("El precio debe ser mayor que 0");
    }

    if (cantidad <= 0) {
      throw new IllegalArgumentException("El cantidad debe ser mayor que 0");
    }

    return precioUnitario * cantidad;
  }

  public int calcularDescuento(boolean clientePremium, double totalCompra) {

    int descuento = 0;

    if (clientePremium) {
      descuento += 100;
    }

    if (totalCompra > 1000) {
      descuento += 50;
    }

    return descuento;
  }

  public double calcularPrecio(double precio, int cantidad, boolean premium, boolean tieneCupon) {

    validarDatos(precio, cantidad);

    double total = precio * cantidad;
    double descuento = calcularDescuentos(premium, tieneCupon);

    return total * descuento;
  }

  private void validarDatos(double precio, int cantidad) {
    if (precio <= 0) {
      throw new IllegalArgumentException("Precio invalido");
    }
    if (cantidad <= 0) {
      throw new IllegalArgumentException("Cantidad invalido");
    }
  }

  private double calcularDescuentos(boolean premium, boolean tieneCupon) {
    if (premium && tieneCupon) {
      return 0.80;
    }
    if (premium || tieneCupon) {
      return 0.90;
    }
    return 1;
  }
}
