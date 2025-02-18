package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImcTest {

    @Test
    public void testIMCValido() {
        double peso = 70.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Saudável", classificacao);
    }

    @Test
    public void testIMCPesoNegativo() {
        double peso = -10.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Magreza grave", classificacao);
    }

    @Test
    public void testIMCEntradaNaoNumerica() {
        assertThrows(NumberFormatException.class, () -> {
            Double.parseDouble("abc");
        });
    }

    @Test
    public void testIMCPesoZero() {
        double peso = 0.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Magreza grave", classificacao);
    }

    @Test
    public void testIMCAlturaLimite() {
        double peso = 70.0;
        double altura = 0.5;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Obesidade Grau III", classificacao);
    }

    @Test
    public void testIMCLimiteInferiorPesoZero() {
        double peso = 0.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Magreza grave", classificacao);
    }

    @Test
    public void testIMCLimiteSuperiorPesoMaximo() {
        double peso = 500.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Obesidade Grau III", classificacao);
    }

    @Test
    public void testIMCLimiteInferiorAlturaMinima() {
        double peso = 70.0;
        double altura = 0.5;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Obesidade Grau III", classificacao);
    }

    @Test
    public void testIMCLimiteSuperiorAlturaMaxima() {
        double peso = 70.0;
        double altura = 3.5;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Magreza grave", classificacao);
    }

    @Test
    public void testIMCLimitePesoAbaixoNormal() {
        double peso = 50.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Magreza moderada", classificacao);
    }

    @Test
    public void testIMCLimitePesoAcimaNormal() {
        double peso = 80.0;
        double altura = 1.75;
        double imc = CalculoIMC.calcularPeso(peso, altura);
        String classificacao = CalculoIMC.classificarIMC(imc);
        assertEquals("Sobrepeso", classificacao);
    }
}