package jom.com.softserve.s6.task6;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Map<String, Set<String>> phones = new HashMap<>();

        for (Stream<String> stream : list) {
            if (stream != null) {
                stream.filter(Objects::nonNull)
                        .map(phone -> phone.replaceAll("[\\s\\-\\(\\)]", ""))
                        .filter(phone -> !phone.isEmpty())
                        .forEach(phone -> {
                            if (phone.length() < 5) {
                                phones.computeIfAbsent("err", s -> new HashSet<>()).add(phone);
                            } else if (phone.length() == 7) {
                                phones.computeIfAbsent("loc", s -> new HashSet<>()).add(phone);
                            } else if (phone.length() == 10) {
                                phones.computeIfAbsent(phone.length() == 10 ? phone.substring(0, 3) : phone.substring(1, 4),
                                        s -> new HashSet<>()).add(phone.length() == 10 ? phone.substring(3) : phone.substring(4));
                            } else {
                                phones.computeIfAbsent("err", k -> new HashSet<>()).add(phone);
                            }
                        });
            }
        }

        return phones.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().sorted()));
    }
}