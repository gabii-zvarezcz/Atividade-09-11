/**
 * Estratégia de cálculo aplicada ao valor total dos procedimentos.
 * Cada tipo de atendimento implementa a sua própria regra.
 */
public interface RegraDesconto {
    double aplicar(double valor);
}
