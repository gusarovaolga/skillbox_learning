public class Main {
    public static void main(String[] args) {

        int volume = 1200;

        int fillingSpeed = 30; //30 litres per minute
        int devastationSpeed = 10; //10 litres per minute

        int nowVolume = 0;
        int time = 0;

        while (nowVolume != volume){
            nowVolume = nowVolume + fillingSpeed - devastationSpeed;
            time ++;
        }
        System.out.println("Время заполнения бассейна: " + time + " минут");
    }
}
