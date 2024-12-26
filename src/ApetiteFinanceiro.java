package pansa.src;

public enum ApetiteFinanceiro {
    INDIFERENTE(0),
    CONSERVADOR(0.40),
    MERCENARIO(0.80);

    private final double percentual;

    ApetiteFinanceiro(double percentual) {
        this.percentual = percentual;
    }

    public double getPercentual() {
        return percentual;
    }
}
