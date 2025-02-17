package regexproblems.validhexcolorcode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {
    //    Scanner sc=new Scanner(System.in);
    public String validCode(String regex){
        Pattern pattern=Pattern.compile(regex);
        String input="#ff6425";
        Matcher match=pattern.matcher(input);
        if(match.matches()){
            return input+" is Valid";
        }
        return input+" is Invalid";
    }
    public static void main(String[] args) {
        ValidateHexColorCode code=new ValidateHexColorCode();
        String regex="^#[0-9A-Fa-f]{6}";
        System.out.println(code.validCode(regex));
    }
}

