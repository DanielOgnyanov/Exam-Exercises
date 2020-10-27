import java.util.Scanner;

public class EasterCozonacs__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flower = Double.parseDouble(scanner.nextLine());


        double priceEggs = flower * 0.75;
        double priceMilk = (flower * 1.25) / 4;

        double totalPrice = flower + priceEggs + priceMilk;

        int count = 0;
        int eggs = 0;


        while (true) {
            if (budget < totalPrice) {
                break;
            }
            budget = budget - totalPrice;
            count++;
            eggs += 3;


            if (count % 3 == 0) {
                int lostEggs = count - 2;
                eggs -= lostEggs;

            }
        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", count, eggs, budget);


    }
}
