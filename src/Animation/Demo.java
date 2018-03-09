package Animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Demo {

    public static void main(String[] args)  {

        JFrame f1 = new JFrame();
        JPanel p1 = new JPanel();
        f1.setResizable(false);

        f1.add(p1);
        f1.setSize(500,500);

        p1.setPreferredSize(new Dimension(500,500));
        f1.pack();





        f1.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedImage dotImage;

        Graphics g = p1.getGraphics();
        g.setColor(Color.RED);

        int xCord = 100;
        int yCord = 0;
        int xvel = 2;
        int yvel = 2;
        while (true) {
            try {
                Thread.sleep(29);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            xCord += xvel;
            yCord += yvel;

            if (yCord>=400){
                yCord =400;
                yvel = -2;
                g.setColor(Color.GREEN);
            }
            if (xCord>=400){
                xCord = 400;
                xvel = -2;
                g.setColor(Color.GREEN);
            }
            if (yCord<=0){
                yCord = 0;
                yvel = 2;
                g.setColor(Color.RED);
            }
            if (xCord<=0){
                xCord = 0;
                xvel = 2;
                g.setColor(Color.RED);
            }
            try {
                URL u = Demo.class.getResource("../Resources/Capture.png");
                dotImage = ImageIO.read(u);
            } catch (IOException e) {
                System.out.println("Please Reinstall the game");
                return;
            }
            g.clearRect(0,0,500,500);
            g.fillArc(xCord, yCord, 100, 100, 0, 360);


            g.drawImage(dotImage,100,100,null);
        }
    }

}
