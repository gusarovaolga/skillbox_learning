
public class Main {
    public static void main(String[] args) {
        int milkAmount = 2000; // ml
        int powderAmount = 1000; // g
        int eggsCount = 30; // items
        int sugarAmount = 50; // g
        int oilAmount = 30; // ml
        int appleCount = 8;

        int pancakesPowderRequired = 400, pancakesSugarRequired = 10, pancakesMilkRequired = 1000, pancakesOilRequired = 30;
        int omeletteMilkRequired = 300, omelettePowderRequired = 5, omeletteEggsRequired = 5;
        int applePieApplesRequired = 3, applePieMilkRequired = 100, applePiePowderRequired = 300, applePieEggsRequired = 4;

        boolean pancakesIngredientsEnough = powderAmount >= pancakesPowderRequired &&
                                            sugarAmount >= pancakesSugarRequired &&
                                            milkAmount >= pancakesMilkRequired &&
                                            oilAmount >= pancakesOilRequired;

        boolean omeletteIngredientsEnough = milkAmount >= omeletteMilkRequired &&
                                            powderAmount >= omelettePowderRequired &&
                                            eggsCount >= omeletteEggsRequired;

        boolean applePieIngredientsEnough = appleCount >= applePieApplesRequired &&
                                            milkAmount >= applePieMilkRequired &&
                                            powderAmount >= applePiePowderRequired &&
                                            eggsCount >= applePieEggsRequired;

        //Pancakes
        if (pancakesIngredientsEnough){
            System.out.println("Pancakes");
        }else{
            if (powderAmount < pancakesPowderRequired){
                System.out.println("powered for pancakes not enough");
            }
            if (sugarAmount < pancakesSugarRequired){
                System.out.println("sugar for pancakes not enough");
            }
            if (milkAmount < pancakesMilkRequired){
                System.out.println("milk for pancakes not enough");
            }
            if (oilAmount < pancakesOilRequired){
                System.out.println("oil for pancakes not enough");
            }
        }System.out.println(" ");

        //Omelette
        if (omeletteIngredientsEnough){
            System.out.println("Omelette");
        }else {
            if (milkAmount < omeletteMilkRequired){
                System.out.println("milk for omelette not enough");
            }
            if (powderAmount < omelettePowderRequired){
                System.out.println("powder for omelette not enough");
            }
            if (eggsCount < omeletteEggsRequired){
                System.out.println("eggs for omelette not enough");
            }
        }System.out.println(" ");

        //Apple pie
        if (applePieIngredientsEnough) {
            System.out.println("Apple pie");
        }else{
            if (appleCount < applePieApplesRequired){
                System.out.println("apples for Apple Pie not enough");
            }
            if (milkAmount < applePieMilkRequired){
                System.out.println("milk for Apple Pie not enough");
            }
            if (powderAmount < applePiePowderRequired){
                System.out.println("powder for Apple Pie not enough");
            }
            if (eggsCount < applePieEggsRequired){
                System.out.println("eggs for Apple Pie not enough");
            }
        }

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml "Pancakes"
        //milk - 300 ml, powder - 5 g, eggs - 5 "Omelette"
        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4 "Apple pie"

    }
}