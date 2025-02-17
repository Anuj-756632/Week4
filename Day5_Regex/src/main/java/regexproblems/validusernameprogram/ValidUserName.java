package regexproblems.validusernameprogram;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUserName {
//    Scanner sc=new Scanner(System.in);
    public  String validUserName(String regex){
        Pattern pattern= Pattern.compile(regex);
        String input="anuj_123";
        Matcher match=pattern.matcher(input);
        if(match.matches()){
            return input+" is Valid";
        }
        else if(input.length()<5&&input.length()<15){
            return input+" is invalid userName too short";
        }
        else{
            return "Invalid userName";
        }

    }
    public static void main(String[] args) {
        ValidUserName userName=new ValidUserName();
        String regex="^[a-zA-Z]+_?\\d+{5,15}";
        System.out.println(userName.validUserName(regex));

    }
}