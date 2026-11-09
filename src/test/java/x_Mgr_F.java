// Código legado original (mantido apenas como "oráculo" nos testes).
public class x_Mgr_F {
    // tp = 1 (Convênio), tp = 2 (Particular)
    public double calc(int tp, double[] vls, boolean st) {
        double r = 0;
        for (int i = 0; i < vls.length; i++) {
            r += vls[i];
        }

        if (tp == 1) {
            r = r - (r * 0.12);
            if (st) {
                r += 15.50;
            }
        } else if (tp == 2) {
            if (r > 500) {
                r = r - (r * 0.05);
            }
        }
        return r; // println de log omitido para não poluir a saída dos testes
    }
}
