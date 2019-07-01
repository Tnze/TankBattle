package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

//游戏区域
public class Canvas extends JPanel implements TankFireListener {
    //坦克集合
    Set<Tank> tanks = new HashSet<Tank>();
    Set<Bullet> bullets = new HashSet<Bullet>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Tank tank : tanks)
            tank.paint(g);
        for (Bullet b : bullets)
            b.paint(g);
    }

    @Override
    public void update(final Graphics g) {
        Dimension size = this.getSize();
        Image screenBuff = createImage(size.width, size.height);
        Graphics gBuff = screenBuff.getGraphics();
        paint(gBuff);
        gBuff.dispose();
        g.drawImage(screenBuff, 0, 0, this);
    }

    public void updateItems() {
        Dimension size = this.getSize();

        for (Tank t : tanks) {
            if (t.pos.x-t.size/2 < 0) t.pos.x = t.size/2;
            if (t.pos.y-t.size/2 < 0) t.pos.y = t.size/2;
            if (t.pos.x+t.size/2 > size.width) t.pos.x = size.width-t.size/2;
            if (t.pos.y+t.size/2 > size.height) t.pos.y = size.height-t.size/2;
        }

        for (Object bobj : bullets.toArray()) {
            Bullet b = (Bullet) bobj;
            b.update();

            if (b.pos.x + b.size < 0 ||
                    b.pos.y + b.size < 0 ||
                    b.pos.x > size.width ||
                    b.pos.y > size.width) {
                bullets.remove(b);
                continue;
            }

            for (Tank t : tanks)
                if (b.pos.distance(t.pos) < t.size/2) {
                    tanks.remove(t);
                    t.distroy();
                    bullets.remove(b);
                    break;
                }
        }

    }

    public void addTank(Tank tank) {
        tanks.add(tank);
        tank.addFireListener(this);
    }

    @Override
    public void onTankFire(Bullet b) {
        bullets.add(b);
    }
}
