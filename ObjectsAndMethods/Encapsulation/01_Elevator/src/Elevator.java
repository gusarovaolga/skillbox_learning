public class Elevator {

    private final int minFloor;
    private final int maxFloor;
    private int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {

        if (floor >= minFloor && floor <= maxFloor) {
            if (floor > currentFloor) {
                System.out.println("Лифт поднимается");
                for (int i = currentFloor; i < floor; i++) {
                    moveUp();
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            } else if (floor < currentFloor) {
                System.out.println("Лифт спускается");
                for (int i = currentFloor; i > floor; i--) {
                    moveDown();
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                }
            } else {
                System.out.println("Лифт на вашем этаже");
            }
        } else {
            System.out.println("Ошибка: этаж указан неверно");
        }
    }
}
