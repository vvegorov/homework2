package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;
import ru.digitalhabbits.homework2.impl.AsyncFileLetterCounter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PointInCountLetter {
    private final static File file = new File("/home/lubov/homework_2-multithreading--master/src/test/resources/test.txt");

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
//        FileReaderService fileReaderService = new FileReaderService();
//        List<String> lines = fileReaderService.readLines(file).collect(Collectors.toList());
//        ExecutorService executor = Executors.newFixedThreadPool(15);
//
//        long start = System.currentTimeMillis();
//
//        for (String line : lines) {
//            executor.submit(new LetterCounterInline(line));
//
//        }
//        executor.shutdown();
//        long finish = System.currentTimeMillis();
//        long elapsed = finish - start;
//
//        TimeUnit.MILLISECONDS.sleep(50);
//        System.out.println("-------- >>>>>>>>>>>> >>>>>>>>>>>>>>>>>>>>>>>>>" + elapsed);
//        LetterCounterInline.getOutputList().forEach(System.out::println);
//
//        Map<Character, Integer> alm = new HashMap<>();
//
//        for (Map<Character, Integer> map : LetterCounterInline.getOutputList()) {
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                alm.merge(entry.getKey(), entry.getValue(), (oldValue, newValue) -> oldValue + newValue);
//            }
//        }
//
//        alm.forEach((l, k) -> System.out.println(l + " =========== " + k));

        AsyncFileLetterCounter asyncFileLetterCounter = new AsyncFileLetterCounter();
        Map<Character, Integer> count = asyncFileLetterCounter.count(file);
        count.forEach((l, k) -> System.out.println(l + " =========== " + k));


    }
}
