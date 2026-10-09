package main.java.Abstraction.class_problems;
import java.util.Scanner;

abstract class Shape {
    public abstract double area();
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class ShapeArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shapeType = sc.next();
            Shape shape = null;

            switch (shapeType) {
                case "RECTANGLE":
                    double w = sc.nextDouble();
                    double h = sc.nextDouble();
                    shape = new Rectangle(w, h);
                    break;
                case "TRIANGLE":
                    double b = sc.nextDouble();
                    double th = sc.nextDouble();
                    shape = new Triangle(b, th);
                    break;
                case "CIRCLE":
                    double r = sc.nextDouble();
                    shape = new Circle(r);
                    break;
            }

            if (shape != null) {
                double calculatedArea = shape.area();
                System.out.printf("%s: %.2f\n", shapeType, calculatedArea);
                totalArea += calculatedArea;
            }
        }

        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}