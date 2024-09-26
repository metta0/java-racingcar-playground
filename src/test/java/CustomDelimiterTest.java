import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CustomDelimiterTest {

    private CustomDelimiter customDelimiter;

    @BeforeEach
    public void beforeTest(){
        customDelimiter = new CustomDelimiter();
    }

    @ParameterizedTest
    @CsvSource({"'//g\n1g2g3', true",
                "'//gn1g2g3', false",
                "'/g\n1g2g3', false",
                "'//;;\n1g2g3', false",
                "'//', false"})
    public void isCustomDelimiterExistsTest(String inputText, Boolean answer){
        assertEquals(answer, customDelimiter.isCustomDelimiterExists(inputText));
    }

    @ParameterizedTest
    @CsvSource({"'//g\n1g2g3', 'g'",
                "'//;\n1g2g3', ';'",
                "'//k\n1g2g3', 'k'"})
    public void getCustomDelimiterTest(String inputText, String answer){
        assertEquals(answer, customDelimiter.getCustomDelimiterIfExists(inputText));
    }

    @ParameterizedTest
    @CsvSource({"'//g\n1g2g3', '1g2g3'",
                "'//;\n1,2,3;4;5', '1,2,3;4;5'",
                "'///\n12345', '12345'",
                "'//x\n1;2x3', '1;2x3'"})
    public void getTextWithoutCustomDelimiterTest(String inputText, String answer){
        assertEquals(answer, customDelimiter.removeCustomTextIfExists(inputText));
    }
}
