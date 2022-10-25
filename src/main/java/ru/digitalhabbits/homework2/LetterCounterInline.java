package ru.digitalhabbits.homework2;

import com.google.common.base.CharMatcher;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.stream.Collectors.partitioningBy;

public class LetterCounterInline extends Thread implements LetterCounter {
    private String input;

    public static List<Map<Character, Integer>> getOutputList() {
        return outputList;
    }

    private final static List<Map<Character, Integer>> outputList = new CopyOnWriteArrayList<>();

    public LetterCounterInline(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        outputList.add(count(input));
    }

    @Override
    public synchronized Map<Character, Integer> count(String input) {
        Map<Character, Integer> charCount = new HashMap<>();

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);
            if (!characters.contains(ch)) {
                charCount.put(ch, CharMatcher.is(ch).countIn(input));
                characters.add(ch);
            }

        }

        characters = null;

        return charCount;

    }

}
