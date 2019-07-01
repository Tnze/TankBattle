package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerTank extends Tank implements KeyListener {
    boolean W, S, A, D;

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                A = false;
                break;

            case KeyEvent.VK_D:
                D = false;
                break;

            case KeyEvent.VK_W:
                W = false;
                break;

            case KeyEvent.VK_S:
                S = false;
                break;
        }
    }

    //当键盘被按下时执行
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                A = true;
                break;

            case KeyEvent.VK_D:
                D = true;
                break;

            case KeyEvent.VK_W:
                W = true;
                break;

            case KeyEvent.VK_S:
                S = true;
                break;

            case KeyEvent.VK_M:
                fire();
        }
    }

    public void update() {
        if (W) pos.add(dirVec(dir, 6));
        if (S) pos.add(dirVec(dir, -3));
        if (A) dir -= 0.05;
        if (D) dir += 0.05;
    }
}
