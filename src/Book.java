import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {

    private List<Page> pages;
    private List<String> excludeWords;

    public Book(List<Page> pages, List<String> excludeWords) {
        this.pages = pages;
        this.excludeWords = excludeWords;
    }

    public Map<String, List<Integer>> createIndex() {
        Map<String, List<Integer>> index = new HashMap<>();
        int pageNumber = 0;
        for (Page page : pages) {
            pageNumber++;
            String[] words = page.getText().split("\\W+");
            for (String word : words) {
                if (!excludeWords.contains(word)) {
                    index.putIfAbsent(word, new ArrayList<>());
                    if (!index.get(word).contains(pageNumber)) {
                        index.get(word).add(pageNumber);
                    }
                }
            }
        }
        return index;
    }
}
