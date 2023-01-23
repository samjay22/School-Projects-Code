/*
Sam 2/11/22 12:30 PM CST

Solves Chapter 12, Page 497, Question 12.31

*/



import java.util.*;
import java.net.*;
import java.io.*;


class Struct<T>{

   private ArrayList<T> Holder;
   
   public Struct(){
      this.Holder = new ArrayList<T>();
   }
   
   public void put(T Value){
      this.Holder.add(Value);
   }
   
   public int length(){
      return this.Holder.size();
   }
   
   public T get(int Index){
      return this.Holder.get(Index);
   }
   
   public T pop(int Index){
      T Value = this.get(Index);
      this.Holder.remove(Index);
      return Value;
   }
}

class FileReader{
   
   private Scanner My_Scanner;
   private ArrayList<String[]> Arr = new ArrayList<String[]>();
   
   private int TopNamesAmount;
   private String Line;
   
   public FileReader(String url, int TopNames){
      
      TopNamesAmount = TopNames;
      
      try{
      
      URL My_Url = new URL(url);
      My_Scanner = new Scanner(My_Url.openStream());
      
      }
      catch(MalformedURLException E_1){
         E_1.printStackTrace();
      }
      catch(IOException E_2){
         E_2.printStackTrace();
      }       
   }
   
   private Struct[] SetupStructs(){
      
      Struct[] Arr = new Struct[4];
      
      Struct BoyNumbers = new Struct<Integer>();
      Struct GirlNumbers = new Struct<Integer>();
      
      Struct BoyNames = new Struct<String>();
      Struct GirlNames = new Struct<String>();
      
       while(My_Scanner.hasNext()){
         Line = My_Scanner.nextLine();
         BoyNumbers.put(Integer.decode(Line.replaceAll("\\D+", "-").split("-", 3)[1]));
         GirlNumbers.put(Integer.decode(Line.replaceAll("\\D+", "-").split("-", 3)[2]));
         BoyNames.put(Line.replaceAll("\\s+", "-").split("-", 5)[1]);
         GirlNames.put(Line.replaceAll("\\s+", "-").split("-", 5)[3]);
       }
      
      
      Arr[0] = BoyNumbers;
      Arr[1] = GirlNumbers;
      Arr[2] = BoyNames;
      Arr[3] = GirlNames;
   
      return Arr;
   }
   
   public ArrayList[] Sort(){
   
      ArrayList[] Sorted = new ArrayList[3];
      
      int[] CurrentBoy = {0,0}; // Amount, Index
      int[] CurrentGirl = {0,0};
      
      ArrayList<String> BoyNames = new ArrayList<String>();
      ArrayList<String> GirlNames = new ArrayList<String>();
      ArrayList<Integer> Years = new ArrayList<Integer>();
      
      Struct[] Data = this.SetupStructs();
               
      for(int I = 0; I < this.TopNamesAmount; I++){
         
         for(int N = 0; N < Data[0].length(); N++){
            if((int)Data[0].get(N) >= CurrentBoy[0]){
               CurrentBoy[0] = (int)Data[0].get(N);
               CurrentBoy[1] = N;
            } 
         }
         
         for(int N = 0; N < Data[1].length(); N++){
            if((int)Data[1].get(N) >= CurrentGirl[0]){
               CurrentGirl[0] = (int)Data[1].get(N);
               CurrentGirl[1] = N;
            } 
         }

            BoyNames.add((String)Data[2].get(CurrentBoy[1]));
            GirlNames.add((String)Data[3].get(CurrentGirl[1]));
           

         CurrentGirl[0] = 0;
         CurrentGirl[1] = 0;
         CurrentBoy[0] = 0;
         CurrentBoy[1] = 0;
         
         Years.add(I); // Add the year for names after reset.
         
         Data[0].pop(CurrentBoy[1]);
         Data[1].pop(CurrentGirl[1]);
         Data[2].pop(CurrentBoy[1]);
         Data[3].pop(CurrentGirl[1]);
         
      }
      
      
      Sorted[0] = BoyNames;
      Sorted[1] = GirlNames;
      Sorted[2] = Years;
      
      return Sorted;
   }
   
}


class Driver{
   
   public static void main(String[] args){
      //"http://liveexample.pearsoncmg.com/data/babynamesranking%s.txt"
      
         FileReader New = new FileReader("http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt", 5);
         ArrayList[] SortedFile = New.Sort();

         
         //For loops wouldnt allow me to do multiple years, I dont feel like figuring out why Scanner is nil if I format the URL. I tried encoding with URL encoder and still same error.
         // This is someone elses problem now.
         
         System.out.println("Year \s Rank 1 \s Rank 2 \s Rank 3 \s Rank 4 \s Rank 5");
         System.out.println(String.format("%s \s %s \s %s \s %s \s %s\s %s", 2010, SortedFile[1].get(0), SortedFile[1].get(1), SortedFile[1].get(2), SortedFile[1].get(3), SortedFile[1].get(4)));
         System.out.println(String.format("%s \s %s \s %s \s %s \s %s\s %s", 2010, SortedFile[0].get(0), SortedFile[0].get(1), SortedFile[0].get(2), SortedFile[0].get(3), SortedFile[0].get(4)));

         
   }

}