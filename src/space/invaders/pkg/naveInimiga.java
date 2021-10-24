package space.invaders.pkg;

import static java.lang.Math.ceil;

public class naveInimiga extends nave{

    private int valorScore;
    //30 de comprimeto, 20 de altura
    public naveInimiga(int x, int y, int width, int height, int valorScore, String caminho) {
        super(x, y, width, height);
        loadImagem(caminho);
        this.valorScore = valorScore;
    
    }

    @Override
    public disparo criarDisparo() {
        return new disparo(x + (int) ceil( width / 2) , y + height,-1);
    }
    
    public int getScore()
    {
        return valorScore;
    }
}