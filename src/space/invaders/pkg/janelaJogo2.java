package space.invaders.pkg;

import javax.swing.JPanel;

public class janelaJogo2 extends javax.swing.JFrame {
    public boolean isDificuldadeNormal;
    public boolean isPausado;
    public JPanel espacial;
    
    public janelaJogo2(menuInicial mu) {
        this.isDificuldadeNormal = mu.isDificuldadeNormal;
        this.isPausado = false;

        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        espacial = (JPanel) add(new espaco(this));
        
    }
}
