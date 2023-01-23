/* 
Sam 1/17/22 2:00 pm CST

Solves the 5.15 question in the book.

*/


import java.util.*;


class Problem_1_Solution{
   
   static String[][]AsciiList = new String[10][10];
   
   public static void main(String[] args){
      
      int Col = 0;
      int Row = 0;
      
      for(int i = 33; i <= 126; i++){
         if(Row >= 10){
            Row = 0;
            Col += 1;
         }
         AsciiList[Col][Row] = String.valueOf((char)i); 
         Row += 1;
      }
      
      for(int x = 0 ; x < AsciiList.length; x++){
         for(int y = 0; y < AsciiList[x].length; y++){
            if(AsciiList[x][y] != null){
               if(y < 9){
                  System.out.print(AsciiList[x][y] + " ");
               }
               else if(y >= 9){
                  System.out.println(AsciiList[x][y] + " ");
               }
            }
         }
      }
      
   }

}