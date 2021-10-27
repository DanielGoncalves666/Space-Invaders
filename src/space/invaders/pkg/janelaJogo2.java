package space.invaders.pkg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class janelaJogo2 extends javax.swing.JFrame {
    public boolean isDificuldadeNormal;
    public boolean isPausado;
    public JPanel espacial;
    
    public janelaJogo2(menuInicial mu) {        
        this.isDificuldadeNormal = mu.isDificuldadeNormal;
        this.isPausado = false;
        //pausadoLabel.setText("Pausado");
        //scoreLabel.setText("0");
        
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        alinhaPanel();
        definirFrame();
        
        
        add(espacial);
    }
    
    public void definirFrame()
    {
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridwidth = 5;
        c.gridheight = 12;
       // grid.setConstraints(this, c);
            
    }
    
    
    public void alinhaPanel()
    {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        
        espacial = new espaco(this);
        //grid.setConstraints(espacial, c);
    }
}
