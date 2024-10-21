import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GamePanel extends JPanel implements ActionListener {

    private Snake snake;
    private Timer timer;

    GamePanel() {
        this.snake = new Snake();
        this.timer = new Timer(1_000/20, this);
        this.timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        this.render(graphics2D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.update();
        repaint();
    }

    public void render(Graphics2D graphics2D) {
        drawBackground(graphics2D, Color.BLACK);
        snake.display(graphics2D);
    }

    public void update() {
        if(this.snake.getMoveDown()) {
            this.snake.moveHead(0, 1);
        } else if(this.snake.getMoveUp()) {
            this.snake.moveHead(0, -1);
        } else if(this.snake.getMoveLeft()) {
            this.snake.moveHead(-1, 0);
        } else if(this.snake.getMoveRight()) {
            this.snake.moveHead(1, 0);
        }
    }

    public void drawBackground(Graphics2D graphics2D, Color color) {
        graphics2D.setColor(color);
        graphics2D.fillRect(0, 0, 850, 850);
    }

    public Snake getSnake() {
        return this.snake;
    }


}
