package pansa.src;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class Testes {

    @Test
    public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, ApetiteFinanceiro.INDIFERENTE,
                BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertTrue(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
        Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, ApetiteFinanceiro.CONSERVADOR,
                BigDecimal.valueOf(800500), 20);

        boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel() {
        Negociacao negociacao = new Negociacao();
        Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(500000));
        Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, ApetiteFinanceiro.INDIFERENTE,
                BigDecimal.valueOf(800500), 12);

        boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

        Assert.assertFalse(foiPossivelNegociar);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Iniesta", 29, null, 9, ApetiteFinanceiro.CONSERVADOR,
                BigDecimal.valueOf(1000000));
        BigDecimal valorCompra = meioCampo.calcularValorCompra();

        Assert.assertTrue(valorCompra.compareTo(new BigDecimal("1400000.00")) == 0);
    }

    @Test
    public void deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos() {
        MeioCampo meioCampo = new MeioCampo("Iniesta", 31, null, 9, ApetiteFinanceiro.CONSERVADOR,
                BigDecimal.valueOf(1000000));
        BigDecimal valorCompra = meioCampo.calcularValorCompra();

        Assert.assertTrue(valorCompra.compareTo(new BigDecimal("980000.00")) == 0);
    }
}