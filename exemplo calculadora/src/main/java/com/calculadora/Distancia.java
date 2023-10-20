package com.calculadora;

public class Distancia {
    private final double milhasEmQuilometros = 1.609;
    private final double quilometrosEmMilhas = 0.6214;

    enum TipoConversao {
        QuilimetrosParaMilhas, MilhasParaQuilometros
    }

    public double Converter(TipoConversao tipo, double valor) throws Exception {
        double resultado = 0;

        if (tipo == null)
            throw new IllegalArgumentException("Tipo de conversão não suportado");

        switch (tipo) {
            case QuilimetrosParaMilhas:
                resultado = valor * quilometrosEmMilhas;
                break;
            case MilhasParaQuilometros:
            default:
                resultado = valor * milhasEmQuilometros;
                break;
        }

        return resultado;
    }

}