package pansa.src;

import java.math.BigDecimal;

public class Atacante extends Jogador {
    private int golsFeitos;

    public Atacante(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
            ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int golsFeitos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.golsFeitos = golsFeitos;
    }

    @Override
    public BigDecimal calcularValorCompra() {
        BigDecimal valorBase = getPreco()
                .add(getPreco().multiply(BigDecimal.valueOf(getApetiteFinanceiro().getPercentual())));
        BigDecimal acrescimo = valorBase.multiply(BigDecimal.valueOf(0.01 * golsFeitos));
        valorBase = valorBase.add(acrescimo);
        if (getIdade() > 30) {
            return valorBase.multiply(BigDecimal.valueOf(0.75));
        }
        return valorBase;
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() > getReputacaoHistorica();
    }
}
