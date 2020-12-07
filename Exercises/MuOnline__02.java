import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("(\\|)"))
                .collect(Collectors.toList());

         // rat 10|bat 20|potion 10|rat 10|chest 100|boss 70|chest 100
        // cat 10|potion 30|orc 10|chest 10|snake 25|chest 110


        int bitcoin = 0;

       int health = 100;

       int countRoom = 0;


        while (!elements.isEmpty()) {


            for (int i = 0; i < elements.size() ; i++) {

                String[] operations = elements.get(i).split(" ");


                switch (operations[0]){
                    case "potion":
                        int numHealed = Integer.parseInt(operations[1]);
                        if(health + numHealed > 100){
                            System.out.printf("You healed for %d hp.\n",100-health);
                            health = 100;
                            System.out.printf("Current health: %d hp.\n",health);
                        } else {
                            health = health + numHealed;
                            System.out.printf("You healed for %d hp.\n",numHealed);
                            System.out.printf("Current health: %d hp.\n",health);
                        }
                        countRoom++;
                        elements.remove(i);
                        i--;

                        break;
                    case "chest":
                        int bitcoinFound = Integer.parseInt(operations[1]);
                        bitcoin+=bitcoinFound;
                        countRoom++;
                        System.out.printf("You found %d bitcoins.\n",bitcoinFound);
                        elements.remove(i);
                        i--;
                        break;
                    default:
                        String nameMonster = operations[0];
                        int monsterAttack = Integer.parseInt(operations[1]);

                        health -= monsterAttack;

                        if(health <= 0){
                            countRoom++;
                            System.out.printf("You died! Killed by %s.\n",nameMonster);
                            System.out.printf("Best room: %d\n",countRoom);
                            elements.remove(i);
                            i--;
                            return;
                        } else {
                            System.out.printf("You slayed %s.\n",nameMonster);
                            countRoom++;
                            elements.remove(i);
                            i--;
                        }
                        break;

                }

            }

        }

        System.out.printf("You've made it!\n");
        System.out.printf("Bitcoins: %d\n",bitcoin);
        System.out.printf("Health: %d\n",health);

    }
}
