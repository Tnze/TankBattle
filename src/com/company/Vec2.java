package com.company;

public class Vec2 {
    int x, y;

    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public double distance(Vec2 v) {
        int dx = v.x - x;
        int dy = v.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
