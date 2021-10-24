package space.invaders.pkg;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class disparo extends Rectangle{
    private Image imagem;
    private int modificadorDeDirecao; // -1 para baixo, +1 para cima
    protected static final int movimentoVertical = 10;    
    private static final int altura = 20;
    private static final int largura = 3;
    
    public disparo(int x, int y, int direcao)
    {
        super(x,y,largura,altura);
        if(direcao >= 0)
        {
            modificadorDeDirecao = 1;
            loadImagem(1);
        }
        else
        {
            loadImagem(-1);
            modificadorDeDirecao = -1;
        }
    }
    
    private void loadImagem(int dir)
    {
        ImageIcon sprite;
        
        if(dir == 1)
        {
            sprite = new ImageIcon("imagens\\disparoCima.png");
        }
        else
        {
            sprite = new ImageIcon("imagens\\disparoBaixo.png");
        } 
        imagem = sprite.getImage();
    }

    public Image getImagem() {
        return imagem;
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
