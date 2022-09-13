public class GeometryCalculator {
    private static double radius;

    private double a;
    private double b;
    private double c;

    public GeometryCalculator(double radius) {
        GeometryCalculator.radius = radius;
    }

    public GeometryCalculator(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getCircleSquare(double radius) {
        if (radius > 0) {
            return Math.PI * (radius * radius);
        } else if (radius == 0) {
            return 0.0;
        } else {
            System.out.println("Задан отрицательный радиус. Площадь круга найти невозможно");
            return -1.0;
        }
    }

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getSphereVolume(double radius) {
        if (radius > 0) {
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        } else if (radius == 0) {
            return 0.0;
        } else {
            System.out.println("Задан отрицательный радиус. Объем шара найти невозможно");
            return -1;
        }
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        boolean condition1 = ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
        boolean condition2 = (a > 0 && b > 0 && c > 0);
        if (condition1 && condition2) {
            return true;
        } else {
            System.out.println("невозможно построить треугольник по данным параметрам");
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2.0;
        if (GeometryCalculator.isTrianglePossible(a, b, c)) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            return -1.0;
        }
    }
}
