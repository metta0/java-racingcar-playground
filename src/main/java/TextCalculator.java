import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TextCalculator {
    CustomDelimiter customDelimiter;

    public int splitAndSum(String inputText) throws Exception {
        customDelimiter = new CustomDelimiter();
        ArrayList<String> delimiters = new ArrayList(Arrays.asList(",", ":"));
        
        if(isInputValueEmpty(inputText))
            return 0;

        addCustomDelimiterIfExists(delimiters, inputText);
        inputText = removeCustomTextIfExists(inputText);

        return parseAndCalculate(delimiters, inputText);
    }

    private boolean isInputValueEmpty(String inputText){
        if(inputText == null || inputText == ""){
            return true;
        }
        return false;
    }

    private void addCustomDelimiterIfExists(ArrayList<String> delimiters, String inputText){
        if(customDelimiter.isCustomDelimiterExists(inputText)){
            delimiters.add(customDelimiter.getCustomDelimiterIfExists(inputText));
        }
    }

    private String removeCustomTextIfExists(String inputText){
        return customDelimiter.removeCustomTextIfExists(inputText);
    }

    public int parseAndCalculate(ArrayList<String> delimiters, String inputText) throws Exception{
        String[] splittedText = splitText(delimiters, inputText);
        
        validateInputText(String.join("",splittedText));
        return getIntegerSum(splittedText);
    }

    public String[] splitText(ArrayList<String> delimiterArray, String inputText) {
        for(String delimiter : delimiterArray){
            inputText = inputText.replace(delimiter, ":");            
        }
        
        return inputText.split(":");
    }

    private int getIntegerSum(String[] splittedText){
        int result = 0;
        
        for(String text : splittedText)
            result += Integer.parseInt(text);
        
        return result;
    }

    public void validateInputText(String inputText){
        String regex = "^[0-9]+";
        if(!Pattern.matches(regex, inputText)){
            throw new RuntimeException("Wrong input value");
        }
    }

    
}
