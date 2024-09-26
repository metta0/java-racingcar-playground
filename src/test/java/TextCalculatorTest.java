import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
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
    public void parseAndCalculateTest(String delimiters, String inputText, int answer) throws Exception{
        ArrayList<String> delimiterArray = new ArrayList<>(Arrays.asList(delimiters.split(" ")));

        int result = textCalculator.parseAndCalculate(delimiterArray, inputText);
        assertEquals(result, answer);
    }

    @Test    
    public void splitTextWithGivenDelimitersTest(){
        ArrayList<String> delimiterArray = new ArrayList<>(Arrays.asList(",",":"));
        String inputText = "1,2:2";
        String[] answer = {"1","2","2"};

        String[] result = textCalculator.splitText(delimiterArray, inputText);
        assertTrue(Arrays.equals(answer, result));
    }
    
    @ParameterizedTest
    @CsvSource({"5,  '1,2:2'",
                "6,  '1,2:3'",
                "8,  '1,5:2'"})
    public void splitAndSumTest(int answer, String inputText) throws Exception{
        int result = textCalculator.splitAndSum(inputText);
        assertEquals(answer, result);
    }

    @Test
    public void validateInputTextTest(){
        assertThatThrownBy(() -> {
            textCalculator.splitAndSum("-1");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("Wrong input value");
    }


    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception{
        int result = textCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = textCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

     @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = textCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = textCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = textCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = textCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> textCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
