import java.util.*;





class Problem_1{

   String Name;

   public Problem_1(String Name){
      this.Name = Name;
   }
   
   public void CompareName(String NameToCompare){
      if (this.Name.equalsIgnoreCase(NameToCompare)){
         System.out.println("They are equal");
      }
      else{
         System.out.println("They are not equal");
      }
   }

}


class BubbleSort{ // O(n^2) bc I don't feel like implementing merge, heap, or quick sort
   
   private static String[] Swap(String[] Arr, int I, int J){
      String Old = Arr[I];
      Arr[I] = Arr[J];
      Arr[J] = Old;
      return Arr;
   }

   public static String[] Sort(String[] StringToSort){
      for(int i = 0; i < StringToSort.length; i++){
         for(int j = 0; j < StringToSort.length; j++){
            if(StringToSort[i].compareToIgnoreCase(StringToSort[j]) < 0){
               Swap(StringToSort, i, j);
            }
         }
      }
      return StringToSort;
   }
}

class Problem_2{
   
   final public Scanner MyScanner = new Scanner(System.in);
   private String[] Sorted = new String[3];
   
   public Problem_2(){
      for(int i = 0; i < 3; i++){
         System.out.println("Please enter a name: ");
         this.Sorted[i] = MyScanner.nextLine();
      }
      String[] Sorted = BubbleSort.Sort(this.Sorted);
      this.DisplayFinal();
   }
   
   private void DisplayFinal(){
        for(int i = 0; i < 3; i++){
         String Value = this.Sorted[i];
         System.out.println(Value);
        }
   }

}









public class driver{
   public static void main(String[] args){
      Problem_1 Solution_1 = new Problem_1("Samuel"); // New is glue... Should make a static vactory method but ehh
      Solution_1.CompareName("samuel");
      
      Problem_2 Solution_2 = new Problem_2();
      
   }
}