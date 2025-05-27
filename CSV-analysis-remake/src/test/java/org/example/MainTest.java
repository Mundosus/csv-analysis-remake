package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class MainTest {

    private static final String TEST_FILE_PATH = "test_dataset.csv";

    public static void main(String[] args) {
        try {
            testCSVProcessing();
            System.out.println("All tests passed!");
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        }
    }

    public static void testCSVProcessing() throws Exception {
        // Read file directly (same as original test)
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE_PATH));
        if (lines.isEmpty()) {
            throw new RuntimeException("Test file should not be empty");
        }

        // Process data using the original logic from your test
        List<String> allWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();
        Map<Integer, Integer> rowLengthMap = new HashMap<>();

        for (String line : lines) {
            String[] words = line.split(",");
            int count = words.length;
            for (String word : words) {
                if (!word.isBlank()) {
                    word = word.toLowerCase();
                    allWords.add(word);
                    uniqueWords.add(word);
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            rowLengthMap.put(count, rowLengthMap.getOrDefault(count, 0) + 1);
        }

        String mostFrequentWord = wordCount.isEmpty() ? "No words in file" :
                Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Print test results
        System.out.println("\nTest unique words: " + uniqueWords.size());
        System.out.println("Test total word count: " + allWords.size());

        System.out.println("\nTest word frequency:");
        wordCount.forEach((word, count) ->
                System.out.println("Word \"" + word + "\" count: " + count));

        System.out.println("\nTest grouping by row length:");
        rowLengthMap.forEach((length, count) ->
                System.out.println(" Rows with " + length + " words: " + count));

        System.out.println("\nMost frequent word in test file: \"" + mostFrequentWord + "\"");

        // Manual assertions (replacing JUnit assertions)
        if (lines.size() != rowLengthMap.values().stream().mapToInt(i -> i).sum()) {
            throw new RuntimeException("Line count should match");
        }
        if (uniqueWords.size() != new HashSet<>(allWords).size()) {
            throw new RuntimeException("Unique words count should match");
        }
        if (allWords.size() != wordCount.values().stream().mapToInt(i -> i).sum()) {
            throw new RuntimeException("Word count should match");
        }
        if (mostFrequentWord.isBlank()) {
            throw new RuntimeException("Most frequent word should not be empty");
        }
    }
}