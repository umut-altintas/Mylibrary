package InputHandling;

import org.apache.commons.lang3.text.WordUtils;
import org.jetbrains.annotations.NotNull;


public class StringHandler {
    public static String Name(@NotNull String name) {
        String result = String.join(" ", name.trim().split("\\s+"));
        return WordUtils.capitalizeFully(result);
    }
}
