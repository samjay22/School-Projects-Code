import java.util.ArrayList;
import java.util.Scanner;

interface Panel{

    //Static number of judges that will be judging.
    public int JUDGES = 7;

    private void addNewScore(float Score){}
    private float promptUserForDifficulty(){
        return 0.0f;
    }
    public float CalcScore();
    public void PromptForJudgeScores();

}

class JudgePanel implements Panel{

    public ArrayList<Float> SCORES = new ArrayList<>();

    private float Largest = 0, Smallest = 10;
    private float DifficultyScore;

    private Scanner MyScanner = new Scanner(System.in);
    public JudgePanel(){
        this.DifficultyScore = this.promptUserForDifficulty();
    }

    private float promptUserForDifficulty(){

        System.out.println("Please enter a difficulty scale from 1.2 to 3.8.");

        float DiffScore = MyScanner.nextFloat();

        if(DiffScore >= 1.2f && DiffScore <= 3.8f){
            return DiffScore;
        }
        else{
            return this.promptUserForDifficulty();
        }
    }
    private void addNewScore(float Score) {

        Largest = Math.max(Largest, Score);
        Smallest = Math.min(Smallest, Score);

        if (Score >= 0.0f && Score <= 10.0f){
            if(this.SCORES.size() < this.JUDGES){
                this.SCORES.add(Score);
            }
        }
    }

    @Override
    public void PromptForJudgeScores(){

        int NumberOfJudgesAsked = 0;


        while (NumberOfJudgesAsked < this.JUDGES){
            System.out.println(String.format("Please enter a judge score for judge %s!", NumberOfJudgesAsked + 1));
            float JudgeScore = MyScanner.nextFloat();
            if (JudgeScore >= 0.0f && JudgeScore <= 10.0f){
                NumberOfJudgesAsked++;
                this.addNewScore(JudgeScore);
            }
        }
    }

    @Override
    public float CalcScore() {

        float Total = 0;

        for(int i = 0; i < JUDGES; i++){
            Total += this.SCORES.get(i);
        }
        Total = Total - (Largest + Smallest);

        return Total + (Total * (this.DifficultyScore + 0.06f));
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        JudgePanel MyPanel = new JudgePanel();
        MyPanel.PromptForJudgeScores();
        float FinalScore = MyPanel.CalcScore();
        System.out.println(String.format("Final score is: %s", FinalScore));
    }
}