package space.invaders.pkg;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public abstract class nave extends Rectangle{

    protected static final int movimentoHorizontal = 5;
    
    public nave(int x, int y, int height, int width)
    {
        super(x,y,width,height);
    }
    
    public void moverHorizontal(KeyEvent e)
    {
        int tecla = e.getKeyCode();
        
        switch(tecla)
        {
            case KeyEvent.VK_A:
                if(x - movimentoHorizontal < 0)
                    throw new IndexOutOfBoundsException();
                else
                    this.setLocation(x - movimentoHorizontal, y);
                break;
            case KeyEvent.VK_D:
                if(x + movimentoHorizontal > 500) // precisamos adicionar uma verificação, ja q o ponto indica a esquerda superior
                    throw new IndexOutOfBoundsException();
                else
                    this.setLocation(x + movimentoHorizontal, y);
                
                break;
            default:
                throw new RuntimeException("Comando inválido.");
        }
    }
}
