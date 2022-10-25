package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReaderService;
import ru.digitalhabbits.homework2.LetterCounterInline;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//todo Make your impl
public class AsyncFileLetterCounter implements FileLetterCounter {

    @Override
    public Map<Character, Integer> count(File input) throws InterruptedException {
        FileReaderService fileReaderService = new FileReaderService();
        List<String> lines = fileReaderService.readLines(input).collect(Collectors.toList());
        ExecutorService executor = Executors.newFixedThreadPool(15);

        long start = System.currentTimeMillis();

        for (String line : lines) {
            executor.submit(new LetterCounterInline(line));

        }
        executor.shutdown();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        TimeUnit.MILLISECONDS.sleep(50);
        System.out.println("-------- >>>>>>>>>>>> >>>>>>>>>>>>>>>>>>>>>>>>>" + elapsed);
        LetterCounterInline.getOutputList().forEach(System.out::println);

        Map<Character, Integer> alm = new HashMap<>();

        for (Map<Character, Integer> map : LetterCounterInline.getOutputList()) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                alm.merge(entry.getKey(), entry.getValue(), (oldValue, newValue) -> oldValue + newValue);
            }
        }

        alm.forEach((l, k) -> System.out.println(l + " =========== " + k));
        return alm;
    }
}
