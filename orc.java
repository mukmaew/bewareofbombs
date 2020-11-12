package project01;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class orc {
    public ImageIcon[] imorc = new ImageIcon[2];
    public int y = 550;
    public int x;
    public int count = 0;
    orc() {
        for (int i = 0; i < imorc.length; i++) {
            String imageLocation = (i + 1) + ".gif";
            imorc[i] = new ImageIcon(this.getClass().getResource(imageLocation));
        }
    }
    public int getX() {
        return x;

    }
    public int getY() {
        return y;

    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(this.x+80,this.y+60,120,150));
    }
    
}
