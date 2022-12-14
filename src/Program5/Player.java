package Program5;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Player{
    private int x, y;   // top left
    private int dx = 0, dy = 0;  // speed in the 
    private BufferedImage imgGreen, imgYellow, imgRed;
    private int health = 2;  
         // 2 means good health
         // 1 means damaged health green
         // 0 means dead

    private static final int IMG_WIDTH = 18;  // image dimensions 
    private static final int IMG_HEIGHT = 24; 
    private int panel_width, panel_height;  // size of the panel 

    public Player( int x, int y, int panel_w, int panel_h ){
        this.x = x;
        this.y = y;
        panel_width = panel_w;
        panel_height = panel_h;

        try {
            imgGreen = ImageIO.read(new File("M:\\Documents\\NetBeansProjects\\GUI Unit13\\src\\Program5/green_face.png"));
            imgYellow = ImageIO.read(new File("M:\\Documents\\NetBeansProjects\\GUI Unit13\\src\\Program5/yellow_face.png"));
            imgRed = ImageIO.read(new File("M:\\Documents\\NetBeansProjects\\GUI Unit13\\src\\Program5/red_face.png"));
        } catch (IOException e) {
            System.out.println ( e );
        }
    }

    public void setSpeed( int dx, int dy ){
        this.dx = dx;
        this.dy = dy;
    }
    
    public void hurt(){
        health--;
    }
    
    public boolean isAlive(){
        return health > 0;
    }

    public void move(){
        x += dx;
        y += dy;
        if(x<0)
            x = 0;
        else if(x>panel_width)
            x = panel_width;
        
        if(y<0)
            y = 0;
        else if(y>panel_height)
            y = panel_height;
    }

    public void draw(  Graphics g ){
        if ( health == 2 )
            g.drawImage( imgGreen, x, y, null );
        else if ( health == 1 )
            g.drawImage( imgYellow, x, y, null );
        else
            g.drawImage( imgRed, x, y, null );
    }

    public Rectangle getShape(){
        return new Rectangle( x, y, IMG_WIDTH, IMG_HEIGHT );
    }
}