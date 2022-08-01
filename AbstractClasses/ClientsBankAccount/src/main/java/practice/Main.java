package practice;

public class Main {
    public static void main(String[] args) {
        Client physical = new PhysicalPerson();
        physical.put(1000);
        physical.take(100);
        physical.clientReport();

        Client legal = new LegalPerson();
        legal.put(1000);
        legal.take(100);
        legal.clientReport();

        Client businessman = new IndividualBusinessman();
        businessman.put(1000);
        businessman.take(100);
        businessman.clientReport();



    }
}
