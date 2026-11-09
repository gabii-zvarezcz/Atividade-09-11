/**
 * Demonstração: executa os casos do relatório com o código reengenheirado.
 * O log fica aqui, fora da regra de negócio.
 */
public class Main {

    public static void main(String[] args) {
        CalculadoraValorAtendimento calculadora = new CalculadoraValorAtendimento();

        int[] tipos = {1, 1, 2, 2, 3};
        boolean[] taxas = {true, false, false, false, false};
        double[][] procedimentos = {
            {200.0, 100.0},
            {200.0, 100.0},
            {600.0},
            {500.0},
            {100.0}
        };
        double[] esperados = {279.5, 264.0, 570.0, 500.0, 100.0};

        for (int i = 0; i < tipos.length; i++) {
            double resultado = calculadora.calcularValorFinal(tipos[i], procedimentos[i], taxas[i]);
            System.out.println("Caso " + (i + 1)
                    + " | tipo=" + tipos[i]
                    + " | taxa=" + taxas[i]
                    + " | resultado=" + resultado
                    + " | esperado=" + esperados[i]);
        }
    }
}
