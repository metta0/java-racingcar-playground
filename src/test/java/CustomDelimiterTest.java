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
                "'//;;\n1g2g3', false"})
    public void isCustomDelimiterExistsTest(String inputText, Boolean result){
        assertEquals(customDelimiter.isCustomDelimiterExists(inputText), result);
    }

    @ParameterizedTest
    @CsvSource({"'//g\n1g2g3', 'g'",
                "'//;\n1g2g3', ';'",
                "'///\n1g2g3', '/'",
                "'//\\n1g2g3', '\\'"})
    public void getCustomDelimiterTest(String inputText, String answer){
        assertEquals(customDelimiter.getCustomDelimiter(inputText), answer);
    }
}
