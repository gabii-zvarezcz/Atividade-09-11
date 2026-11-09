/**
 * Regra do atendimento por convênio (tipoAtendimento = 1):
 * desconto de 12% e, depois, taxa fixa de 15,50 quando aplicarTaxaFixa é verdadeiro.
 */
public class DescontoConvenio implements RegraDesconto {
    private static final double PERCENTUAL_DESCONTO = 0.12;
    private static final double TAXA_FIXA = 15.50;

    private final boolean aplicarTaxaFixa;

    public DescontoConvenio(boolean aplicarTaxaFixa) {
        this.aplicarTaxaFixa = aplicarTaxaFixa;
    }

    @Override
    public double aplicar(double valor) {
        double resultado = valor - (valor * PERCENTUAL_DESCONTO);
        if (aplicarTaxaFixa) {
            resultado += TAXA_FIXA;
        }
        return resultado;
    }
}
