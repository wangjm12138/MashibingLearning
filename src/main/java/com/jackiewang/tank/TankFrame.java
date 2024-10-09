package com.jackiewang.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.UnresolvedPermission;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200,200,Direction.DOWN, this);
    List<Bullet> bulletList = new ArrayList<>();
//    Bullet bullet = new Bullet(300,300,Direction.DOWN);

    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    public TankFrame() {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeylistener());
    }

    Image offscreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offscreenImage == null) {
            offscreenImage =  this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen =  offscreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offscreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        for (Bullet b: bulletList){
            b.paint(g);
        }
//        bullet.paint(g);
    }


    public class MyKeylistener extends KeyAdapter {

        boolean bl = false;
        boolean br = false;

        boolean bu = false;

        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = true;
//                    System.out.println("left press");
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    System.out.println("up press");
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl = false;
//                    System.out.println("left release");
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bl && !bd && !br && !bu) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if(bl) myTank.setDirection(Direction.LEFT);
                if(bu) myTank.setDirection(Direction.UP);
                if(br) myTank.setDirection(Direction.RIGHT);
                if(bd) myTank.setDirection(Direction.DOWN);
            }
        }
    }
    

}
