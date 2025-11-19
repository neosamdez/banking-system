import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        add(new GamePanel());
        setTitle("Snake Game - Matrix Edition 2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}

class GamePanel extends JPanel implements ActionListener {

    static final int LARGURA_TELA = 600;
    static final int ALTURA_TELA = 600;
    static final int TAMANHO_BLOCO = 10;
    static final int UNIDADES = (LARGURA_TELA * ALTURA_TELA) / (TAMANHO_BLOCO * TAMANHO_BLOCO);
    static final int DELAY = 75;

    final int x[] = new int[UNIDADES];
    final int y[] = new int[UNIDADES];

    int partesCorpo = 6;
    int frutasComidas;
    int frutaX;
    int frutaY;
    char direcao = 'R';
    
    // ESTADOS DO JOGO
    boolean rodando = false;
    boolean emMenu = true; // Novo estado: Começamos no menu

    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        
        // Iniciamos o timer, mas o jogo só começa quando sair do menu
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void iniciarJogo() {
        novaFruta();
        rodando = true;
        emMenu = false;
        partesCorpo = 6;
        frutasComidas = 0;
        direcao = 'R';
        
        // Zera a posição da cobra para o canto (para não nascer batendo)
        for(int i=0; i<partesCorpo; i++) {
            x[i] = 0;
            y[i] = 0;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhar(g);
    }

    public void desenhar(Graphics g) {
        
        if (emMenu) {
            desenharMenu(g);
        } else if (rodando) {
            // --- JOGO ACONTECENDO ---
            
            // Desenha Fruta
            g.setColor(Color.red);
            g.fillOval(frutaX, frutaY, TAMANHO_BLOCO, TAMANHO_BLOCO);

            // Desenha Cobra
            for (int i = 0; i < partesCorpo; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
                }
            }
            
            // Placar topo
            g.setColor(Color.white);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + frutasComidas, (LARGURA_TELA - metrics.stringWidth("Score: " + frutasComidas)) / 2, g.getFont().getSize());

        } else {
            fimDeJogo(g);
        }
    }

    public void desenharMenu(Graphics g) {
        g.setColor(Color.green); // Verde Matrix
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        String texto = "SNAKE MATRIX";
        g.drawString(texto, (LARGURA_TELA - metrics.stringWidth(texto)) / 2, ALTURA_TELA / 3);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        String msg = "Pressione ENTER para Iniciar";
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString(msg, (LARGURA_TELA - metrics2.stringWidth(msg)) / 2, ALTURA_TELA / 2);
    }

    public void novaFruta() {
        frutaX = random.nextInt((int) (LARGURA_TELA / TAMANHO_BLOCO)) * TAMANHO_BLOCO;
        frutaY = random.nextInt((int) (ALTURA_TELA / TAMANHO_BLOCO)) * TAMANHO_BLOCO;
    }

    public void mover() {
        for (int i = partesCorpo; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direcao) {
            case 'U': y[0] = y[0] - TAMANHO_BLOCO; break;
            case 'D': y[0] = y[0] + TAMANHO_BLOCO; break;
            case 'L': x[0] = x[0] - TAMANHO_BLOCO; break;
            case 'R': x[0] = x[0] + TAMANHO_BLOCO; break;
        }
    }

    public void checarFruta() {
        if ((x[0] == frutaX) && (y[0] == frutaY)) {
            partesCorpo++;
            frutasComidas++;
            novaFruta();
        }
    }

    public void checarColisoes() {
        // Verifica corpo
        for (int i = partesCorpo; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                rodando = false;
            }
        }
        // Verifica bordas
        if (x[0] < 0 || x[0] > LARGURA_TELA || y[0] < 0 || y[0] > ALTURA_TELA) {
            rodando = false;
        }
        
        if (!rodando) {
            timer.stop();
        }
    }

    public void fimDeJogo(Graphics g) {
        // Texto Game Over
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (LARGURA_TELA - metrics.stringWidth("Game Over")) / 2, ALTURA_TELA / 3);
        
        // Placar Final
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score Final: " + frutasComidas, (LARGURA_TELA - metrics2.stringWidth("Score Final: " + frutasComidas)) / 2, ALTURA_TELA / 2);

        // Instrução para reiniciar
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        String msg = "Pressione ESPAÇO para Recomeçar";
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString(msg, (LARGURA_TELA - metrics3.stringWidth(msg)) / 2, ALTURA_TELA / 2 + 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (rodando) {
            mover();
            checarFruta();
            checarColisoes();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            
            // Lógica do MENU
            if (emMenu) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    iniciarJogo();
                }
            } 
            // Lógica do GAME OVER (Reiniciar)
            else if (!rodando) { 
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    iniciarJogo();
                    timer.start(); // Reinicia o timer que parou no Game Over
                }
            } 
            // Lógica do JOGO (Movimentação)
            else {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (direcao != 'R') direcao = 'L';
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direcao != 'L') direcao = 'R';
                        break;
                    case KeyEvent.VK_UP:
                        if (direcao != 'D') direcao = 'U';
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direcao != 'U') direcao = 'D';
                        break;
                }
            }
        }
    }
}