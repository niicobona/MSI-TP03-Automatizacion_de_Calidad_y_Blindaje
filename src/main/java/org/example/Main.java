package org.example;

public class Main {

  static void main(String[] args) {

    boolean clientePremium = true;
    double totalCompra = 1200;

    CalculadoraPedido calculadora = new CalculadoraPedido();

    int resultado = calculadora.calcularDescuento(clientePremium, totalCompra);

    System.out.println(resultado);
  }
}
