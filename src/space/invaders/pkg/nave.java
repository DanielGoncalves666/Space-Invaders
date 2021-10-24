package space.invaders.pkg;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public abstract class nave extends Rectangle{

    protected Image imagem;
    
    public nave(int x, int y, int width, int height)
    {
        super(x,y,width,height);
    }
    
    public void loadImagem(String caminho)
    {
        ImageIcon sprite = new ImageIcon(caminho);
        imagem = sprite.getImage();
    }
    
    public Image getImagem()
    {
        return imagem;
    }
    
    // true pra horizontal, false pra vertical
    public void movimento(int qtd, boolean direcao)
    {
        if(direcao)
        {
            if(0 <= x + qtd && x + qtd < 480)
                this.setLocation(x + qtd, y);
        }
        else
        {
            if(y - qtd + 20 >= 120)
                this.setLocation(x, y + qtd);
        }
    }
    
    
    public abstract disparo criarDisparo();
}
