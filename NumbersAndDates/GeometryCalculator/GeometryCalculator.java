public class GeometryCalculator {

    private double radius;

    private double a;
    private double b;
    private double c;

    public GeometryCalculator(double radius) {
        this.radius = radius;
    }

    public GeometryCalculator(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getCircleSquare() {
        if (radius > 0) {
            return Math.PI * (radius * radius);
        } else {
            System.out.println("Задан отрицательный радиус. Площадь круга найти невозможно");
            return 0;
        }
    }

    public double getAreaOfTriangle() {
        boolean condition = ((a + b) < c) || ((a + c) < b) || ((b + c) < a);
        double p = (a + b + c) / 2.0;
        if (condition) {
            System.out.println("невозможно построить треугольник по данным параметрам");
            return 0;
        } else {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }

    public double getSphereVolume() {
        if (radius > 0) {
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        } else {
            System.out.println("Задан отрицательный радиус. Обьем шара найти невозможно");
            return 0;
        }
    }
}
