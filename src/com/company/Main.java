package com.company;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        JFrame w = new JFrame();
        w.setSize(800, 600);

        Canvas c = new Canvas();
        PlayerTank pt = new PlayerTank();

        c.setSize(800, 600);
        c.addTank(pt);
        c.addTank(new Tank(new Vec2(300, 300), Math.toRadians(90)));

        w.setTitle("坦克大战");
        w.add(c);
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        w.addKeyListener(pt);
        w.setVisible(true);

//        new Thread(()->{
            try {
                while (true) {
                    w.repaint();
                    c.updateBullet();
                    pt.update();
                    Thread.sleep(40);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }).start();

    }
}
