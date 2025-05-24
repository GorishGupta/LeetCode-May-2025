import java.util.*;

public class DS2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList<Integer> map = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                map.add(i);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        DS2942 ds = new DS2942();
        String[] words = { "hello", "world", "java", "programming" };
        char x = 'o';
        List<Integer> result = ds.findWordsContaining(words, x);
        System.out.println(result); // Output: [0, 1]
    }
}
