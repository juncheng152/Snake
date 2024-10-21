import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class GameFrame extends JFrame implements KeyListener {
    GamePanel panel = new GamePanel();

    GameFrame() {
        add(this.panel);
        addKeyListener(this);
        pack();
        setSize(850, 850);
        setLocationRelativeTo(null);
        setTitle("Snake");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iconImage = new ImageIcon("img/snake.png");
        setIconImage(iconImage.getImage());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            this.setDirection(true, false, false, false);
        } if(e.getKeyChar() == 'd') {
            this.setDirection(false, true, false, false);
        } if(e.getKeyChar() == 'w') {
            this.setDirection(false, false, true, false);
        } if(e.getKeyChar() == 's') {
            this.setDirection(false, false, false, true);
        }
    }

    public void setDirection(boolean moveLeft, boolean moveRight, boolean moveUp, boolean moveDown) {
        this.panel.getSnake().setMoveLeft(moveLeft);
        this.panel.getSnake().setMoveRight(moveRight);
        this.panel.getSnake().setMoveUp(moveUp);
        this.panel.getSnake().setMoveDown(moveDown);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
