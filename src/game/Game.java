package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Game implements MouseListener {

    private static int ballon1Ycord = 400;
    private static int ballon2Ycord = 530;
    private static int ballon3Ycord = 660;
    private static int ballon4Ycord = 790;
    private static int ballon5Ycord = 920;
    private static int ballon6Ycord = 530;
    private static int ballon7Ycord = 920;

    private static AudioClip burstBalloon;
    private static AudioClip bombBurst;
    private static AudioClip music;



    private static int bomb1Ycord = 1020;
    private static int bomb2Ycord = 790;
    private static boolean balloon1Visible = true;
    private static boolean balloon2Visible = true;
    private static boolean balloon3Visible = true;
    private static boolean balloon4Visible = true;
    private static boolean balloon5Visible = true;
    private static boolean balloon6Visible = true;
    private static boolean balloon7Visible = true;

    private static boolean gameover = false;

    private static int b1 = 0;
    private static int b2 = 120;
    private static int b3 = 240;
    private static int b4 = 360;
    private static int b5 = 480;
    private static int b6 = 480;
    private static int b7 = 200;

    private static int bo1 = 380;
    private static int bo2 = 100;



    private static int ballooncount =0;

    private static int score = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setResizable(true);
        frame.setVisible(true);
        panel.setFocusable(true);

        panel.requestFocus();

        Random rand = new Random();
        Game d = new Game();
        panel.addMouseListener(d);



        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Graphics g = panel.getGraphics();
        BufferedImage[] balloonImage = new BufferedImage[7];
        BufferedImage[] bombImage = new BufferedImage[2];
        BufferedImage boomImage;
        AudioClip fail;
        BufferedImage lose;


        try {

            balloonImage[0] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            balloonImage[1] = ImageIO.read(Demo.class.getResource("../resources/balloon2.png"));
            balloonImage[2] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            balloonImage[3] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            balloonImage[4] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            balloonImage[5] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            balloonImage[6] = ImageIO.read(Demo.class.getResource("../resources/balloon1.png"));
            boomImage  = ImageIO.read(Demo.class.getResource("../resources/boom.png"));
            Game.burstBalloon = Applet.newAudioClip(Demo.class.getResource("../resources/hit.wav"));
            Game.bombBurst =Applet.newAudioClip(Demo.class.getResource("../resources/bomb.wav"));
            Game.music =Applet.newAudioClip(Demo.class.getResource("../resources/music.wav"));
            lose = ImageIO.read(Demo.class.getResource("../resources/lose.png"));
            bombImage[0] = ImageIO.read(Demo.class.getResource("../resources/bomb.png"));
            bombImage[1] = ImageIO.read(Demo.class.getResource("../resources/bomb.png"));

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Game.music.loop();

        while (true) {
            try {
                Thread.sleep(29);
            } catch (InterruptedException e) {
            }

            if(Game.gameover){
                music.stop();
                g.clearRect(0, 0, 600, 600);
                g.setColor(Color.red);
                g.fillRect(0,0,600,600);
                g.drawImage(boomImage,8,5,null);
                continue;
            }

            if (Game.ballon1Ycord <= -120) {
                if (Game.balloon1Visible){
                    Game.ballooncount++;
                }
                Game.ballon1Ycord = 600;
                Game.balloon1Visible = true;
                Game.b1 = rand.nextInt(480);
            }
            if (Game.ballon2Ycord <= -120) {
                if (Game.balloon2Visible){
                    Game.ballooncount++;
                }

                Game.ballon2Ycord = 600;
                Game.balloon2Visible = true;
                Game.b2 = rand.nextInt(180);
            }
            if (Game.ballon3Ycord <= -120) {
                if (Game.balloon3Visible){
                    Game.ballooncount++;
                }

                Game.ballon3Ycord = 600;
                Game.balloon3Visible = true;
                Game.b3 = rand.nextInt(480);
            }
            if (Game.ballon4Ycord <= -120) {
                if (Game.balloon4Visible){
                    Game.ballooncount++;
                }

                Game.ballon4Ycord = 600;
                Game.balloon4Visible = true;
                Game.b4 = 180 + rand.nextInt(200);
            }
            if (Game.ballon5Ycord <= -120) {
                if (Game.balloon5Visible){
                    Game.ballooncount++;
                }

                Game.ballon5Ycord = 600;
                Game.balloon5Visible = true;
                Game.b5 = 300 + rand.nextInt(180);
            }
            if (Game.ballon6Ycord <= -120) {
                if (Game.balloon6Visible){
                    Game.ballooncount++;
                }

                Game.ballon6Ycord = 600;
                Game.balloon6Visible = true;
                Game.b6 = 280 + rand.nextInt(180);
            }

            if (Game.ballon7Ycord <= -120) {
                if (Game.balloon7Visible){
                    Game.ballooncount++;
                }

                Game.ballon7Ycord = 600;
                Game.balloon7Visible = true;
                Game.b7 = rand.nextInt(180);
            }


            if (Game.bomb1Ycord <= -120) {
                Game.bomb1Ycord = 600;
                Game.bo1 = rand.nextInt(480);
            }

            if (Game.bomb2Ycord <= -120) {
                Game.bomb2Ycord = 600;
                Game.bo2 = rand.nextInt(85);
            }
            if (Game.ballooncount > 10) {
                music.stop();
                g.drawImage(lose,0,15,null);
                continue;
            }


            g.clearRect(0, 0, 600, 600);
            g.setColor(new Color(146, 212, 255));
            g.fillRect(0, 0, 600, 600);

            Game.ballon1Ycord -= 4;
            Game.ballon2Ycord -= 4;
            Game.ballon3Ycord -= 4;
            Game.ballon4Ycord -= 4;
            Game.ballon5Ycord -= 4;
            Game.ballon6Ycord -= 4;
            Game.ballon7Ycord -= 4;


            Game.bomb1Ycord -= 4;
            Game.bomb2Ycord -= 4;

            if (Game.balloon1Visible) {
                g.drawImage(balloonImage[0], Game.b1, Game.ballon1Ycord, null);
            }
            if (Game.balloon2Visible) {
                g.drawImage(balloonImage[1], Game.b2, Game.ballon2Ycord, null);
            }
            if (Game.balloon3Visible) {
                g.drawImage(balloonImage[2], Game.b3, Game.ballon3Ycord, null);
            }
            if (Game.balloon4Visible) {
                g.drawImage(balloonImage[3], Game.b4, Game.ballon4Ycord, null);
            }
            if (Game.balloon5Visible) {
                g.drawImage(balloonImage[4], Game.b5, Game.ballon5Ycord, null);
            }
            if (Game.balloon6Visible){
                g.drawImage(balloonImage[5], Game.b6, Game.ballon6Ycord, null);
             }
             if (Game.balloon7Visible) {
                 g.drawImage(balloonImage[6], Game.b7, Game.ballon7Ycord, null);
             }

            g.drawImage(bombImage[0],bo1,Game.bomb1Ycord,null);
            g.drawImage(bombImage[1],bo2,Game.bomb2Ycord,null);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.setColor(Color.black);
            g.drawString("Miss: "+Game.ballooncount,525,20);
            g.drawString("Score: "+Game.score, 505, 35);





        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (balloon1Visible&&((Game.b1<e.getX()&&e.getX()<(Game.b1+119))&&(Game.ballon1Ycord<e.getY()&&e.getY()<Game.ballon1Ycord+119))) {
            Game.balloon1Visible = false;
            Game.burstBalloon.play();
            Game.score += 20;

        }
        if (balloon2Visible&&((Game.b2<e.getX()&&e.getX()<(Game.b2+119))&&(Game.ballon2Ycord<e.getY()&&e.getY()<Game.ballon2Ycord+119))) {
            Game.balloon2Visible = false;
            Game.burstBalloon.play();
            Game.score += 20;
        }
        if (balloon3Visible&&((Game.b3<e.getX()&&e.getX()<(Game.b3+119))&&(Game.ballon3Ycord<e.getY()&&e.getY()<Game.ballon3Ycord+119))) {
            Game.balloon3Visible = false;
            Game.score += 20;
            Game.burstBalloon.play();
        }
        if (balloon4Visible&&((Game.b4<e.getX()&&e.getX()<(Game.b4+119))&&(Game.ballon4Ycord<e.getY()&&e.getY()<Game.ballon4Ycord+119))) {
            Game.balloon4Visible = false;
            Game.score += 20;
            Game.burstBalloon.play();
        }
        if (balloon5Visible&&((Game.b5<e.getX()&&e.getX()<(Game.b5+119))&&(Game.ballon5Ycord<e.getY()&&e.getY()<Game.ballon5Ycord+119))) {
            Game.balloon5Visible = false;
            Game.score += 20;
            Game.burstBalloon.play();
        }
        if (balloon6Visible&&((Game.b6<e.getX()&&e.getX()<(Game.b6+119))&&(Game.ballon6Ycord<e.getY()&&e.getY()<Game.ballon6Ycord+119))) {
            Game.balloon6Visible = false;
            Game.burstBalloon.play();
            Game.score += 20;

        }
        if (balloon7Visible&&((Game.b7<e.getX()&&e.getX()<(Game.b7+119))&&(Game.ballon7Ycord<e.getY()&&e.getY()<Game.ballon7Ycord+119))) {
            Game.balloon7Visible = false;
            Game.burstBalloon.play();
            Game.score += 20;
        }
        if (((Game.bo1<e.getX()&&e.getX()<(Game.bo1+95))&&(Game.bomb1Ycord<e.getY()&&e.getY()<Game.bomb1Ycord+97))) {
            Game.bombBurst.play();

            Game.gameover = true;
        }
        if (((Game.bo2<e.getX()&&e.getX()<(Game.bo2+95))&&(Game.bomb2Ycord<e.getY()&&e.getY()<Game.bomb2Ycord+97))) {
            Game.bombBurst.play();
            Game.gameover = true;

        }



    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
