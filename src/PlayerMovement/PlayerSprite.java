package PlayerMovement;

import java.awt.*;
import java.awt.Rectangle;
import java. awt.Graphics;

public class PlayerSprite extends Rectangle {
    private int dx, dy; // VELOCITY VARIABLE

    public PlayerSprite(int x, int y, int width, int height, int dx, int dy) {
        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
    }

    public void tick(int panelWidth, int panelHeight) {
        this.x += dx;
        this.y += dy;

        // HORIZONTAL BOUNDS
        if (x < 0) x = 0;
        if (x + width > panelWidth) x = panelWidth - width;

        // VERTICAL BOUNDS
        if (y < 0) y = 0;
        if (y + height > panelHeight) y = panelHeight - height;
    }// END TICK

    public void draw(Graphics g) {
        g.setColor(Color.BLUE); // MIGHT NOT WORK
        g.fillRect(this.x, this.y, this.width, this.height); // fill the rectangle for the player
    }// END DRAW 

    public void setDx(int dx) {
        this.dx = dx;
    } //END setDx

    public void setDy(int dy) {
        this.dy = dy;
    }// END setDy
    
}// END CLASS