/**
 * Calcula o valor final de um atendimento: soma os procedimentos
 * e delega o desconto à regra escolhida pela fábrica.
 */
public class CalculadoraValorAtendimento {

    public double calcularValorFinal(int tipoAtendimento,
                                     double[] procedimentosRealizados,
                                     boolean aplicarTaxaFixa) {
        double valorTotal = somar(procedimentosRealizados);
        RegraDesconto regra = FabricaRegraDesconto.criar(tipoAtendimento, aplicarTaxaFixa);
        return regra.aplicar(valorTotal);
    }

    private double somar(double[] procedimentosRealizados) {
        double soma = 0;
        for (double valor : procedimentosRealizados) {
            soma += valor;
        }
        return soma;
    }
}
