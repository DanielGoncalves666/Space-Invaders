package space.invaders.pkg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class janelaJogo3 extends JFrame implements ActionListener{
    private JPanel painel = pinta();
    private JButton pausadoLabel = new JButton();
    private JButton scoreLabel = new JButton();
    private JButton vidasLabel = new JButton();
    
    private Timer timer;
    
    public boolean isDificuldadeNormal;
    public boolean isPausado;
    private int movimento;
    private naveJogador jogador;
    
    public janelaJogo3(menuInicial mu)
    {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setSize(600,600);
        
        this.isDificuldadeNormal = mu.isDificuldadeNormal;
        this.isPausado = false;
        this.movimento = 0;
        jogador = new naveJogador(500 / 2, 500 - 40, 40,30);
        
        scoreLabel.setText("0");
        pausadoLabel.setText("PAUSADO");
        vidasLabel.setText("Vidas = 3");
        
        
        this.setFocusable(true);
        painel.setDoubleBuffered(true);
        painel.setVisible(true);
        painel.setSize(500, 500);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(scoreLabel,gbc);
        
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(pausadoLabel,gbc);
        
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(vidasLabel,gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridheight = GridBagConstraints.RELATIVE;
        gbc.ipadx = 500;
        gbc.ipady = 500; 
        this.add(painel,gbc);
        
       

        
       

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
        addKeyListener(new Teclou());
               
        timer = new Timer(5, this);
        timer.start();
    }
  
    
    
    
    
    
    
    
    
    
    public JPanel pinta()
    {
        JPanel painel;
        painel = new JPanel()
        {
            @Override
            public void paint(Graphics g){
                g.setColor(Color.blue);
                Graphics2D imagens = (Graphics2D) g;
                imagens.fillRect(0, 0, 500, 500);
                imagens.drawImage(jogador.getImagem(), jogador.x, jogador.y, this);
                g.dispose();
            }
        };
        
        return painel;
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
                    movimento = -3;
                    break;
                case KeyEvent.VK_D:
                    movimento = 3;
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