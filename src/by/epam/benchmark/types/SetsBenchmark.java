package by.epam.benchmark.types;

import java.util.*;

/**
 * @author natalynka
 */
public class SetsBenchmark {

    public void runBenchmark(long[] template) {
        collectResults(new HashSet<Long>(), template);
        collectResults(new TreeSet<Long>(), template);
    }

    private long add(Set<Long> set, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            set.add(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long remove(Set<Long> set, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            set.remove(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long find(Set<Long> set, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            set.contains(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    protected void collectResults(Set<Long> set, long[] template) {
        long addTime = add(set, template);
        long findTime = find(set, template);
        long removeTime = remove(set, template);

        System.out.println(set.getClass().getSimpleName() + ":\n" +
                "Add: " + addTime + "ms\n" +
                "Find: " + findTime + "ms\n" +
                "Remove: " + removeTime + "ms\n");
    }
}
