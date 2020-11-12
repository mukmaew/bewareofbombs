package project01;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class gameplay extends JPanel {
    int keyX;
    int keyY;
    int form = 1;
    int state = 1;
    ImageIcon imgover = new ImageIcon(this.getClass().getResource("ABG5.jpg"));
    ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("ABG2.jpg"));
    ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("ABG3.jpg"));
    ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("ABG4.png"));
    ImageIcon pause = new ImageIcon(this.getClass().getResource("pause1.png"));
    ImageIcon resume = new ImageIcon(this.getClass().getResource("play-button.png"));
    ImageIcon close = new ImageIcon(this.getClass().getResource("logout.png"));
    ImageIcon close1 = new ImageIcon(this.getClass().getResource("exit3.png"));
    ImageIcon orcdead = new ImageIcon(this.getClass().getResource("died.png"));
    ImageIcon restart = new ImageIcon(this.getClass().getResource("restart111.png"));
    ImageIcon rain = new ImageIcon(this.getClass().getResource("rain.gif"));
    ImageIcon bird = new ImageIcon(this.getClass().getResource("bird.gif"));

    
    orc aa = new orc();
    JLabel Tscore = new JLabel();
    ArrayList<nut> nut1 = new ArrayList<nut>();
    ArrayList<apple> apple1 = new ArrayList<apple>();
    ArrayList<coconut> coconut1 = new ArrayList<coconut>();
    ArrayList<banana> banana1 = new ArrayList<banana>();
    ArrayList<missile> missile = new ArrayList<missile>();
    ArrayList<heal> heal = new ArrayList<heal>();
    ArrayList<timeplus> timeplus = new ArrayList<timeplus>();
   
    int times;
    int HP;
    boolean timestart;
    boolean startf;
    int score = 0;
    int pauseg;
    Thread all = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                    }
                    repaint();
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tnut = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (pauseg == 0) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        nut1.add(new nut());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tapple = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        apple1.add(new apple());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tcoconut = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        coconut1.add(new coconut());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tbanana = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        banana1.add(new banana());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread tmissile = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            if (state == 1) {
                                Thread.sleep(3000);
                            } else if (state == 2) {
                                Thread.sleep(2000);
                            } else if (state == 3) {
                                Thread.sleep(1000);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        missile.add(new missile());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread theal = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 30000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        heal.add(new heal());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread ttimeplus = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    try {
                        if (startf == false) {
                            Thread.sleep((long) (Math.random() * 10000) + 20000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (startf == false) {
                        timeplus.add(new timeplus());
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    Thread t = new Thread(new Runnable() {
        public void run() {
            if (pauseg == 0) {
                while (true) {
                    if (timestart == false) {
                        times = (times - 1);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    //====================================================================================================================================================
    gameplay() {
        this.setFocusable(true);
        this.setLayout(null);
        this.add(Tscore);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if(pauseg == 1){
                    System.out.println(pauseg);
                if (a == KeyEvent.VK_LEFT) {
                    aa.x -= 10;
                    form = 1;
                } else if (a == KeyEvent.VK_RIGHT) {
                    aa.x += 10;
                    form = 0;
                }
                if (aa.count > 3) {
                    aa.count = 0;
                }
                }
            }
            public void keyReleased(KeyEvent e) {
                aa.count = 0;
            }
        });
        aa.x = 400;
        all.start();
        t.start();
        tnut.start();
        tmissile.start();
        tcoconut.start();
        tbanana.start();
        theal.start();
        ttimeplus.start();
        tapple.start();
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
                if (keyX >= 850 && keyX <= 890 && keyY >= 30 && keyY <= 70) {
                    System.exit(0);
                } 
                else if (keyX >= 850 && keyX <= 890 && keyY >= 100 && keyY <= 140) {
                    pauseg = 0;
                    setSize(1000, 800);
                    requestFocusInWindow();
                    System.out.println(pauseg);
                    t.suspend();
                    all.suspend();
                    tnut.suspend();
                    tcoconut.suspend();
                    tbanana.suspend();
                    tmissile.suspend();
                    theal.suspend();
                    ttimeplus.suspend();
                    tapple.suspend();
                    if (!coconut1.isEmpty()) {
                        for (int i = 0; i < coconut1.size(); i++) {
                            coconut1.get(i).runner.suspend();
                        }
                    }
                    if (!nut1.isEmpty()) {
                        for (int i = 0; i < nut1.size(); i++) {
                            nut1.get(i).runner.suspend();
                        }
                    }
                    if (!banana1.isEmpty()) {
                        for (int i = 0; i < banana1.size(); i++) {
                            banana1.get(i).runner.suspend();
                        }
                    }
                    if (!missile.isEmpty()) {
                        for (int i = 0; i < missile.size(); i++) {
                            missile.get(i).runner.suspend();
                        }
                    }
                    if (!heal.isEmpty()) {
                        for (int i = 0; i < heal.size(); i++) {
                            heal.get(i).runner.suspend();
                        }
                    }
                    if (!timeplus.isEmpty()) {
                        for (int i = 0; i < timeplus.size(); i++) {
                            timeplus.get(i).runner.suspend();
                        }
                    }
                    if (!apple1.isEmpty()) {
                        for (int i = 0; i < apple1.size(); i++) {
                            apple1.get(i).runner.suspend();
                        }
                    }
                } else if (keyX >= 850 && keyX <= 890 && keyY >= 165 && keyY <= 210) {
                    setSize(1000, 800);
                    requestFocusInWindow();
                    pauseg = 1;
                    System.out.println(pauseg);
                    t.resume();
                    all.resume();
                    tnut.resume();
                    tcoconut.resume();
                    tbanana.resume();
                    tmissile.resume();
                    theal.resume();
                    ttimeplus.resume();
                    tapple.resume();
                    if (!coconut1.isEmpty()) {
                        for (int i = 0; i < coconut1.size(); i++) {
                            coconut1.get(i).runner.resume();;
                        }
                    }
                    if (!nut1.isEmpty()) {
                        for (int i = 0; i < nut1.size(); i++) {
                            nut1.get(i).runner.resume();;
                        }
                    }
                    if (!banana1.isEmpty()) {
                        for (int i = 0; i < banana1.size(); i++) {
                            banana1.get(i).runner.resume();;
                        }
                    }
                    if (!missile.isEmpty()) {
                        for (int i = 0; i < missile.size(); i++) {
                            missile.get(i).runner.resume();;
                        }
                    }
                    if (!heal.isEmpty()) {
                        for (int i = 0; i < heal.size(); i++) {
                            heal.get(i).runner.resume();;
                        }
                    }
                    if (!timeplus.isEmpty()) {
                        for (int i = 0; i < timeplus.size(); i++) {
                            timeplus.get(i).runner.resume();;
                        }
                    }
                    if (!apple1.isEmpty()) {
                        for (int i = 0; i < apple1.size(); i++) {
                            apple1.get(i).runner.resume();;
                        }
                    }
                } else if (keyX >= 490 && keyX <= 570 && keyY >= 510 && keyY <= 600) {
                    home bb = new home();
                    setSize(1000, 800);
                    add(bb);
                    bb.setBounds(0, 0, 1000, 800);
                    bb.setFocusable(true);
                    bb.requestFocusInWindow();
                } else if (keyX >= 645 && keyX <= 715 && keyY >= 515 && keyY <= 600) {
                    System.exit(0);
                }
            }
        });
    }
    
//===================================================================================================================================================================================================    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ( HP <= 0) {
            this.setLayout(null);
            g.drawImage(imgover.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.BLACK);
            
            g.drawImage(bird.getImage(), 100, 200, 500, 364, this);
            
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 60));
            g.drawString("SCORE   " + score, 200, 250);
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 120));
            g.drawString("YOU LOSE", 100, 150);
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 60));
            g.drawString("GAME OVER" , 150, 350);
            //===========================================================================================================
            g.drawImage(orcdead.getImage(), 100, 350, 400, 400, this);
            g.drawImage(restart.getImage(), 494, 520, 75, 75, this);
            g.drawImage(close1.getImage(), 645, 520, 75, 75, this);
          
        } 
        
        else if (times < 0 && HP>0 && score > 0) {
            this.setLayout(null);
            g.drawImage(imgover.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.BLACK);
            
            g.drawImage(rain.getImage(), 0, 0, 500, 500, this);
            
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 60));
            g.drawString("SCORE   " + score, 200, 250);
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 120));
            g.drawString("YOU WIN", 100, 150);
            //===========================================================================================================
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 60));
            g.drawString("GAME OVER" , 150, 350);
            //===========================================================================================================
            
            g.drawImage(restart.getImage(), 494, 520, 75, 75, this);
            g.drawImage(close1.getImage(), 645, 520, 75, 75, this);
        } 
//=====================================state2====================================================================================================================================================        
        //else if (score >= 300 && score < 500) {
        else if (score >= 100 && score < 300) {
            state = 2;
            g.drawImage(imgstate2.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(pause.getImage(), 850, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 850, 170, 40, 40, this);
            g.drawImage(close.getImage(), 850, 30, 40, 40, this);
            g.drawImage(aa.imorc[form].getImage(), aa.x, aa.y, 300, 240, this);
            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //    ================================================nut===============================================================================================================================
            for (int i = 0; i < nut1.size(); i++) {
                nut1.get(i).state = 2;
                g.drawImage(nut1.get(i).getImage(), nut1.get(i).getX(), nut1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < nut1.size(); i++) {
                if (Intersect(aa.getbound(), nut1.get(i).getbound())) {
                    nut1.remove(i);
                    score += 10;
                    g.drawString("+10", aa.x + 10, 650);
                }
                if(nut1.get(i).getX() > 800){
                    nut1.remove(i);
                }
            }
            //====================apple========================================================================================================================================================
            for (int i = 0; i < apple1.size(); i++) {
                apple1.get(i).state = 2;
                g.drawImage(apple1.get(i).getImage(), apple1.get(i).getX(), apple1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < apple1.size(); i++) {
                if (Intersect(aa.getbound(), apple1.get(i).getbound())) {
                    apple1.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
                if(apple1.get(i).getX() > 800){
                    apple1.remove(i);
                }
            }
            //===========coconut================================================================================================================================================================
            for (int i = 0; i < coconut1.size(); i++) {
                coconut1.get(i).state = 2;
                g.drawImage(coconut1.get(i).getImage(), coconut1.get(i).getX(), coconut1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < coconut1.size(); j++) {
                if (Intersect(aa.getbound(), coconut1.get(j).getbound())) {
                    coconut1.remove(j);
                    score += 20;
                    g.drawString("+20", aa.x + 100, 650);
                }
                if(coconut1.get(j).getX() > 800){
                    coconut1.remove(j);
                }
            }
            //===========banana1================================================================================================================================================================
            for (int i = 0; i < banana1.size(); i++) {
                banana1.get(i).state = 2;
                g.drawImage(banana1.get(i).getImage(), banana1.get(i).getX(), banana1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < banana1.size(); j++) {
                if (Intersect(aa.getbound(), banana1.get(j).getbound())) {
                    banana1.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(banana1.get(j).getX() > 800){
                    banana1.remove(j);
                }
            }
            //===========================missile================================================================================================================================================
            for (int i = 0; i < missile.size(); i++) {
                missile.get(i).state = 2;
                g.drawImage(missile.get(i).getImage(), missile.get(i).getX(), missile.get(i).getY(), 75, 200, this);
            }
            for (int j = 0; j < missile.size(); j++) {
                if (Intersect(aa.getbound(), missile.get(j).getbound())) {
                    missile.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
                if(missile.get(j).getX() > 800){
                    missile.remove(j);
                }
            }
            //boss
            
            //==================================heal================================================================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                heal.get(i).state = 2;
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(aa.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
                if(heal.get(j).getX() > 800){
                    heal.remove(j);
                }
            }
            //=====================================timeplus===============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                timeplus.get(i).state = 2;
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(aa.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
                if(timeplus.get(j).getX() > 800){
                    timeplus.remove(j);
                }
            }
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.BLACK);
            g.drawString("SCORE =  " + score, 30, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 2, 350, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 375, 200);
            g.drawString("HP  " + HP, 50, 200);
        } 
// =====================================state 3===============================================================================================================
        //else if (score >= 500) {
        else if (score >= 300) {
            state = 3;
            
            g.drawImage(imgstate3.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(pause.getImage(), 850, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 850, 170, 40, 40, this);
            g.drawImage(close.getImage(), 850, 30, 40, 40, this);
            g.drawImage(aa.imorc[form].getImage(),aa.x, aa.y, 300, 240, this);
            g.drawImage(rain.getImage(), 0, 0, 1000, 800, this);
            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //================================================nut1==========================================================================================
            for (int i = 0; i < nut1.size(); i++) {
                nut1.get(i).state = 3;
                g.drawImage(nut1.get(i).getImage(), nut1.get(i).getX(), nut1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < nut1.size(); i++) {
                if (Intersect(aa.getbound(), nut1.get(i).getbound())) {
                    nut1.remove(i);
                    score += 100;
                    g.drawString("+10", aa.x + 100, 650);
                }
                if(nut1.get(i).getX() > 800){
                    nut1.remove(i);
                }
            }
            // ================================================apple==========================================================================================
            for (int i = 0; i < apple1.size(); i++) {
                apple1.get(i).state = 3;
                g.drawImage(apple1.get(i).getImage(), apple1.get(i).getX(), apple1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < apple1.size(); i++) {
                if (Intersect(aa.getbound(), apple1.get(i).getbound())) {
                    apple1.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
                if(apple1.get(i).getX() > 800){
                    apple1.remove(i);
                }
            }
            //================================================coconut==========================================================================================
            for (int i = 0; i < coconut1.size(); i++) {
                coconut1.get(i).state = 3;
                g.drawImage(coconut1.get(i).getImage(), coconut1.get(i).getX(), coconut1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < coconut1.size(); j++) {
                if (Intersect(aa.getbound(), coconut1.get(j).getbound())) {
                    coconut1.remove(j);
                    score += 20;
                    g.drawString("+20", aa.x + 100, 650);
                }
                if(coconut1.get(j).getX() > 800){
                    coconut1.remove(j);
                }
            }
            //================================================banana==========================================================================================
            for (int i = 0; i < banana1.size(); i++) {
                banana1.get(i).state = 3;
                g.drawImage(banana1.get(i).getImage(), banana1.get(i).getX(), banana1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < banana1.size(); j++) {
                if (Intersect(aa.getbound(), banana1.get(j).getbound())) {
                    banana1.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
                if(banana1.get(j).getX() > 800){
                    banana1.remove(j);
                }
            }
            //=====================================missile===============================================================================================================
            for (int i = 0; i < missile.size(); i++) {
                missile.get(i).state = 3;
                g.drawImage(missile.get(i).getImage(), missile.get(i).getX(), missile.get(i).getY(), 75, 200, this);
            }
            for (int j = 0; j < missile.size(); j++) {
                if (Intersect(aa.getbound(), missile.get(j).getbound())) {
                    missile.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
                if(missile.get(j).getX() > 800){
                    missile.remove(j);
                }
            }
            
            //==================================heal============================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                heal.get(i).state = 3;
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(aa.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
                if(heal.get(j).getX() > 800){
                    heal.remove(j);
                }
            }
            //=================================timeplus============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                timeplus.get(i).state = 3;
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(aa.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
                if(timeplus.get(j).getX() > 800){
                    timeplus.remove(j);
                }
            }
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.WHITE);
            g.drawString("SCORE =  " + score, 30, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 3, 350, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 375, 200);
            g.drawString("HP  " + HP, 50, 200);
        } 
// =====================================state 1===============================================================================================================        
        else {
            g.drawImage(imgstate1.getImage(), 0, 0, 1000, 800, this);
            g.drawImage(pause.getImage(), 850, 100, 40, 40, this);
            g.drawImage(resume.getImage(), 850, 170, 40, 40, this);
            g.drawImage(close.getImage(), 850, 30, 40, 40, this);
            g.drawImage(aa.imorc[form].getImage(), aa.x, aa.y, 300, 240, this);

            if (aa.x <= -200) {
                aa.x = this.getWidth() - 20;
            }
            if (aa.x > this.getWidth() + 20) {
                aa.x = -100;
            }
            //==============================================coconut1============================================================================================================================
            for (int i = 0; i < coconut1.size(); i++) {
                g.drawImage(coconut1.get(i).getImage(), coconut1.get(i).getX(), coconut1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < coconut1.size(); j++) {
                if (Intersect(aa.getbound(), coconut1.get(j).getbound())) {
                    coconut1.remove(j);
                    score += 50;
                    g.drawString("+50", aa.x + 100, 650);
                }
            }
            //==================================apple=============================================================================================================================
            for (int i = 0; i < apple1.size(); i++) {
                apple1.get(i).state = 1;
                g.drawImage(apple1.get(i).getImage(), apple1.get(i).getX(), apple1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < apple1.size(); i++) {
                if (Intersect(aa.getbound(), apple1.get(i).getbound())) {
                    apple1.remove(i);
                    score += 50;
                    g.drawString("+50", aa.x + 10, 650);
                }
            }
            //========================================banana============================================================================================================================
            for (int i = 0; i < banana1.size(); i++) {
                g.drawImage(banana1.get(i).getImage(), banana1.get(i).getX(), banana1.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < banana1.size(); j++) {
                if (Intersect(aa.getbound(), banana1.get(j).getbound())) {
                    banana1.remove(j);
                    score += 30;
                    g.drawString("+30", aa.x + 100, 650);
                }
            }
            //=================================nut1============================================================================================================================
            for (int i = 0; i < nut1.size(); i++) {
                g.drawImage(nut1.get(i).getImage(), nut1.get(i).getX(), nut1.get(i).getY(), 75, 75, this);
            }
            for (int i = 0; i < nut1.size(); i++) {
                if (Intersect(aa.getbound(), nut1.get(i).getbound())) {
                    nut1.remove(i);
                    score += 10;
                    g.drawString("+10", aa.x + 100, 650);
                }
            }
            //=====================================missile===============================================================================================================
            for (int i = 0; i < missile.size(); i++) {
                //g.drawRect(missile.get(i).getX(),missile.get(i).getY(),65,175);
                g.drawImage(missile.get(i).getImage(), missile.get(i).getX(), missile.get(i).getY(), 75, 200, this);
            }
            for (int j = 0; j < missile.size(); j++) {
                if (Intersect(aa.getbound(), missile.get(j).getbound())) {
                    missile.remove(j);
                    score -= 20;
                    HP -= 1;
                    g.drawString("-1HP", aa.x + 100, 580);
                    g.drawString("-20", aa.x + 100, 650);
                }
            }
            
            //=====================================heal===============================================================================================================
            for (int i = 0; i < heal.size(); i++) {
                g.drawImage(heal.get(i).getImage(), heal.get(i).getX(), heal.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < heal.size(); j++) {
                if (Intersect(aa.getbound(), heal.get(j).getbound())) {
                    heal.remove(j);
                    HP += 1;
                    g.drawString("+1HP", aa.x + 100, 580);
                }
            }
            //=====================================timeplus===============================================================================================================
            for (int i = 0; i < timeplus.size(); i++) {
                g.drawImage(timeplus.get(i).getImage(), timeplus.get(i).getX(), timeplus.get(i).getY(), 75, 75, this);
            }
            for (int j = 0; j < timeplus.size(); j++) {
                if (Intersect(aa.getbound(), timeplus.get(j).getbound())) {
                    timeplus.remove(j);
                    times += 20;
                }
            }
            
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 50));
            g.setColor(Color.WHITE);
            g.drawString("SCORE =  " + score, 30, 100);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 80));
            g.drawString("STATE " + 1, 350, 110);
            g.setFont(new Font("2005_iannnnnCTX 9001", Font.HANGING_BASELINE, 65));
            g.drawString("Time " + times, 375, 200);
            g.drawString("HP  " + HP, 50, 200);
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }
}