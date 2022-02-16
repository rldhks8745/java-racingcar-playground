package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,|:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;

        return sum(split(text));
    }

    private static int sum(String[] split) throws RuntimeException {
        if (split.length == 1)
            return Integer.parseInt(split[0]);

        return Arrays.stream(split)
                .map(StringAddCalculator::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static int parseInt(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0)
            throw new RuntimeException("값은 음수가 될 수 없습니다.");

        return number;
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        String delimiter = DEFAULT_DELIMITER_REGEX;
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return text.split(delimiter);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
