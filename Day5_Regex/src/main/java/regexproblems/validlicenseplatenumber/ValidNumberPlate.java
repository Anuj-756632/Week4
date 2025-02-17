package regexproblems.validlicenseplatenumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumberPlate {
    //    Scanner sc=new Scanner(System.in);
    public String validNumberPlate(String regex){
        Pattern pattern=Pattern.compile(regex);
        String input="AB2343";
        Matcher match=pattern.matcher(input);
        if(match.matches()){
            return input+" is Valid";
        }
        else{
            return input+" is Invalid";
        }
    }
    public static void main(String[] args) {
        String regex="^[A-Z]{2}\\d{4}";
        ValidNumberPlate numberPlate=new ValidNumberPlate();
        System.out.println(numberPlate.validNumberPlate(regex));
    }
}
