package com.kurs.coding_one.choinka;

public class ChristmassTree {

    public static void main(String... args) {
        drawTree(32);
    }

    static void drawTree(int width) {
        if (width % 2 == 0) {
            width += 1;
        }
        drawTriangle(width);
        drawRectangle(width);
    }

    static void drawTriangle(int width) {
        for (int i = 1; i < width; i += 2) {
            drawLine(width / 2, i);
        }
    }

    static void drawRectangle(int width) {
        for (int k = 0; k < width / 6; k++) {
            drawLine(width / 2, width / 3);
        }
    }

    static void drawLine(int centerPoint, int length) {
        int startPoint = centerPoint - length / 2 - 1;
        for (int i = 0; i < startPoint; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }
}
