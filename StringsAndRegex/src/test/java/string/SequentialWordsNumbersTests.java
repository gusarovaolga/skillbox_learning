package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static practice.string.SequentialWordsNumbers.sequentialWordsNumbers;

@DisplayName("Вывод текста с порядковыми номера слов")
class SequentialWordsNumbersTests {

    private static Stream<Arguments> strings() {
        return Stream.of(
                Arguments.of("", sequentialWordsNumbers("")),
                Arguments.of("(1) слово", sequentialWordsNumbers("слово")),
                Arguments.of("(1) два (2) слова", sequentialWordsNumbers("(1) два (2) слова")),
                Arguments.of("(1) Hello (2) world!", sequentialWordsNumbers("(1) Hello (2) world!")),
                Arguments.of("(1) Это (2) просто (3) текст, (4) для (5) примера (5) работы (6) программы",
                        sequentialWordsNumbers("(1) Это (2) просто (3) текст, (4) для (5) примера (5) работы (6) программы"))
        );
    }


    @ParameterizedTest
    @MethodSource("strings")
    @DisplayName("Порядковый номер слов в строке")
    void sequentialWordsNumbersTest(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка используются ли методы регулярных выражений")
    void checkRegularExpression() {
        final List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("src", "main", "java", "practice", "string", "SequentialWordsNumbers.java");
            lines.addAll(Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, String> errLines = lines.stream()
                .filter(line -> line.matches(".*(split|matches|Pattern|Matcher).*"))
                .collect(Collectors.toMap(lines::indexOf, s -> s));

        String message = errLines.entrySet().stream()
                .map(entry -> "Строка " + entry.getKey() + " - <" + entry.getValue() + ">")
                .collect(Collectors.joining("\n"));

        assertTrue(errLines.isEmpty(),
                "\nВы использовали методы для регулярных выражений в строках\n" + message);
    }

}