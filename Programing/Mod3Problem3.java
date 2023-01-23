/* 
Sam 1/29/22 2 PM CST


Solves problem 3 Module 3.

*/

import java.util.*;
import My_Package.*;

class Volume{
   
   private String VolumeName;
   
   private ArrayList<Book> Books = new ArrayList<Book>();
   private Builder BooksBuilder = new Builder();
   
   public Volume(String VolumeName){
      this.VolumeName = VolumeName;
   }
   
   public void AddBook(Book BookToAdd){
      Books.add(BookToAdd);
      BooksBuilder.Append(BookToAdd.toString());
   }
   
   private int GetSize(){ // "static method problem", like low key I dont get this but it is what it is. I guess the invoke was in a non-static context.
      int size = 0;
      
      for(int i = 0; i < this.Books.size(); i++){
         size += 1;
      }
      
      return size;
   }
   
   public void GetVolumeInfo(){
      System.out.println(this.BooksBuilder);
   }
   
   @Override
   public String toString(){
      return String.format(" Volume Name: %s \n Books in Volume: %s  \n Books info: \n %s \n", this.VolumeName, GetSize(),  this.BooksBuilder);
   }
   
}


class Book{

   private String Title;
   private String Author;
   private int NumberOfPages;
   
   public String Title(){
      return this.Title;
   }
   
   public String Author(){
      return this.Author;
   }
   
   public int NumberOfPages(){
      return this.NumberOfPages;
   }
   
   public Book(String BookTitle, String AuthorName, int Pages){
      this.Title = BookTitle; 
      this.Author = AuthorName; 
      this.NumberOfPages = Pages;
   }
   
   @Override
   public String toString(){
      return String.format("Title: %s \n Author: %s \n Pages: %s \n", this.Title, this.Author, this.NumberOfPages);
   }
}


class Start{

   public static void main(String[] args){
      Volume NewVolume = new Volume("LOTR");
      Book Book_1 = new Book("Book 1", "Sam", 500);
      Book Book_2 = new Book("Book 2", "Sam", 5000);
      NewVolume.AddBook(Book_1);
      NewVolume.AddBook(Book_2);
      System.out.println(NewVolume);
   }
   
}