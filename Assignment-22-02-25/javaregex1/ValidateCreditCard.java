package Java_Regex;

public class ValidateCreditCard {
    public static String ValidVisa(String card) {
        return card.matches("^4\\d{15}$")?"Valid":"InValid";
    }

    public static String ValidMasterCard(String card) {
        return card.matches("^5\\d{15}$")?"Valid":"InValid";
    }

    public static void main(String[] args) {
        System.out.println(ValidVisa("4222222222222222"));
        System.out.println(ValidMasterCard("5444444444444444"));
        System.out.println(ValidVisa("789456123789456"));
    }
}