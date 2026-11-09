import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculadoraValorAtendimentoTest {

    private final CalculadoraValorAtendimento calculadora = new CalculadoraValorAtendimento();
    private final x_Mgr_F legado = new x_Mgr_F();

    @Test
    void convenioComTaxaAplicaDescontoETaxa() {
        assertEquals(279.5, calculadora.calcularValorFinal(1, new double[]{200.0, 100.0}, true), 0.0);
    }

    @Test
    void convenioSemTaxaApenasDesconto() {
        assertEquals(264.0, calculadora.calcularValorFinal(1, new double[]{200.0, 100.0}, false), 0.0);
    }

    @Test
    void particularAcimaDoLimiteRecebeDesconto() {
        assertEquals(570.0, calculadora.calcularValorFinal(2, new double[]{600.0}, false), 0.0);
    }

    @Test
    void particularNoLimiteNaoRecebeDesconto() {
        assertEquals(500.0, calculadora.calcularValorFinal(2, new double[]{500.0}, false), 0.0);
    }

    @Test
    void tipoDesconhecidoMantemApenasASoma() {
        assertEquals(100.0, calculadora.calcularValorFinal(3, new double[]{100.0}, true), 0.0);
    }

    @Test
    void taxaFixaNaoVazaParaOutrosTipos() {
        assertEquals(600.0, calculadora.calcularValorFinal(99, new double[]{600.0}, true), 0.0);
        assertTrue(calculadora.calcularValorFinal(2, new double[]{100.0}, true) == 100.0);
    }

    /** Equivalência exata com o legado em várias combinações. */
    @ParameterizedTest(name = "tp={0}, vls={1}, st={2}")
    @MethodSource("cenarios")
    void novoCodigoMantemComportamentoDoLegado(int tp, double[] vls, boolean st) {
        assertEquals(legado.calc(tp, vls, st), calculadora.calcularValorFinal(tp, vls, st), 0.0);
    }

    static Stream<Arguments> cenarios() {
        double[][] listas = {
            {}, {0.0}, {10.0}, {200.0, 100.0}, {400.0, 200.0}, {100.0, 50.0},
            {500.0}, {500.01}, {250.5, 249.5}, {1234.56, 78.9, 0.1}
        };
        int[] tipos = {1, 2, 0, 3, -1, 99};
        Stream.Builder<Arguments> builder = Stream.builder();
        for (int tp : tipos) {
            for (double[] lista : listas) {
                builder.add(Arguments.of(tp, lista, true));
                builder.add(Arguments.of(tp, lista, false));
            }
        }
        return builder.build();
    }
}
