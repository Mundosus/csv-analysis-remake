package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String filePath = "word_dataset.csv";

        // Read file
        List<String> lines = FileReader.readFile(filePath);
        if (lines == null) return;

        // Process CSV data
        List<String> words = CSVProcessor.extractWords(lines);
        Set<String> uniqueWords = new HashSet<>(words);
        Map<String, Integer> frequency = CSVProcessor.calculateWordFrequency(words);
        Map<Integer, Integer> rowGroups = CSVProcessor.calculateRowLengthGroups(lines);

        // Create statistics object
        String mostFrequentWord = CSVProcessor.findMostFrequentWord(frequency);
        WordStatistics stats = new WordStatistics(
                uniqueWords.size(),
                words.size(),
                mostFrequentWord
        );

        // Print results
        ResultPrinter.printResults(stats, frequency, rowGroups);
    }
}