/* 
Sam 1/29/22 2 PM CST


Solves problem 1 Module 3.

*/

import java.util.*;
import My_Package.*;


class Lock{

   private int[] Combo;
   private int Turns = 0;
   
   public int[] CurrentCombo;
   public int Dial = 0;
   
   public Lock(int[] Combo){
      this.Combo = Combo;
      this.CurrentCombo = new int[Combo.length];
   }
   
   public boolean TryOpen(){
      for(int i = 0; i < this.Combo.length; i++){
         if(this.Combo[i] != this.CurrentCombo[i]){
            return false;
         }
      }
      return true;
   }
   
   private void setValue(int Value){
      this.Dial = Value;
      if(this.Turns < this.Combo.length){
         this.CurrentCombo[this.Turns] = Value;
         this.Turns += 1;
      }
      else{
         System.out.println("Auto reset; passed turn limit");
         ResetDial();
      }
   }
   
   public void ResetDial(){
       this.Dial = 0;
       this.Turns = 0;
   }
   
   public void TurnLeft(int ComboNumber){
      setValue(ComboNumber);
   }
   
   public void TurnRight(int ComboNumber){
      setValue(ComboNumber);
   }
}



class Locker{
   
   private ArrayList<Book> Books = new ArrayList<Book>();
   private Lock ComboLock;
   private Scanner SystemScanner = new Scanner(System.in);
   private boolean Open = false;
   
   public String LockerOwner;
   public int LockerNumber;
   
   public Locker(int LockerNumber, String LockerOwner){
      int[] Combo = {1,2,3};
      this.LockerNumber = LockerNumber;
      this.ComboLock = new Lock(Combo);
      this.LockerOwner = LockerOwner;
   }
   
   public Book PutBook(Book BookToAdd){
      if(!this.Open){return BookToAdd;}
      Books.add(BookToAdd);
      return BookToAdd;
   }
   
   public Book RemoveBook(Book BookToRemove){
      if(!this.Open){return BookToRemove;}
      int Index = Books.indexOf(BookToRemove);
      Book Refrence;
      
      if(Index >= 0){
         Refrence = Books.get(Index);
         Books.remove(Index);
         return Refrence;
      }
      return BookToRemove;
   }
   
   public boolean Open(){
      return this.Open;
   }
   
   public void OpenLocker(){
      for(int i = 0; i < 3; i++){
         System.out.println(String.format("Please enter digit #%s of your combo", i));
         if(i % 2 == 0){
            this.ComboLock.TurnLeft(SystemScanner.nextInt());
         }
         else{
            this.ComboLock.TurnRight(SystemScanner.nextInt());
         }
      }
      this.Open = this.ComboLock.TryOpen();
   }
   
   public void CloseLocker(){
      this.Open = false;
   }
   
   @Override
   public String toString(){
      return String.format("Locker Number: %s\nLocker Owner: %s\nBooks in locker: %s\nLocker Open: %s", this.LockerNumber, this.LockerOwner, this.Books.size(), this.Open);
   }
}


class Test{

   public static void main(String[] args){
      
      Book MyBook = new Book("Book 1", "Sam", 50000);
      Locker MyLocker = new Locker(400, "Donald Duck");
      MyLocker.OpenLocker();
      MyLocker.PutBook(MyBook);
      System.out.println(MyLocker);
   }

}