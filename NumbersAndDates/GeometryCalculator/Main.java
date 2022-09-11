public class Main {

    public static void main(String[] args) {

        GeometryCalculator circle = new GeometryCalculator(20.2);
        System.out.println("площадь круга равна: " + circle.getCircleSquare());

        GeometryCalculator triangle = new GeometryCalculator(250, 350, 280);
        System.out.println("площадь треугольника равна: " + triangle.getAreaOfTriangle());

        GeometryCalculator ball = new GeometryCalculator(15);
        System.out.println("объем шара равен: " + ball.getSphereVolume());
    }
}
