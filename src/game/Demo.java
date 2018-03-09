package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Demo implements KeyListener, MouseListener {

    private static int playerYCord = 315;
    private static int playerYVel = 0;
    private static int playerYAcc = 0;

    private static AudioClip jumpAudio;
    private static int score = 0;

    public static boolean paused = false;


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();

        frame.add(p);

        p.setPreferredSize(new Dimension(800, 450));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        p.setFocusable(true);
        Demo d = new Demo();
        p.addKeyListener(d);
        p.addMouseListener((d));


        // TODO: why this is happening. onAttach.
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        Graphics g = p.getGraphics();
        BufferedImage grassImage;
        BufferedImage[] playerImages = new BufferedImage[8];
        BufferedImage playerJumpImage;
        BufferedImage playerCurrentImage;
        BufferedImage blockImage;
        AudioClip hitAudio;
        try {
            URL u = Demo.class.getResource("../resources/grass.png");
            grassImage = ImageIO.read(u);

            playerImages[0] = ImageIO.read(Demo.class.getResource("../resources/run_anim1.png"));
            playerImages[1] = ImageIO.read(Demo.class.getResource("../resources/run_anim2.png"));
            playerImages[2] = ImageIO.read(Demo.class.getResource("../resources/run_anim3.png"));
            playerImages[3] = ImageIO.read(Demo.class.getResource("../resources/run_anim4.png"));
            playerImages[4] = ImageIO.read(Demo.class.getResource("../resources/run_anim5.png"));
            playerImages[5] = playerImages[3];
            playerImages[6] = playerImages[2];
            playerImages[7] = playerImages[1];
            playerJumpImage = ImageIO.read(Demo.class.getResource("../resources/jump.png"));
            blockImage = ImageIO.read(Demo.class.getResource("../resources/block.png"));
            hitAudio = Applet.newAudioClip(Demo.class.getResource("../resources/hit.wav"));
            Demo.jumpAudio = Applet.newAudioClip(Demo.class.getResource("../resources/onjump.wav"));
        }


        catch (IOException e) {
            System.out.println("Please reinstall game");
            return;
        }

        int imageIndex = 0;
        p.requestFocus();
        int block1XCord = 900;
        int block2XCord = 1100;
        int block3XCord = 1300;
        int block4XCord = 1500;
        int block5XCord = 1700;

        boolean block1Visible = true;
        boolean block2Visible = true;
        boolean block3Visible = true;
        boolean block4Visible = true;
        boolean block5Visible = true;
        int playerXCord = 364;
        while (true) {
            try {
                Thread.sleep(29);
            } catch (InterruptedException e) {
            }
            if (paused){
                continue;
            }

            if (playerXCord < 0) {
                g.setFont(new Font("Arial", Font.BOLD, 40));
                g.setColor(Color.red);
                g.drawString("Game Over. Press any key to continue", 100, 100);
                continue;
            }
            imageIndex++;
            imageIndex = imageIndex % 8;
            playerCurrentImage = playerImages[imageIndex];


            block1XCord -= 5;
            block2XCord -= 5;
            block3XCord -= 5;
            block4XCord -= 5;
            block5XCord -= 5;

            if (block1XCord <= -20) {
                block1XCord = 980;
                block1Visible = true;
            }
            if (block2XCord <= -20) {
                block2XCord = 980;
                block2Visible = true;
            }
            if (block3XCord <= -20) {
                block3XCord = 980;
                block3Visible = true;
            }
            if (block4XCord <= -20) {
                block4XCord = 980;
                block4Visible = true;
            }
            if (block5XCord <= -20) {
                block5XCord = 980;
                block5Visible = true;
            }

            Demo.playerYVel += Demo.playerYAcc;
            Demo.playerYCord += Demo.playerYVel;

            if (Demo.playerYCord >= 315) {
                Demo.playerYCord = 315;
                Demo.playerYAcc = 0;
                Demo.playerYVel = 0;
            }

            Rectangle playerRect = new Rectangle(playerXCord, Demo.playerYCord, 72, 90);
            Rectangle block1Rect = new Rectangle(block1XCord, 355, 20, 50);
            Rectangle block2Rect = new Rectangle(block2XCord, 355, 20, 50);
            Rectangle block3Rect = new Rectangle(block3XCord, 355, 20, 50);
            Rectangle block4Rect = new Rectangle(block4XCord, 355, 20, 50);
            Rectangle block5Rect = new Rectangle(block5XCord, 355, 20, 50);

            if (block1Visible && playerRect.intersects(block1Rect)) {
                playerXCord -= 50;
                hitAudio.play();
                block1Visible = false;
            }


            if (block2Visible && playerRect.intersects(block2Rect)) {
                playerXCord -= 50;
                hitAudio.play();
                block2Visible = false;
            }


            if (block3Visible && playerRect.intersects(block3Rect)) {
                playerXCord -= 50;
                hitAudio.play();
                block3Visible = false;
            }


            if (block4Visible && playerRect.intersects(block4Rect)) {
                playerXCord -= 50;
                hitAudio.play();
                block4Visible = false;
            }


            if (block5Visible && playerRect.intersects(block5Rect)) {
                playerXCord -= 50;
                hitAudio.play();
                block5Visible = false;
            }

            if(Demo.playerYCord < 315) {
                playerCurrentImage = playerJumpImage;
            }

            g.clearRect(0, 0, 800, 450);
            g.setColor(new Color(146, 212, 255));
            g.fillRect(0, 0, 800, 450);
            g.drawImage(grassImage, 0, 405, null);
            //Demo.score++;
            g.drawString("Score"+Integer.toString(Demo.score),100,100);


            if (block1Visible) {
                g.drawImage(blockImage, block1XCord, 355, null);
            }

            if (block2Visible) {
                g.drawImage(blockImage, block2XCord, 355, null);
            }

            if (block3Visible) {
                g.drawImage(blockImage, block3XCord, 355, null);
            }

            if (block4Visible) {
                g.drawImage(blockImage, block4XCord, 355, null);
            }

            if (block5Visible) {
                g.drawImage(blockImage, block5XCord, 355, null);
            }
            g.setColor(Color.GREEN);
            g.drawImage(playerCurrentImage, playerXCord, Demo.playerYCord, null);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.setColor(Color.BLACK);
            g.drawString("Score: "+Integer.toString(Demo.score),720,20);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && Demo.playerYCord == 315) {
            Demo.playerYVel = -20;
            Demo.playerYAcc = 1;
            Demo.score+=10;
            Demo.jumpAudio.play();
        }
        //nohello
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Demo.paused = !Demo.paused;

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