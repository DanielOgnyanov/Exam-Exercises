import java.util.Scanner;

public class SpringVacationTrip__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        int people = Integer.parseInt(scanner.nextLine());

        double fuelPerKm = Double.parseDouble(scanner.nextLine());

        double foodPerPersonPrice = Double.parseDouble(scanner.nextLine());
        double priceRoomPerPerson = Double.parseDouble(scanner.nextLine());

        int countThree = 0;
        int countFive = 0;
        int countSeven = 0;

        // 7
        // 12000
        // 5
        // 1.5
        // 10
        // 20

        double foodExpenses = days * foodPerPersonPrice * people;
        double priceHotelAll = 0;

        if (people > 10) {
            priceHotelAll = (days * people * priceRoomPerPerson) * 0.75;
        } else {
            priceHotelAll = days * people * priceRoomPerPerson;
        }


        double sum = foodExpenses + priceHotelAll;

        for (int i = 1; i <= days; i++) {

            double distance = Double.parseDouble(scanner.nextLine());
            countThree++;
            countFive++;
            countSeven++;

            double travelingDistance = fuelPerKm * distance;


            sum += travelingDistance;


            if (countThree == 3) {
                sum = sum + (sum * 0.4);
                if (sum > budget) {
                    System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", sum - budget);
                    return;
                }
                countThree = 0;
            }

            if (countFive == 5) {
                sum = sum + (sum * 0.4);
                if (sum > budget) {
                    System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", sum - budget);
                    return;
                }
                countFive = 0;
            }

            if (countSeven == 7) {
                sum = sum - (sum / people);

                countSeven = 0;
            }

            if (sum > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", sum - budget);
                return;
            }
        }


        System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - sum);

    }
}
