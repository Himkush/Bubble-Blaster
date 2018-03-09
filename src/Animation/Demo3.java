package Animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Demo3 implements KeyListener {
   private static int xCord =100;
   private static int yCord = 100;
   private static int xvel = 3;
   private static int yvel = 3;
   private static boolean up =true;




    public static void main(String[] args)  {

        JFrame f1 = new JFrame();
        JPanel p1 = new JPanel();
        f1.setResizable(false);
        f1.add(p1);
        f1.setSize(500,500);

        p1.setPreferredSize(new Dimension(500,500));
        f1.pack();




        //p1.requestFocus(true);
        Random rand = new Random();
        p1.requestFocus();


        f1.setVisible(true);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Graphics g = p1.getGraphics();
        Graphics g1 = p1.getGraphics();

        g.setColor(Color.RED);


        p1.addKeyListener(new Demo3());
        while (true) {

            try {
                Thread.sleep(29);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             //Demo3.xCord++;
            Demo3.xCord += xvel;
            Demo3.yCord += yvel;
                g1.clearRect(0,0,500,500);
                g1.setColor(Color.GREEN);
                g1.fillArc(200, 200, 50, 50, 0, 360);



            if (Demo3.xCord>=401){
                g.clearRect(0,0,500,500);
         //       g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                g.setColor(Color.GREEN);
                g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                JOptionPane.showMessageDialog(null,"Game Over");


                break;
            }
            if (Demo3.xCord<=0){
                g.clearRect(0,0,500,500);
                //       g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                g.setColor(Color.GREEN);
                g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                JOptionPane.showMessageDialog(null,"Game Over");

                break;

            }
            if (Demo3.yCord>=401){
                g.clearRect(0,0,500,500);
                //       g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                g.setColor(Color.GREEN);
                g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                JOptionPane.showMessageDialog(null,"Game Over");

                break;
            }
            if (Demo3.yCord<=0){
                g.clearRect(0,0,500,500);
                //       g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                g.setColor(Color.GREEN);
                g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);

                JOptionPane.showMessageDialog(null,"Game Over");

                break;
            }
            g.clearRect(0,0,500,500);
            g.fillArc(Demo3.xCord, Demo3.yCord, 100, 100,0, 360);


        }
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode()==KeyEvent.VK_UP){
              Demo3.xvel = 0;
              Demo3.yvel =-3;
            //  System.out.println("Hello");
            }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            Demo3.yCord += Demo3.yvel;
            Demo3.xvel = 0;
            Demo3.yvel = 3;
//            Demo3.down = true;

        }

        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            Demo3.xCord -= Demo3.yvel;
            Demo3.xvel = -3;
            Demo3.yvel = 0;

        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            Demo3.xCord += Demo3.xvel;
            Demo3.xvel = 3;
            Demo3.yvel =0;
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

