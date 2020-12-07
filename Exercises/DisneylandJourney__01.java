import java.util.Scanner;

public class DisneylandJourney__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double costJourney = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        if(months > 12){
            return;
        }

        double sum = 0;

        for (int i = 1 ; i <= months ; i++) {
            double moneySave = costJourney * 0.25;

            if(i == 4 || i == 8 || i == 12){
                sum = sum * 1.25;
                sum += moneySave;
            }


            if(i != 1 && i % 2 == 1){
                 sum = sum * 0.84;
                 sum+=moneySave;
            }
            else  if(i != 4 && i != 8 && i != 12) {
                sum+=moneySave;
            }


        }
        if(sum >= costJourney){
            double souvenir = sum - costJourney;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",souvenir);
        }else {
            double difference = costJourney - sum;
            System.out.printf("Sorry. You need %.2flv. more.",difference);
        }
    }
}
