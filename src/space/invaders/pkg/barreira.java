package space.invaders.pkg;

import java.awt.Rectangle;

// esse jeito aqui n vai funcionar


public class barreira extends Rectangle{
    private static final int altura = 50;
    private static final int largura = 50;
    private int[][] mat = new int[5][5];
    
    
    // 50 por 50 pixels
    // cada seção da barreira tér 10x10 pixels
    // ou seja mat[5][5]
    
    public barreira(int x, int y, int durabilidade)
    {
        super(x,y,largura,altura);
        setDurabilidade(durabilidade);
    }
    
    public void setDurabilidade(int durabilidade)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j ++)
            {
                mat[i][j] = durabilidade;
            }
        }
    }
    
}
