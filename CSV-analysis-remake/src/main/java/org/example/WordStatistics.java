package org.example;

public class WordStatistics {
    private final int uniqueWordCount;
    private final int totalWordCount;
    private final String mostFrequentWord;

    public WordStatistics(int uniqueWordCount, int totalWordCount, String mostFrequentWord) {
        this.uniqueWordCount = uniqueWordCount;
        this.totalWordCount = totalWordCount;
        this.mostFrequentWord = mostFrequentWord;
    }

    public int getUniqueWordCount() { return uniqueWordCount; }
    public int getTotalWordCount() { return totalWordCount; }
    public String getMostFrequentWord() { return mostFrequentWord; }
}