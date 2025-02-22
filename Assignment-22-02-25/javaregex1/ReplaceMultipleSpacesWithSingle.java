package Java_Regex;

public class ReplaceMultipleSpacesWithSingle {
    public static String fixSpaces(String st) {
        return st.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        System.out.println(fixSpaces("This   is   an   example   with   multiple   spaces."));
    }
}
