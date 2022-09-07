

import enums.TypeScreen;

public class Screen {

    private final double diagonal;
    private final TypeScreen type;
    private final double weight;

    public Screen(double diagonal, TypeScreen type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public Screen setDiagonal(double diagonal) {
        return new Screen(diagonal, type, weight);
    }

    public TypeScreen getType() {
        return type;
    }

    public Screen setType(TypeScreen type) {
        return new Screen(diagonal, type, weight);
    }

    public double getWeight() {
        return weight;
    }

    public Screen setWeight(double weight) {
        return new Screen(diagonal, type, weight);
    }

    @Override
    public String toString() {
        return "Экран: " +
                "\n * диагональ: " + diagonal + " дюйма" +
                "\n * тип: " + type +
                "\n * вес: " + weight + " грамм" +
                '\n';
    }
}
