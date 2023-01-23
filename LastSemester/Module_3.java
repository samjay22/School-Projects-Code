import java.util.*;

class Problem_1{
    
    int X,Y;
    
    public Problem_1(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
    
    private int Product(){
        return this.X * this.Y;
    }
    
    private int Sum(){
        return this.X + this.Y;
    }
    
    private int Difference(){
        return this.X - this.Y;
    }
    
    @Override
    public String toString(){
        return String.format("Sum: %d\nDifference: %d\nProduct: %d", Sum(), Difference(), Product());
    }
}

class Problem_2{
   
   private final Scanner MyScanner = new Scanner(System.in); // Get scanner...
   
   private void StringUpperCase(String StringToChange){
      System.out.println(StringToChange.toUpperCase());     
   }
   
   private void StringToLower(String StringToChange){
      System.out.println(StringToChange.toLowerCase());
   }
   
   public Problem_2(){
      String Input = MyScanner.nextLine();
      StringUpperCase(Input);
      StringToLower(Input);
   } // Consructor
}

public class Module_3 {

    public static void main(String[] args) {
        
        Problem_1 Solution_1 = new Problem_1(5,2);
        Problem_2 Solution_2 = new Problem_2();
        
        System.out.println("");
        System.out.println(Solution_1);
    }
}
