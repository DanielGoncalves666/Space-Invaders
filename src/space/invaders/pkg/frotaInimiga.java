package space.invaders.pkg;

import java.util.HashMap;

/**
 * Classe que realiza o controle sobre todas as naves inimigas (exceto a nave de evento especial)
 */
public class frotaInimiga {
    // cada nave inimiga possui dimensões: 30px de largura e 20px de altura
    // 5 fileiras, 10 naves
    
    private HashMap<Integer,naveInimiga> fleet;
    private final int qtdFilas = 5;
    private final int qtdPorFila = 10;
    private int navesVivas[];       // qtd de naves vivas por linhas
    
    private int coordenadaXFila[]; //coordenada de cada fila (linha, sendo a primeira linha que compõe a fila) 
    private int colunaNaveAEsquerda; // armazena a coluna da nave mais a esquerda
    private int colunaNaveADireita; // armazena a coluna da nave mais a direita
    
    // esses valores precisam ser definidos corretamente
    private final int esquerdaMaximo = 10;
    private final int direitaMaximo = 1000;
    private final int baixoMinimo = 100;
    
    /* cada nave inimiga terá um código de 3 dígitos
       xyz
           x --> indica a fileira que a nave inimiga pertence. Essa fileiras são numeradas de baixo pra cima
           y e z --> indicam a numeração própria da nave

        Esse tipo de marcação talvez coloque peso na verificação de impacto dos disparos, mas a alternativa de indicar
        as coordenadas como chave coloca peso na movimentação das naves.
    
        Estamos assumindo que as filas nao tem mais que 100 naves cada.
    */
    
    // 5 fileiras, 9 naves
    public frotaInimiga(int filas, int qtdPorFila)
    {
        this.qtdFilas = filas;
        this.qtdPorFila = qtdPorFila;
        navesVivas = new int[filas];
        construirFrota();
        
    }
    
    private void construirFrota()
    {
        int entreNaves = 15; //define a quantidade de colunas que separam duas naves
        int entreLinhas = 15; // define a quantidade de linhas que separam duas filas
        int linhaInicial = 70; // linha da primeira fila
        int colunaInicial = 50; // coluna da primeira nave
        int codigo;//codigo da nave
        
        for(int i = 0; i < filas; i++)
        {
            int linha = linhaInicial + entreLinhas * i;
            coordenadaXFila[i] = linha;
            for(int h = 0; h < qtdPorFila; h++)
            {
                int coluna = colunaInicial + entreNaves * h;
                codigo = 100 * i + h;
                adicionarNave(codigo,linha,coluna);
            }
        }
    }
    
    private void alterarCoordenadaXFila(int qtd)
    {
        for(int i = 0; i < getQtdFilas(); i++)
        {
            coordenadaXFila[i] = coordenadaXFila[i] + qtd;
        }
    }
    
    public void adicionarNave(int codigo, int x, int y)
    {
        naveInimiga n = new naveInimiga(x,y);
        
        fleet.put(codigo, n);
        // no caso de uma nave com mesmo codigo, essa nave é sobreescrita.
    }
    
    public void removerNave(int codigo)
    {
        if(fleet.containsKey(codigo))
        {
            fleet.remove(codigo);
        }
        else
            throw new RuntimeException("Nave inexistente.");
    }
    
    public void recalcularVivas()
    {
        Object keyset[] = fleet.keySet().toArray();
        
        for(int i = 0; i < getQtdFilas(); i++)
        {
            navesVivas[i] = 0;
        }
        
        for(Object x : keyset)
        {
            int indice = (int)x / 100;
            navesVivas[indice]++;
        }
    }
    
    // esse método pode ser simplificado
    public void moverFrota(char c)
    {
        switch(c)
        {
            case 'e':
                if(esquerdaMaximo == colunaNaveAEsquerda)
                    throw new RuntimeException("Limite da zona de movimentação (esquerda) alcançado.");
                else
                {
                    Object keyset[] = fleet.keySet().toArray();
                    
                    for(Object x : keyset)
                    {
                        naveInimiga n = fleet.get((Integer)x);
                        n.moverHorizontal(c);
                        fleet.replace((Integer)x, n);
                    }
                }
            break;
            case 'd':
                if(direitaMaximo == colunaNaveADireita)
                    throw new RuntimeException("Limite da zona de movimentação (direita) alcançado.");
                else
                {
                    Object keyset[] = fleet.keySet().toArray();
                    
                    for(Object x : keyset)
                    {
                        naveInimiga n = fleet.get((Integer)x);
                        n.moverHorizontal(c);
                        fleet.replace((Integer)x, n);
                    }
                }
            break;
            case 'b':
                if(baixoMinimo == coordenadaXFila[getQtdFilas() - 1])
                    throw new RuntimeException("Limite da zona de movimentação (baixa) alcançado.");
                else
                {
                    int linhasAPular = 5; // quantidade de linhas q as filas descem
                    
                    Object keyset[] = fleet.keySet().toArray();
                    
                    for(Object x : keyset)
                    {
                        naveInimiga n = fleet.get((Integer)x);
                        n.moverVertical(c, linhasAPular);
                        fleet.replace((Integer)x, n);
                    }
                    
                    alterarCoordenadaXFila(linhasAPular);
                }
            break;
            default:
        }
    }

    public int getQtdFilas() {
        return qtdFilas;
    }
    
    public int getTotalVivas()
    {
        int soma = 0;
        for(int i = 0; i < getQtdFilas(); i++)
        {
            soma += navesVivas[i];
        }
        
        return soma;
    }

    public int[] getCoordenadaXFila() {
        return coordenadaXFila;
    }
}
