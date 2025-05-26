package org.example;

import java.util.Map;
import java.util.Set;

public class ResultPrinter {

    public static void printResults(WordStatistics stats,
                                    Map<String, Integer> frequency,
                                    Map<Integer, Integer> rowGroups) {

        System.out.println("Unique words: " + stats.getUniqueWordCount());
        System.out.println("Total word count: " + stats.getTotalWordCount());

        System.out.println("\nWord frequency:");
        frequency.forEach((word, count) ->
                System.out.println(" Word \"" + word + "\" count: " + count));

        System.out.println("\nGrouping by row length:");
        rowGroups.forEach((length, count) ->
                System.out.println("    Rows with " + length + " words: " + count));

        System.out.println("\nMost frequent word: \"" + stats.getMostFrequentWord() + "\"");
    }
}