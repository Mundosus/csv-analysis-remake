package org.example;

import java.util.*;

public class CSVProcessor {

    public static List<String> extractWords(List<String> lines) {
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Handle empty lines
            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");
            for (String word : parts) {
                // Clean up the word - remove quotes and trim whitespace
                word = word.trim().replaceAll("^\"|\"$", "");
                if (!word.isEmpty()) {
                    words.add(word.toLowerCase());
                }
            }
        }
        return words;
    }

    public static Map<String, Integer> calculateWordFrequency(List<String> words) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        return frequency;
    }

    public static Map<Integer, Integer> calculateRowLengthGroups(List<String> lines) {
        Map<Integer, Integer> rowGroups = new HashMap<>();

        for (String line : lines) {
            int length = line.split(",").length;
            rowGroups.put(length, rowGroups.getOrDefault(length, 0) + 1);
        }
        return rowGroups;
    }

    public static String findMostFrequentWord(Map<String, Integer> frequency) {
        return frequency.isEmpty() ? "No words in file" :
                Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
