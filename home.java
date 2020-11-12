package project01;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import sun.audio.*;
public class home extends JPanel {
    ImageIcon homebackground = new ImageIcon(this.getClass().getResource("01.jpg"));
    ImageIcon exit = new ImageIcon(this.getClass().getResource("Pexitt.png"));
    ImageIcon SS = new ImageIcon(this.getClass().getResource("Sakura.gif"));
    ImageIcon starts = new ImageIcon(this.getClass().getResource("Start.png"));
    gameplay playgame = new gameplay();
    int keyX;
    int keyY;

    home() {
        setLayout(null);
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                keyX = e.getX();
                keyY = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (keyX >= 400 && keyX <= 600 && keyY >= 300 && keyY <= 400) {
                    setSize(1000, 800);
                    add(playgame);
                    playgame.setBounds(0, 0, 1000, 800);
                    playgame.requestFocusInWindow();
                    playgame.timestart = false;
                    playgame.score = 0;
                    playgame.HP = 3;
                    playgame.times = 60;
                    playgame.startf = false;
                    playgame.timestart = false;
                    playgame.pauseg = 1;
                } else if (keyX >= 400 && keyX <= 500 && keyY >= 400 && keyY <= 500) {
                    System.exit(0);
                }
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(homebackground.getImage(), 0, 0, 1000, 800, this);
        g.drawImage(SS.getImage(), 0, 0, 500, 500, this);
        g.drawImage(SS.getImage(), 500, 0, 500, 500, this);
        g.drawImage(exit.getImage(), 400, 400, 150, 100, this);
        g.drawImage(starts.getImage(), 400, 300, 150, 100, this);
    }
}
