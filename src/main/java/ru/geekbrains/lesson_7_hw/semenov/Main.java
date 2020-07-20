package ru.geekbrains.lesson_7_hw.semenov;


import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        CatEating();
        CatsArray();
    }

    public static void CatEating() {
        int foodCount = 30;
        Cat cat = new Cat("Barsik", 25);
        Plate plate = new Plate(foodCount);
        plate.info();
        System.out.println("Barsik has an appetite " + cat.getAppetite() + ", and he went to eat");
        cat.eat(plate);
        plate.info();
        if (foodCount >= cat.getAppetite()) {
            System.out.println("Barsik is full and very happy");
        }
        cat.setAppetite(cat.getAppetite() - foodCount <= 0 ? 0 : cat.getAppetite() - foodCount);
        if (cat.getAppetite() == 0) {
            plate.info();
        } else
            System.out.println("Barsik ate everything, but the appetite remained " + cat.getAppetite());
        System.out.println("");
    }

    public static void CatsArray() {
        int foodCount = 200;
        Plate plate = new Plate(foodCount);
        Cat[] CatsArray = new Cat[4];
        CatsArray[0] = new Cat("Vladimir", 100);
        CatsArray[1] = new Cat("Donald", 90);
        CatsArray[2] = new Cat("Si", 80);
        CatsArray[3] = new Cat("Naruhito", 70);
        for (int i = 0; i < CatsArray.length; i++) {
            plate.info();
            System.out.println(CatsArray[i].getName() + " has an appetite " + CatsArray[i].getAppetite() + ", and he went to eat");
            if (CatsArray[i].getAppetite() <= foodCount) {
                System.out.println(CatsArray[i].getName() + " is full and very happy");
                CatsArray[i].eat(plate);
                plate.info();
                foodCount = foodCount - CatsArray[i].getAppetite();
            } else if (CatsArray[i].getAppetite() > foodCount) {
                System.out.println(("Amount of food " + foodCount + " not enough to satisfy " + CatsArray[i].getName() + "'s appetite " + CatsArray[i].getAppetite() + ", he is sad"));
                System.out.println("The food is over, the other cats are hungry");

                System.out.println("");
                System.out.println("Would you like to add food to the plate? 1 – yes / 0 – no");
                int Number = sc.nextInt();
                if (Number == 0) {
                    break;
                }
                System.out.println("How much food to add to the plate?");
                int foodNumber = sc.nextInt();
                int f = foodNumber;
                plate.addFood(f);
                foodCount = foodCount + f;
                System.out.println("");
                System.out.println("Added " + f + " food");
            }
            System.out.println("");
        }
        sc.close();
    }
}
