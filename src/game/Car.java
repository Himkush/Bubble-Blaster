package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Car implements KeyListener {

    private static int b1 = 0;
    private static int b2 = 150;
    private static int b3 = 300;
    private static int b4 = 450;
    private static int carXcord = 162;
    private static int carYcord = 400;

    private  static boolean gameover = false;
    private  static int car2Ycord = 0;
    private  static int car3Ycord = 200;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setPreferredSize(new Dimension(450,600));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        panel.setFocusable(true);
        panel.requestFocus();
        Car c = new Car();
        panel.addKeyListener(c);

        Graphics g = panel.getGraphics();

        //hello hoe
        BufferedImage carImage1;
        BufferedImage carImage2;
        BufferedImage carImage3;
        BufferedImage gameOver;

        AudioClip hit;

        int car2Xcord = 40;
        int car3Xcord = 315;


        try {
            carImage1 = ImageIO.read(Demo.class.getResource("../resources/car1.png"));
            carImage2 = ImageIO.read(Demo.class.getResource("../resources/car3.png"));
            carImage3 = ImageIO.read(Demo.class.getResource("../resources/Audi.png"));
            hit = Applet.newAudioClip(Demo.class.getResource("../resources/bomb.wav"));
            gameOver = ImageIO.read(Demo.class.getResource("../resources/Over.png"));

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Random rand = new Random();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x;
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
            if (Car.gameover){
//                g.clearRect(0,0,450,600);
//                g.setColor(Color.red);
//                g.fillRect(0,0,450,600);
//               g.drawImage(gameOver,0,250,null);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                g.setColor(Color.red);
                g.drawString("Game Over.", 100, 100);

                continue;

            }
            //For Checking if


            if (Car.b1>600){
                Car.b1 = -80;
            }
            if (Car.b2>600){
                Car.b2 = -80;
            }
            if (Car.b3>600){
                Car.b3 = -80;
            }
            if (Car.b4>600){
                Car.b4 = -80;
            }

            if (Car.car2Ycord>751){
                Car.car2Ycord = -80;
                x = rand.nextInt(3);
                if (x==0){
                    car2Xcord = 40;
                }
                if (x==1){
                    car2Xcord = 162;
                }
                if (x==2){
                    car2Xcord = 315;
                }
            }
            if (Car.car3Ycord>751){
                Car.car3Ycord = -80;
                x = rand.nextInt(3);
                if (x==0){
                    car3Xcord = 40;
                }
                if (x==1){
                    car3Xcord = 162;
                }
                if (x==2){
                    car3Xcord = 315;
                }
            }

            Rectangle  car1 = new Rectangle(Car.carXcord,Car.carYcord,75,148);
            Rectangle car2 = new Rectangle(car2Xcord, Car.car2Ycord, 75, 151);
            Rectangle car3 = new Rectangle(car3Xcord,Car.car3Ycord,85,150);

            if (car1.intersects(car2) || car1.intersects(car3)){
                hit.play();
                Car.gameover = true;
            }
            Car.b1 += 10;
            Car.b2 += 10;
            Car.b3 += 10;
            Car.b4 += 10;
            Car.car2Ycord += 10;
            Car.car3Ycord += 10;

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500, 600);
            g.setColor(Color.GREEN);
            g.fillRect(0,Car.b1,25,100);
            g.fillRect(0,Car.b2,25,100);
            g.fillRect(0,Car.b3,25,100);
            g.fillRect(0,Car.b4,25,100);



            g.fillRect(425,Car.b1,25,100);
            g.fillRect(425,Car.b2,25,100);
            g.fillRect(425,Car.b3,25,100);
            g.fillRect(425,Car.b4,25,100);
            g.setColor(Color.GRAY);
            g.fillRect(25,0,130,600);
            g.fillRect(159,0,130,600);
            g.fillRect(292,0,130,600);



            g.drawImage(carImage2,car2Xcord,Car.car2Ycord,null);
            g.drawImage(carImage3,car3Xcord,Car.car3Ycord,null);
            g.drawImage(carImage1,carXcord,carYcord,null);

            if (Car.carXcord<=25 || Car.carXcord+70>=425){
                hit.play();
                Car.gameover =true;
                continue;
            }



        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Car.carXcord -= 125;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Car.carXcord += 125;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
