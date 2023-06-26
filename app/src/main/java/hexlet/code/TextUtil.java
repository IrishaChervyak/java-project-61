package hexlet.code;

public final class TextUtil {
    private TextUtil() {
        // Приватный конструктор
    }

    public static boolean textToBoolean(String text) {
        return text.equals("yes");
    }

    public static String booleanToText(boolean value) {
        return value ? "yes" : "no";
    }
}
