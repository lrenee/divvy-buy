package org.divvybuy.divvybuy.data;

import org.divvybuy.divvybuy.models.Thread;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ThreadData {

    private static final Map<Integer, Thread> threads = new HashMap<>();

    public static Collection<Thread> getAll() {

        return threads.values();
    }

    public static Thread getById(Integer id) {

        return threads.get(id);
    }

    public static void add(Thread thread) {
        threads.put(thread.getId(), thread);
    }

    public static void remove(Integer id) {
        if(threads.containsKey(id)) {
            threads.remove(id);
        }
    }



}
