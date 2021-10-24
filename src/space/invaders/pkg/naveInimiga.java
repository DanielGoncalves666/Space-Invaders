package space.invaders.pkg;

import java.awt.event.KeyEvent;

public class naveInimiga extends nave{

    protected static final int movimentoVertical = 10;

    public naveInimiga(int x, int y, int height, int width) {
        super(x, y, height, width);
    }
    
    // talvez seja uma boa unir esse metodo com o de movimento horizontal e o de tiro. Ter o tratamento de entrada em um lugar só.
    public void movimentaVertical(KeyEvent e)
    {
        int tecla = e.getKeyCode();
    
        switch(tecla)
        {
            case KeyEvent.VK_S://pra baixo     
                if(y - movimentoVertical < 0)  // precisamos adicionar uma verificação, ja q o ponto indica a esquerda superior
                    throw new IndexOutOfBoundsException();
                else
                    this.setLocation(x, y - movimentoVertical);
                break;
            case KeyEvent.VK_W:// pra cima
                if(y + movimentoVertical > 500)
                    throw new IndexOutOfBoundsException();
                else
                    this.setLocation(x, y + movimentoVertical);
                break; 
            default:
                throw new RuntimeException("Comando inválido.");
        }
    
    
    }
}
