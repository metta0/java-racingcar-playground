import java.util.ArrayList;
import java.util.Arrays;

public class TextCalculator {
    CustomDelimiter customDelimiter;

    public int splitAndSum(String inputText) {
        customDelimiter = new CustomDelimiter();
        ArrayList<String> delimiters = new ArrayList(Arrays.asList(",", ":"));

        addCustomDelimiterIfExists(delimiters, inputText);
        
        return parseAndCalculate(delimiters, inputText);
    }

    private void addCustomDelimiterIfExists(ArrayList<String> delimiters, String inputText){
        if(customDelimiter.isCustomDelimiterExists(inputText)){
            delimiters.add(customDelimiter.getCustomDelimiterIfExists(inputText));
        }
    }

    public int parseAndCalculate(ArrayList<String> delimiters, String inputText){
        String[] splittedText = splitText(delimiters, inputText);
        
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
}
