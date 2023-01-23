import Problem_2.*;



class Driver{
   //(int Pages, int Chapters, String Author, String Title, String BookType, String Genre)
   public static void main(String[] args){
      Novel New_Book = new Novel(500, 20, "Timmy", "The book", "Education", "Learning", "School");
      Magazine New_Mag = new Magazine(25, 20, "Tom", "The Mag", "Education", "Learning", "School");

      System.out.println(New_Book);
      System.out.println(New_Mag);
   }

}