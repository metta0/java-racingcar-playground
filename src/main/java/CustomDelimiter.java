
public class CustomDelimiter {

    public boolean isCustomDelimiterExists(String inputText) {
        return inputText.startsWith("//") &&
        inputText.startsWith("\n",3);
    }

    public String getCustomDelimiter(String inputText){
        String a ="\"";
        return inputText.charAt(2) + "";
    }


}
