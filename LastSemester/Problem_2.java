import java.util.HashMap;
import java.util.Scanner;
public class Problem_2{

    public static void main(String [] args)
    {
        Scanner MyScanner =new Scanner(System.in);
        HashMap<Integer, Integer> Scores = new HashMap<>();

        int NumberInput = 1;

        while (NumberInput > 0){

            System.out.println("Please enter your score for the EuroCafe in the range of 1 to 10!");
            NumberInput = MyScanner.nextInt();

            if(NumberInput > 0 && NumberInput <= 10){
                Scores.put(NumberInput, Scores.getOrDefault(NumberInput, 0) + 1);
            }
            else{
                System.out.println("Invalid input! \n");
            }
        }

       Scores.forEach((Score, Amount) -> {
           System.out.println(String.format("Ranking %s was received %s times!", Score, Amount));
       });

    }//end main

}//end class