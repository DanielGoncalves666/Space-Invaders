package space.invaders.pkg;

import java.awt.Rectangle;

public class disparo extends Rectangle{
    private int modificadorDeDirecao; // -1 para baixo, +1 para cima
    protected static final int movimentoVertical = 10;    
    private static final int altura = 20;
    private static final int largura = 3;
    
    public disparo(int x, int y, int direcao)
    {
        super(x,y,largura,altura);
        if(direcao >= 0)
            modificadorDeDirecao = 1;
        else
            modificadorDeDirecao = -1;
    }
    
    /**
     * Retorna true se o disparo deve ser destruido por ter atingido o fim do tabuleiro.
     * @return 
     */
    public boolean movimentarVertical()
    {
       int novoX = x + movimentoVertical * modificadorDeDirecao;
       
       if(novoX <= 0 || novoX >= 499)
           return true;
       else
       {
            x = novoX;
            return false;
       }       
    }
    
    // verifição de colisao pode ser feita na janela do jogo
}
