import java.util.Scanner;

public class computerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        double taxesSum = 0;

        double total = sum + taxesSum;

        while (true){
            String command = scanner.nextLine();

            if (command.equals("special")){
                total = (sum+taxesSum) *0.90;
                if(total == 0){
                    System.out.println("Invalid order!");
                    break;
                }
                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$\n", sum);
                System.out.printf("Taxes: %.2f$\n",taxesSum);
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$", total);
                break;


            }

            if (command.equals("regular")){
                total = (sum+taxesSum);
                if(total == 0){
                    System.out.println("Invalid order!");
                    break;
                }
                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$\n", sum);
                System.out.printf("Taxes: %.2f$\n",taxesSum);
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$", total);
                break;

            }


            double currentNum = Double.parseDouble(command);

            if(currentNum > 0 ){
                double taxes = currentNum * 0.20;
                taxesSum += taxes;

                sum += currentNum;
            }

            if(currentNum < 0 ){
                System.out.println("Invalid price!");

            }

        }

    }
}
