import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int my_variant = 9;
        int c3 = my_variant % 3;
        int c13 = my_variant % 17;
        System.out.println("My variant: " + my_variant + ". C3(StringBuilder) = " + c3 + ". C13 = " + c13);
        StringBuilder text;
        try {
            text = new StringBuilder("Elevators have become an integral part of our daily lives," +
                    " especially in cities where skyscrapers and high-rise buildings are common. They provide us" +
                    " with a convenient and efficient way to move between different floors, whether it is in a" +
                    " residential building, office complex, or shopping mall. However, many people often have concerns" +
                    " about the safety of elevators, raising questions about the likelihood of them malfunctioning and" +
                    " causing accidents. So, how safe are elevators really?");
        }
        catch (NullPointerException e){
            System.out.println("Text cannot be null. Terminating the program");
            return;
        }
        String[] wordsArray = {"They", "are", "is", "plant", "build"};

        Map<String, Integer> wordCountMap = new LinkedHashMap<>();

        for (String word : wordsArray) {
            if (word == null){
                System.out.println("Null was found among words to compare to. Terminating the program");
                return;
            }
            wordCountMap.put(word, 0);
        }

        for (String word : wordsArray) {
            Pattern pattern = Pattern.compile("\\b" + word + "\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println("Word '" + entry.getKey() + "' appears in " + entry.getValue() + " occurrences.");
        }
    }
}