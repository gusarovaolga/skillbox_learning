import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст Васи: ");
        int vasyaAge = scanner.nextInt();
        System.out.println("Введите возраст Кати: ");
        int katyaAge = scanner.nextInt();
        System.out.println("Введите возраст Миши: ");
        int mishaAge = scanner.nextInt();

        int min = -1;
        int middle = -1;
        int max = -1;

        if(vasyaAge < 0 || vasyaAge > 120 ||
           katyaAge < 0 || katyaAge > 120 ||
           mishaAge < 0 || mishaAge > 120) {

            System.out.println("Возраст превышает указанный диапазон от 0 до 120 лет");

        } else {

            if (katyaAge <= vasyaAge && katyaAge <= mishaAge){
                min = katyaAge;
            } else if (vasyaAge <= katyaAge && vasyaAge <= mishaAge){
                min = vasyaAge;
            } else {
                min = mishaAge;
            } System.out.println( "Minimal age: " + min);

            if (katyaAge >= vasyaAge && katyaAge <= mishaAge){
                middle = katyaAge;
            } else if (vasyaAge >= katyaAge && vasyaAge <= mishaAge){
                middle = vasyaAge;
            } else {
                middle = mishaAge;
            } System.out.println( "Middle age: " + middle);

            if (katyaAge >= vasyaAge && katyaAge >= mishaAge){
                max = katyaAge;
            } else if (vasyaAge >= katyaAge && vasyaAge >= mishaAge){
                max = vasyaAge;
            } else {
                max = mishaAge;
            } System.out.println( "Maximum age: " + max);
        }
    }
}
