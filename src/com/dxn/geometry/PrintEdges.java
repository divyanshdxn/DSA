package com.dxn.geometry;

import java.util.Arrays;

public class PrintEdges {

    static class Offset {
        float x;
        float y;

        public Offset(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public static void main(String[] args) {
        int n = 5, x = 4, y = 5, r = 5;
        Offset[] vt = getVertices(r, new Offset(x, y), n);
        System.out.println(Arrays.toString(vt));
    }

    public static Offset[] getVertices(float radius, Offset center, int sides) {
        Offset[] vertices = new Offset[sides];
        float x = center.x;
        float y = center.y;
        for (int i = 0; i < sides; i++) {
            float x1 = (float) (x + radius * Math.cos(2 * Math.PI * i / sides));
            float y1 = (float) (y + radius * Math.sin(2 * Math.PI * i / sides));
            vertices[i] = new Offset(x1, y1);
        }
        return vertices;
    }
}
