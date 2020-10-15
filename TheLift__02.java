import java.util.Arrays;
import java.util.Scanner;

public class TheLift__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int [] wagon = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e-> Integer.parseInt(e)).toArray();
        int[] curr = new int[wagon.length];



        for (int i = 0; i < wagon.length ; i++) {
            curr[i] = wagon[i];
        }

        for (int i = 0; i < curr.length ; i++) {

            if(curr[i] == 0){
                curr[i] = 4;
                if(people < 4){
                    curr[i] = people;
                    people -= curr[i];
                } else if (people >= 4){
                    people -= 4;
                }

            }
            else if(curr[i] == 1){
                curr[i] += 3;
                people -= 3;
            }
            else if(curr[i] == 2){
                curr[i] += 2;
                people -= 2;
            }
            else if(curr[i] == 3){
                curr[i] += 1;
                people -= 1;
            }

            if(people == 0){
                break;
            }



        }

        boolean resolve = true;

        for (int i = 0; i < curr.length; i++) {
            resolve = curr[curr.length-1] == 4;
        }





        if (people > 0){
            System.out.printf("There isn't enough space! %d people in a queue!\n",people);
            for (int i = 0; i < curr.length ; i++) {
                System.out.print(curr[i]+" ");
            }

        }

        if (people == 0 && resolve){

            for (int i = 0; i < curr.length ; i++) {
                System.out.print(curr[i]+" ");
            }
        }

        boolean resolveTwo = true;
        for (int i = 0; i < curr.length ; i++) {
            resolveTwo = curr[curr.length-1] != 4;
        }

        if (people == 0 && resolveTwo){
            System.out.println("The lift has empty spots!");
            for (int i = 0; i < curr.length ; i++) {
                System.out.print(curr[i]+" ");
            }
        }


    }
}
