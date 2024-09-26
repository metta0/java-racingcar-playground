import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String inputText) throws Exception{
        int result = 0;

        if(isInputTextEmpty(inputText))
            return 0;
        
        checkInputValidation(inputText);
        inputText = removeCustomDelimiterIfExists(inputText);
        result = splitWithDelimitersAndSum(inputText);

        return result;
    }

    private static boolean isInputTextEmpty(String inputText){
        return inputText == null || inputText == "" ;
    }

    private static String removeCustomDelimiterIfExists(String inputText){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputText);

        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            inputText = matcher.group(2).replace(customDelimiter, ":");
        }
        return inputText;
    }

    private static void checkInputValidation(String inputText){
        String text = removeCustomDelimiterIfExists(inputText);
        Matcher matcher = Pattern.compile("[^,:0-9]").matcher(text);

        if(matcher.find()){
            throw new RuntimeException("Wrong input :");
        }

    }

    private static int splitWithDelimitersAndSum(String inputText){
        int result = 0;
        String[] tokens = inputText.split(",|:");
        
        for(String token : tokens){
            result += Integer.parseInt(token);
        }
        return result;
    }
    
}
