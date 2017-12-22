import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    // variables used to draw rectangles at different locations
    int mX1  = 20;
    int mY1 = 120;
    
    int mX2 = 560;
    int mY2 = 120;
    
    int mX = 200;
    int mY = 0;
    // overriding paintComponent method
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLUE);
        // Left Racket
        g2.fillRect(mX1, mY1, 5, 40);
        //Right Racket
        g2.fillRect(mX2, mY2, 5, 40);
        
        g2.setColor(Color.red);
        g2.fillOval(mX, mY, 20, 20);
        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 25));
        g2.drawString("0", 30, 340); // Set string on left bottom corner for left palyer score
        g2.drawString("0", 540, 340); // Set string on Right bottom corner for Right palyer score
    }
}
