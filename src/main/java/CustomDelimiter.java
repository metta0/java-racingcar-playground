
public class CustomDelimiter {

    public boolean isCustomDelimiterExists(String inputText) {
        return inputText.startsWith("//") &&
        inputText.startsWith("\n",3);
    }


}
