package lesson22.serializing;

import java.io.Serializable;

public class Point implements Serializable {
    private int x = 0;
    private int y = 0;

    public Point() {

    }
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

