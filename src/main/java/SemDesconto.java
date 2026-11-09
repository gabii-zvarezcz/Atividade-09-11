/**
 * Regra usada quando o tipo de atendimento não é convênio nem particular:
 * o valor é mantido como a soma dos procedimentos, igual ao comportamento do legado.
 */
public class SemDesconto implements RegraDesconto {
    @Override
    public double aplicar(double valor) {
        return valor;
    }
}
