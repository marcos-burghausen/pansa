package pansa.src;

public class Negociacao {

    public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse) {
        if (jogadorDeInteresse.temInteresseEmClube(clubeInteressado) &&
                clubeInteressado.getSaldoDisponivelEmCaixa().compareTo(jogadorDeInteresse.calcularValorCompra()) >= 0) {
            clubeInteressado.setSaldoDisponivelEmCaixa(
                    clubeInteressado.getSaldoDisponivelEmCaixa().subtract(jogadorDeInteresse.calcularValorCompra()));
            jogadorDeInteresse.setClubeAtual(clubeInteressado);
            return true;
        }
        return false;
    }
}
