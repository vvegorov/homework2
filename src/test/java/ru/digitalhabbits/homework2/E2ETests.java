package ru.digitalhabbits.homework2;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import ru.digitalhabbits.homework2.impl.AsyncFileLetterCounter;

public class E2ETests {

    @Test
    void async_file_letter_counting_should_return_predicted_count() throws InterruptedException {
        File file = getFile("test.txt");
        AsyncFileLetterCounter counter = new AsyncFileLetterCounter();

        Map<Character, Integer> count = counter.count(file);

        assertThat(count).containsOnly(
                entry('a', 2697),
                entry('b', 2683),
                entry('c', 2647),
                entry('d', 2613),
                entry('e', 2731),
                entry('f', 2629)
        );
    }

    private File getFile(String name) {
        return new File(getResource(name).getPath());
    }
}
