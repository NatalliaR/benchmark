package by.epam.benchmark.types;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author natalynka
 */
public class MapsBenchmark {

    public void runBenchmark(long[] template) {
        collectResults(new HashMap<Long, Boolean>(), template);
        collectResults(new TreeMap<Long, Boolean>(), template);
    }

    private long put(Map<Long, Boolean> map, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            map.put(number, true);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long remove(Map<Long, Boolean> map, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            map.remove(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long find(Map<Long, Boolean> map, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            map.containsKey(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private void collectResults(Map<Long, Boolean> map, long[] template) {
        long addTime = put(map, template);
        long findTime = find(map, template);
        long removeTime = remove(map, template);

        System.out.println(map.getClass().getSimpleName() + ":\n" +
                "Add: " + addTime + "ms\n" +
                "Find: " + findTime + "ms\n" +
                "Remove: " + removeTime + "ms\n");
    }
}
