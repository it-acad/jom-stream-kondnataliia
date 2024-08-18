package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {

        if (map == null) {
            throw new NullPointerException("Map cannot be null");
        }

        return map.values().stream()
                .flatMap(stream -> stream)
                .filter(Objects::nonNull)
                .map(s -> s.replace(" ", ""))
                .filter(s -> !s.isEmpty())
                .map(String::toLowerCase)
                .distinct()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted();
    }

}
