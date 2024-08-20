package jom.com.softserve.s6.task7;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        //Set<Integer> uniqueValues = new HashSet<>();
        return stream.filter(Objects::nonNull)
                     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                     .entrySet().stream()
                                .filter(entry -> entry.getValue() > 1)
                                .map(Map.Entry::getKey)
                                .sorted();
    }
}
