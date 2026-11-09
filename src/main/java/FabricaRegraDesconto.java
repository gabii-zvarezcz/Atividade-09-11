/**
 * Fábrica que escolhe a regra correta a partir do tipo de atendimento.
 * Novos convênios podem ser adicionados criando uma nova RegraDesconto,
 * sem alterar a calculadora (Princípio Aberto/Fechado).
 */
public class FabricaRegraDesconto {
    private static final int CONVENIO = 1;
    private static final int PARTICULAR = 2;

    public static RegraDesconto criar(int tipoAtendimento, boolean aplicarTaxaFixa) {
        if (tipoAtendimento == CONVENIO) {
            return new DescontoConvenio(aplicarTaxaFixa);
        }
        if (tipoAtendimento == PARTICULAR) {
            return new DescontoParticular();
        }
        return new SemDesconto();
    }
}
