import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelWordCounter {
    public static void main(String[] args) throws Exception {
        // Hardcoded file path and word to count
        String filePath = "D:\\java\\multithreading\\java.txt";
        String wordToCount = "Java";

        Path file = Paths.get(filePath);
        ExecutorService executor = Executors.newFixedThreadPool(1); // Using 1 thread for simplicity

        long startTime = System.currentTimeMillis();

        Callable<WordCountResult> task = new WordCountTask(file, wordToCount);
        Future<WordCountResult> future = executor.submit(task);

        WordCountResult result = future.get();
        System.out.println(result);

        long endTime = System.currentTimeMillis();

        System.out.println("Total occurrences of '" + wordToCount + "': " + result.getCount());
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        executor.shutdown();
    }
}

class WordCountTask implements Callable<WordCountResult> {
    private final Path file;
    private final String wordToCount;

    public WordCountTask(Path file, String wordToCount) {
        this.file = file;
        this.wordToCount = wordToCount.toLowerCase();
    }

    @Override
    public WordCountResult call() throws Exception {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countWordInLine(line);
            }
        }
        return new WordCountResult(file.getFileName().toString(), count);
    }

    private int countWordInLine(String line) {
        return (int) Arrays.stream(line.toLowerCase().split("\\W+"))
                           .filter(word -> word.equals(wordToCount))
                           .count();
    }
}

class WordCountResult {
    private final String fileName;
    private final int count;

    public WordCountResult(String fileName, int count) {
        this.fileName = fileName;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "File: " + fileName + ", Word count: " + count;
    }
}