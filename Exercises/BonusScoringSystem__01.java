import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusScoringSystem__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double studentNumber = Double.parseDouble(scanner.nextLine());

        double lectureNumber = Double.parseDouble(scanner.nextLine());

        double bonus = Double.parseDouble(scanner.nextLine());


        double max = 0;

        if(studentNumber == 0 && lectureNumber == 0){
            System.out.println("Max Bonus: 0.");
            System.out.println("The student has attended 0 lectures.");
            return;
        }


        for (int i = 0; i < studentNumber ; i++) {
              double attendances = Double.parseDouble(scanner.nextLine());


              if(attendances > max){
                  max = attendances;

              }

        }


        System.out.printf("Max Bonus: %.0f.\n",Calculations(max,lectureNumber,bonus));
        System.out.printf("The student has attended %.0f lectures.",max);

    }

    public  static double Calculations (double max,double lecture,double bonus){
        double totalBonus = (max / lecture) * (5+bonus);
        return Math.ceil(totalBonus);
    }
}
