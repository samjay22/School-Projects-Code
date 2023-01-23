import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class parser{
    public String Errors;
    private int totalInts, largestInt = Integer.MIN_VALUE, smallestInt = Integer.MAX_VALUE, averageOfInts, sumOfInts;

    private FileReader fileToParse;
    public parser(FileReader fileToParse){
        this.fileToParse = fileToParse;
    }

    public void RunLogic() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(this.fileToParse);
        String errors = "\n";
        while(fileScanner.hasNextLine()){
            int parsedValue = -1;  //assuming that we have numbers above 0.
            try {
                parsedValue = Integer.parseInt(fileScanner.nextLine());
                this.totalInts += 1;
                this.smallestInt = Integer.min(parsedValue, this.smallestInt);
                this.largestInt = Integer.max(parsedValue, this.largestInt);
                this.sumOfInts += parsedValue;
            }
            catch (Exception e){
                errors = errors + e.getMessage() + ",\n";
            }
            finally {
                this.averageOfInts = this.sumOfInts / this.totalInts;
                this.Errors = errors;
                fileScanner.close();
            }
        }
    }

    @Override
    public String toString() {
        return "parser{" + "\n" +
                "Errors= '" + Errors + "\n" +
                ", totalInts= " + totalInts + "\n" +
                ", largestInt= " + largestInt + "\n" +
                ", smallestInt= " + smallestInt + "\n" +
                ", averageOfInts= " + averageOfInts + "\n" +
                ", sumOfInts= " + sumOfInts + "\n" +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       try{
           FileReader myReader = new FileReader("C:\\Users\\samjt\\IdeaProjects\\Chapter 11\\test.txt");
           parser myParser = new parser(myReader);
           myParser.RunLogic();
           System.out.println(myParser);
       }
       catch (Exception e){
           System.out.println("Invalid file input!");
       }
    }
}