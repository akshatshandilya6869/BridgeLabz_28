package Java_Regex;

public class ValidateSSN {
    public static String ValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$")?"Valid":"InValid";
    }

    public static void main(String[] args) {
        System.out.println(ValidSSN("123-45-6789"));
        System.out.println(ValidSSN("123456789"));
    }
}
