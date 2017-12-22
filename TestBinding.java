import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Hassan Raza
 */
public class TestBinding implements  ActionListener {
    
    JFrame f;
    MyPanel p; // Instance of MyPanel (All graphics)
    
    int x1, y1, x2, y2;
    int x, y;
    
    public TestBinding(){
        f = new JFrame("2 Rackets Game");
        
        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());
        
        x = 5; y = 5;
        
        p = new MyPanel();
        c.add(p);
        
        f.setSize(600, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // p.addKeyListener(this);

        p.setFocusable(true);
        p.requestFocus();

        // Here we select the key we want to listen for and give it a key for the action map

        // We are saying in this map put a key stroke 'w' and when it changes
        // look for a method called p1_up in the actionMap
        p.getInputMap().put(KeyStroke.getKeyStroke('w'), "p1_up");
        p.getInputMap().put(KeyStroke.getKeyStroke('s'), "p1_down");
        p.getInputMap().put(KeyStroke.getKeyStroke("UP"), "p2_up");
        p.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "p2_down");

        final int speed = 40;

        // Here is the action map
        //
        // I'm not sure there is a better way to do this.
        // you can set the inputMap to use just one action map method
        // but I couldn't get it working with the arrow keys
        //
        // here we say when we get the action p1_up call this method
        // I used a inner method here
        //
        //                   ACTION MAP p1_up
        p.getActionMap().put("p1_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mY1 -= speed;
            }
        });

        //                   ACTION MAP p1_down
        p.getActionMap().put("p1_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mY1 += speed;
            }
        });

        //                   ACTION MAP p2_up
        p.getActionMap().put("p2_up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mY2 -= speed;
            }
        });

        //                   ACTION MAP p2_down
        p.getActionMap().put("p2_down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mY2 += speed;
            }
        });


        Timer t = new Timer(15, this);
        t.start();
        }

   



    public void keyReleased(KeyEvent e) {/*_______*/}

    public void actionPerformed(ActionEvent e){
        if (f.getWidth()-60 == p.mX){
            x = -5;
        }
        if (f.getHeight()-80 == p.mY){
            y = -3;
        }
        if(p.mX == 20){
            x = 5;
        }
        if(p.mY == 20){
            y = 3;
        }
        p.mX += x;
        p.mY += y;

        p.repaint();
    }

     public static void main(String arg[]){
        TestBinding t = new TestBinding();
    }
    
}
