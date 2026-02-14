package main.java.com.airtribe.meditrack.util;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {

    private static Map<String, Integer> counters = new HashMap<>();

    public static synchronized long generateId(String prefix) {

        int next = counters.getOrDefault(prefix, 0) + 1;

        counters.put(prefix, next);

        return  next;
    }
}
