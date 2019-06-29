package com.company;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class Bullet {
    public Vec2 pos;
    public double dir;

    public void paint(Graphics g) {
        g.setColor(Color.black);
//        g.drawOval(pos.x, pos.y, 15, 15);
        g.fillOval(pos.x, pos.y, 15, 15);
    }

    public void update() {
        pos.add(dirVec(10));
    }

    Vec2 dirVec(int speed) {
        return new Vec2(
                (int) (speed * Math.sin(dir)),
                (int) (-speed * Math.cos(dir))
        );
    }
}
