/**
 * Regra do atendimento particular (tipoAtendimento = 2):
 * desconto de 5% somente quando o valor total é maior que 500.
 */
public class DescontoParticular implements RegraDesconto {
    private static final double LIMITE_DESCONTO = 500;
    private static final double PERCENTUAL_DESCONTO = 0.05;

    @Override
    public double aplicar(double valor) {
        if (valor > LIMITE_DESCONTO) {
            return valor - (valor * PERCENTUAL_DESCONTO);
        }
        return valor;
    }
}
