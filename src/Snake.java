import java.awt.*;

public class Snake {
    private int[][] body = new int[1][2];
    private Color headColor = Color.BLUE;
    private Color bodyColor = Color.GREEN;
    private final int partSize = 25;
    private boolean moveLeft, moveRight, moveUp, moveDown;

    Snake() {
        setHead(0, 0);
    }

    public void display(Graphics2D graphics2D) {
        for(int partIndex=0; partIndex<this.body.length; partIndex++) {
            if(partIndex==0) {
                graphics2D.setColor(this.headColor);
            } else {
                graphics2D.setColor(this.bodyColor);
            }
            graphics2D.fillRect(this.body[partIndex][0]*this.partSize, this.body[partIndex][1]*this.partSize, this.partSize, this.partSize);
        }
    }

    public void setHead(int xPosition, int yPosition) {
        int[] head = this.body[0];
        head[0] = xPosition;
        head[1] = yPosition;
    }

    public void moveHead(int xPosition, int yPosition) {
        int[] head = this.body[0];
        head[0] += xPosition;
        head[1] += yPosition;
        this.handleTeleportation(head);
    }

    public void handleTeleportation(int[] head) {
        if(head[0] > 850/25) {
            head[0] = 0;
        }                 // right edge
        if(head[0] < 0) {
            head[0] = 850/25;
        }                      // left edge
        if(head[1] > 850/25) {
            head[1] = 0;
        }                 // bottom edge
        if(head[1] < 0) {
            head[1] = 850/25;
        }                      // top edge
    }

    public boolean getMoveUp() {
        return this.moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public boolean getMoveDown() {
        return this.moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public boolean getMoveLeft() {
        return this.moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean getMoveRight() {
        return this.moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

}
