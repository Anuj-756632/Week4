package regexproblemtests.validatehexcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import regexproblems.validhexcolorcode.ValidateHexColorCode;

public class ValidateHexCodeTest {
    @Test
    void f1(){
        String regex="^#[0-9A-Fa-f]{6}";
        ValidateHexColorCode code=new ValidateHexColorCode();
        Assertions.assertEquals("is Valid",code.validCode(regex));
    }
}
