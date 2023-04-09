
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> excludeWords = Files.readAllLines(Paths.get("src/exclude-words.txt"));
        List<String> page1Lines = Files.readAllLines(Paths.get("src/Page1.txt"));
        List<String> page2Lines = Files.readAllLines(Paths.get("src/Page2.txt"));
        List<String> page3Lines = Files.readAllLines(Paths.get("src/Page3.txt"));
        Page page1 = new Page(String.join("\n", page1Lines));
        Page page2 = new Page(String.join("\n", page2Lines));
        Page page3 = new Page(String.join("\n", page3Lines));
        Book book = new Book(Arrays.asList(page1, page2, page3), excludeWords);
        Map<String, List<Integer>> index = book.createIndex();
        Index indexObj = new Index(index);
        indexObj.writeToFile("index.txt");
    }
}