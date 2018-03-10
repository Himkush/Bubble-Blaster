package game;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    private static int carXcord;


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


        BufferedImage carImage1;
        BufferedImage carImage2;
        BufferedImage carImage3;

        int car2Xcord = 40;
        int car3Xcord = 315;


        try {
            carImage1 = ImageIO.read(Demo.class.getResource("../resources/car1.png"));
            carImage2 = ImageIO.read(Demo.class.getResource("../resources/car3.png"));
            carImage3 = ImageIO.read(Demo.class.getResource("../resources/Audi.png"));

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
                Car.car2Ycord = 0;
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
                Car.car3Ycord = 0;
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
            Car.b1 += 5;
            Car.b2 += 5;
            Car.b3 += 5;
            Car.b4 += 5;
            Car.car2Ycord += 5;
            Car.car3Ycord += 5;

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

            g.drawImage(carImage1,200,400,null);
            g.drawImage(carImage2,car2Xcord,Car.car2Ycord,null);
            g.drawImage(carImage3,car3Xcord,Car.car3Ycord,null);



        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
