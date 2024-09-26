
public class TextCalculator {
    
    public int parseAndCalculate(String[] delimiters, String inputText){
        String[] splittedText = splitText(delimiters, inputText);
        
        return getIntegerSum(splittedText);
    }

    public String[] splitText(String[] delimiterArray, String inputText) {
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
