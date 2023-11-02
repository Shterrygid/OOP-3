import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceExtractor {
    public static void main(String[] args) {
        String text = "Список цен:\n" +
                "- 23.78 USD\n" +
                "- 1500 RUR\n" +
                "- 19.99 EU\n" +
                "- 22 UDD\n" +
                "- 0.002 USD";

        String regex = "\\b(\\d+(\\.\\d+)?)\\s+(USD|RUR|EU)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            double price = Double.parseDouble(matcher.group(1));
            String currency = matcher.group(3);
            System.out.printf("%.2f %s%n", price, currency);
        }
    }
}