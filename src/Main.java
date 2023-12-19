import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int my_variant = 9;
        int c3 = my_variant % 3;
        int c13 = my_variant % 17;
        System.out.println("My variant: " + my_variant + ". C3(StringBuilder) = " + c3 + ". C13 = " + c13);

        StringBuilder text = new StringBuilder("Elevators have become an integral part of our daily lives," +
                " especially in cities where skyscrapers and high-rise buildings are common. They provide us" +
                " with a convenient and efficient way to move between different floors, whether it is in a" +
                " residential building, office complex, or shopping mall. However, many people often have concerns" +
                " about the safety of elevators, raising questions about the likelihood of them malfunctioning and" +
                " causing accidents. So, how safe are elevators really?");
        String[] wordsArray = {"They", "are", "is"};

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordsArray) {
            wordCountMap.put(word, 0);
        }

        for (String word : wordsArray) {
            int index = text.indexOf(word);

            while (index != -1) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
                if (index + 1 < text.length()){
                    index = text.indexOf(word, index + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println("Word '" + entry.getKey() + "' appears in " + entry.getValue() + " occurrences.");
        }
    }
}