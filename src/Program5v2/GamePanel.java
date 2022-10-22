package Program5v2;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class GamePanel extends JPanel {
    private Game game;
    private boolean [] key = new boolean[4];
    // key[0] is the left arrow, key[1] is right, key[2] is up, key[3] is down

    public GamePanel( Game g ) {
        game = g;
        setBackground( Color.ORANGE );
        setBorder( BorderFactory.createLineBorder(Color.BLACK ) );

        addKeyListener( new Listen() );
        setFocusable(true); // very important
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); 
        game.draw( g );
    }

    private class Listen extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                key[0] = true;
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                key[1] = true;
            else if (e.getKeyCode() == KeyEvent.VK_UP)
                key[2] = true;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                key[3] = true;

            game.updatePlayerMotion( calculateDx(), calculateDy() );
        }

        @Override
        public void keyReleased(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                key[0] = false;
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                key[1] = false;
            else if (e.getKeyCode() == KeyEvent.VK_UP)
                key[2] = false;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                key[3] = false;

            game.updatePlayerMotion( calculateDx(), calculateDy() );
        }

        private int calculateDx(){
            int dx = 0;
            if ( key[0] )   // left arrow pressed
                dx = dx - 3;
            if ( key[1] )    // right arrow pressed
                dx = dx + 3;

            return dx;
        }

        private int calculateDy(){
            int dy = 0;
            if ( key[2] )   // up arrow pressed
                dy = dy - 3;
            if ( key[3] )    // down arrow pressed
                dy = dy + 3;

            return dy;
        }

    }
}