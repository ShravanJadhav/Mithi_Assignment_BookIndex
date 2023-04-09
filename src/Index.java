import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Index {

    private Map<String, List<Integer>> index;

    public Index(Map<String, List<Integer>> index) {
        this.index = index;
    }

    public void writeToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            index.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        try {
                            writer.write(entry.getKey() + " : " +
                                    entry.getValue().stream()
                                            .map(Object::toString)
                                            .collect(Collectors.joining(","))
                            );
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
