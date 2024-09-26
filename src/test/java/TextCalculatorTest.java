import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TextCalculatorTest {

    private TextCalculator textCalculator;

    @BeforeEach
    void beforeTest(){
        textCalculator = new TextCalculator();
    }

    @ParameterizedTest
    @CsvSource({"', ;',  '1,2:2', 5",
               "'[ , ;',  '1[2,6,8', 17",
               "'s ;',  '1s5;7', 13"})
    public void parseAndCalculateTest(String delimiters, String inputText, int answer){
        String[] delimiterArray = delimiters.split(" ");

        int result = textCalculator.parseAndCalculate(delimiterArray, inputText);
        assertEquals(result, answer);
    }

    @Test    
    public void splitTextWithGivenDelimitersTest(){
        String[] delimiterArray = {",",":"};
        String inputText = "1,2:2";
        String[] answer = {"1","2","2"};

        String[] result = textCalculator.splitText(delimiterArray, inputText);
        assertTrue(Arrays.equals(result, answer));
    }
    
}
