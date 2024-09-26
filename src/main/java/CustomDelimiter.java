
public class CustomDelimiter {

    public String getCustomDelimiterIfExists(String inputText){
        if(isCustomDelimiterExists(inputText)){
            return inputText.charAt(2) + "";
        }
        return "";
    }

    public boolean isCustomDelimiterExists(String inputText) {
        return inputText.startsWith("//") &&
        inputText.startsWith("\n",3);
    }

    public String removeCustomTextIfExists(String inputText) {
        if(isCustomDelimiterExists(inputText)){
            return inputText.substring(4);
        }
        return inputText;
    }


}
