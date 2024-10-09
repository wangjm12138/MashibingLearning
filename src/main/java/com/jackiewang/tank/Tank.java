package com.jackiewang.tank;

import com.jackiewang.algorithm.graph.Graph;

import java.awt.*;

public class Tank {
    private int x = 200;
    private int y = 200;

    private Direction direction = Direction.DOWN;
    private static final int SPEED = 5; 
    private boolean moving = false;

    private TankFrame tf = null;

    public Tank(int x, int y, Direction direction, TankFrame tf){
        super();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y,50,50);
        g.setColor(c);
        move();
    }

    private void move() {
        if(!moving) return;
        switch (direction){
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        tf.bulletList.add(new Bullet(this.x, this.y, this.direction));
    }
}
