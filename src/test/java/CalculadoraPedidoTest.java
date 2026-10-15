import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.CalculadoraPedido;
import org.junit.jupiter.api.Test;

public class CalculadoraPedidoTest {

  @Test
  void testCalculadoraPedido() {
    // Arrange
    CalculadoraPedido calculadora = new CalculadoraPedido();
    double precioUnitario = 1500;
    int cantidad = 2;
    // Act
    double resultado = calculadora.calcularTotal(precioUnitario, cantidad);
    // Assert
    assertEquals(3000, resultado);
  }

  @Test
  void testCalculadoraPedidoPrecioInvalido() {
    // Arrange
    CalculadoraPedido calculadora = new CalculadoraPedido();
    double precioUnitario = 0;
    int cantidad = 2;
    // Act + Assert
    assertThrows(
        IllegalArgumentException.class, () -> calculadora.calcularTotal(precioUnitario, cantidad));
  }

  @Test
  void testCalculadoraPedidoCantidadInvalida() {
    // Arrange
    CalculadoraPedido calculadora = new CalculadoraPedido();
    double precioUnitario = 1500;
    int cantidad = 0;
    // Act + Assert
    assertThrows(
        IllegalArgumentException.class, () -> calculadora.calcularTotal(precioUnitario, cantidad));
  }
}
