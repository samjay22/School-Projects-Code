/*

I couldn't figure out how to fromat the right bar on the check. I did the best I could given the info I had.
*/

import java.text.*;
import java.util.*;

class EnglishNumberToWords {

  private static final String[] tensNames = {
    "",
    " ten",
    " twenty",
    " thirty",
    " forty",
    " fifty",
    " sixty",
    " seventy",
    " eighty",
    " ninety"
  };

  private static final String[] numNames = {
    "",
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
  };

  private EnglishNumberToWords() {}

  private static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    }
    if (number == 0) return soFar;
    return numNames[number] + " hundred" + soFar;
  }


  public static String convert(long number) {
    // 0 to 999 999 999 999
    if (number == 0) { return "zero"; }

    String snumber = Long.toString(number);

    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));

    String tradBillions;
    switch (billions) {
    case 0:
      tradBillions = "";
      break;
    case 1 :
      tradBillions = convertLessThanOneThousand(billions)
      + " billion ";
      break;
    default :
      tradBillions = convertLessThanOneThousand(billions)
      + " billion ";
    }
    String result =  tradBillions;

    String tradMillions;
    switch (millions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = convertLessThanOneThousand(millions)
         + " million ";
      break;
    default :
      tradMillions = convertLessThanOneThousand(millions)
         + " million ";
    }
    result =  result + tradMillions;

    String tradHundredThousands;
    switch (hundredThousands) {
    case 0:
      tradHundredThousands = "";
      break;
    case 1 :
      tradHundredThousands = "one thousand ";
      break;
    default :
      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
         + " thousand ";
    }
    result =  result + tradHundredThousands;

    String tradThousand;
    tradThousand = convertLessThanOneThousand(thousands);
    result =  result + tradThousand;

    // remove extra spaces!
    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }
}


class CheckMaker{
   
   public static String printBox(String Input) {
      return "";
   }
   
   public CheckMaker(){
      
      Scanner MyScanner = new Scanner(System.in);
      
      String Payee;;
      int CheckNumber;;
      double CheckAmount;
      
      System.out.println("Payee?");
      Payee = MyScanner.nextLine();
      System.out.println("Check Number?");
      CheckNumber = MyScanner.nextInt();
      System.out.println("CheckAmount?");
      CheckAmount = MyScanner.nextDouble();
      
      String Test =  
      "|-----------------------------------------------------------------------|\n|"
      + "\tDate : 2/2/22 \t\t\t\t\t\t\t\t\t\t\t\t\t\t Check# %s\t\t|\n|" + 
      "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| \n|" +
      "\tPaid to the order of: %s\t\t\t\t\t\t\t\t\t\t$ %s     \t\t|\n" +  
      "|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| \n|" +
      "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDOLLARS\t|\n" +
      "|\t\t***" + "%s" + " and %s/100***            \t\t\t\t\t|\n" + 
      "|\tMEMO____________________ \t\t _________________________ \t\t\t\t|" +
      "\n|         12345678        \t\t         11111111111111        \t\t\t\t|" +
      "\n|-----------------------------------------------------------------------|";
      
      String[] SplitStr = String.valueOf(CheckAmount).split("\\.", 2);
      String AmountAsString = EnglishNumberToWords.convert(Integer.parseInt(SplitStr[0]));
      
      System.out.println(String.format(Test, CheckNumber, Payee, CheckAmount, AmountAsString, SplitStr[1]));
   }

}


public class Driver{
   
   public static void main(String[] args){
      CheckMaker M = new CheckMaker();
      
   }

}
