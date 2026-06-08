package com.softserve.academy;

public class Rectangle {
    private double width;
    private double height;
    private double angle;

    public Rectangle() {
        this.width = 0.0;
        this.height = 0.0;
        this.angle = 90.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.angle = 90.0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}
