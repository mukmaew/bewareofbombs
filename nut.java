package project01;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class nut {
    //1000,800
    int state = 1;
    int pasueg = 0;
    Image img;
    public int x =  (int) (Math.random() * 900)+20;
    public int y =   100;
    public int count = 0;
    nut() {
        String imageLocation = "nut.gif";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if(state == 1){
                    y += 3;
                }
                else if(state==2){
                    y += 8;
                }
                else if(state == 3){
                    y += 12;
                }
                if (y > 800) {
                    img = null;
                    runner.stop();
                }
                try {
                    runner.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y,55,55));
    }
}
