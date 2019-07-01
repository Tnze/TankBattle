package com.company;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.KeyEvent;
import java.util.List;


class Bullet {
    final int size = 15;//直径

    Vec2 pos;
    double dir;

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(pos.x, pos.y, size, size);
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
