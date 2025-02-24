class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}

public class Main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // This will show a warning
        api.newFeature();
    }
}
