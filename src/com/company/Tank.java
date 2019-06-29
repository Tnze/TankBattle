package com.company;

import javax.swing.*;
import java.awt.*;

//坦克
public class Tank {
    Image tank = new ImageIcon("src/Tank.png").getImage();
    Vec2 pos;
    double dir;
    TankFireListener fireListener;

    public Tank() {
        this.pos = new Vec2(100, 100);
        dir = 0;
    }

    public Tank(Vec2 pos, double dir) {
        this.pos = pos;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.rotate(dir, pos.x, pos.y);
        g.drawImage(tank, pos.x - tank.getWidth(null) / 2, pos.y - tank.getHeight(null) / 2, null);
        g2.rotate(-dir, pos.x, pos.y);

        //Debug: 绘制坦克碰撞箱
//        int size = 55;
//        g2.drawOval(pos.x - size, pos.y - size, size * 2, size * 2);

    }

    public void addFireListener(TankFireListener fl) {
        fireListener = fl;
    }

    void fire() {
        Bullet b = new Bullet();
        b.pos = new Vec2(pos.x, pos.y);
        b.pos.add(dirVec(dir, 60));
        b.dir = dir;

        if (fireListener != null)
            fireListener.onTankFire(b);
    }

    public void distroy(){

    }

    Vec2 dirVec(double dir, int speed) {
        return new Vec2(
                (int) (speed * Math.sin(dir)),
                (int) (-speed * Math.cos(dir))
        );
    }
}
