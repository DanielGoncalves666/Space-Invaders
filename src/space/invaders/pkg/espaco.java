package space.invaders.pkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class espaco extends JPanel implements ActionListener{
    
    public boolean isDificuldadeNormal;
    public boolean isPausado;
    private int movimento;
    private naveJogador jogador;
    
    // verificar
    private Timer timer;
    
    public espaco(janelaJogo2 jj){
        
        this.isDificuldadeNormal = jj.isDificuldadeNormal;
        this.isPausado = false;
        setFocusable(true);
        setDoubleBuffered(true);
        setVisible(true);
        
        //jogador = new naveJogador(500 / 2, 500 - 40, 40, 30);
        jogador = new naveJogador(500 / 2, 500 - 40, 40,30);
        movimento = 0;
        
        addKeyListener(new Teclou());
        
       timer = new Timer(5, this);
       timer.start();
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.blue);
        Graphics2D imagens = (Graphics2D) g;
        imagens.fillRect(0, 0, 520, 500);
        imagens.drawImage(jogador.getImagem(), jogador.x, jogador.y, this);
        g.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        jogador.movimento(movimento,true);
        repaint();
    }

    
    private class Teclou extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            int tecla = e.getKeyCode();

            switch (tecla) {
                case KeyEvent.VK_A:
                    movimento = -1;
                    break;
                case KeyEvent.VK_D:
                    movimento = 1;
                    break;
                case KeyEvent.VK_SPACE:

                    break;
                case KeyEvent.VK_P:
                    // pausa o jogo. Chama o menu de pause e trava o jogo.

                    //PausadoLabel.setVisible(true);
                    //menuPausa mp = new menuPausa(this);
                    break;
                default:
                    break;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e)
        {
            int tecla = e.getKeyCode();

            switch (tecla) {
                case KeyEvent.VK_A:
                    movimento = 0;
                    break;
                case KeyEvent.VK_D:
                    movimento = 0;
                    break;
                case KeyEvent.VK_SPACE:

                    break;
                default:
                    break;
            }
        }
    }
}