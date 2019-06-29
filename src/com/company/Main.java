package com.company;


import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        Windows w = new Windows();
        PlayerTank pt = new PlayerTank();

        w.setSize(800, 600);
        w.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        w.addKeyListener(pt);
        w.setVisible(true);

        w.addTank(pt);
        w.addTank(new Tank(new Vec2(300, 300), Math.toRadians(90)));


        try {
            while (true) {
                w.repaint();
                w.updateBullet();
                pt.update();
                Thread.sleep(40);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
