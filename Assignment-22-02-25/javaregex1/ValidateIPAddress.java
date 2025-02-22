package Java_Regex;

public class ValidateIPAddress {
    public static String ValidIP(String ip) {
        return ip.matches("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$")?"Valid":"InValid";
    }

    public static void main(String[] args) {
        System.out.println(ValidIP("222.188.154.127"));
        System.out.println(ValidIP("182.200.126.156"));
    }
}