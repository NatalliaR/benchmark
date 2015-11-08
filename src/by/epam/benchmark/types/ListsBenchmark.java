package by.epam.benchmark.types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author natalynka
 */
public class ListsBenchmark {

    public void runBenchmark(long[] template) {
        collectResults(new ArrayList<Long>(), template);
        collectResults(new LinkedList<Long>(), template);
    }

    private long addInTheMiddle(List<Long> list, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            list.add(list.size() / 2, number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long addToTheBeginning(List<Long> list, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            list.add(0, number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long getByIndex(List<Long> list) {
        long startTime = System.currentTimeMillis();

        for (int index = 0; index < list.size(); index++) {
            list.get(index);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long addToTheEnd(List<Long> list, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            list.add(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long remove(List<Long> list, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            list.remove(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long removeLast(List<Long> list) {
        long startTime = System.currentTimeMillis();

        while (list.size() > 0) {
            list.remove(list.size() - 1);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long removeFirst(List<Long> list) {
        long startTime = System.currentTimeMillis();

        while (list.size() > 0) {
            list.remove(0);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long removeMiddle(List<Long> list) {
        long startTime = System.currentTimeMillis();

        while (list.size() > 0) {
            list.remove(list.size() / 2);
        }

        return System.currentTimeMillis() - startTime;
    }

    private long find(List<Long> list, long[] template) {
        long startTime = System.currentTimeMillis();

        for (long number : template) {
            list.contains(number);
        }

        return System.currentTimeMillis() - startTime;
    }

    private void collectResults(List<Long> list, long[] template) {
        long addTimeToTheEndTime = addToTheEnd(list, template);
        long removeFirstTime = removeFirst(list);

        long addToTheBeginningTime = addToTheBeginning(list, template);
        long removeLastTime = removeLast(list);

        long addInTheMiddleTime = addInTheMiddle(list, template);

        long getByIndexTime = getByIndex(list);
        long findTime = find(list, template);

        long removeTime = remove(list, template);

        addToTheBeginning(list, template);
        long removeMiddleTime = removeMiddle(list);

        System.out.println(list.getClass().getSimpleName() + ":\n" +
                "Add to the end:\t" + addTimeToTheEndTime + "ms\n" +
                "Add to the beginning:\t" + addToTheBeginningTime + "ms\n" +
                "Add in the middle:\t" + addInTheMiddleTime + "ms\n" +
                "Get by index:\t" + getByIndexTime + "ms\n" +
                "Find:\t" + findTime + "ms\n" +
                "Remove first:\t" + removeFirstTime + "ms\n" +
                "Remove last:\t" + removeLastTime + "ms\n" +
                "Remove middle:\t" + removeMiddleTime + "ms\n" +
                "Remove:\t" + removeTime + "ms\n");
    }
}
