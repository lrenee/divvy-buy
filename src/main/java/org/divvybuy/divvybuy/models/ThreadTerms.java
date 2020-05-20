package org.divvybuy.divvybuy.models;

import java.util.ArrayList;

public class ThreadTerms {

    public static ArrayList<Thread> findByTerm(String term, Iterable<Thread> allThreads) {

        ArrayList<Thread> results = new ArrayList<>();

        for (Thread threadName : allThreads) {

            if (threadName.getThreadName().toLowerCase().contains(term.toLowerCase())) {
                results.add(threadName);
            } else if (threadName.getThreadDetails().getThreadMessage().toString().toLowerCase().contains(term.toLowerCase())) {
                results.add(threadName);
            } else if (threadName.getTopic().toString().toLowerCase().contains(term.toLowerCase())) {
                results.add(threadName);
            } else if (threadName.toString().toLowerCase().contains(term.toLowerCase())) {
                results.add(threadName);
            }

        }

        return results;

    }

}
