package by.epam.benchmark;

import by.epam.benchmark.types.ListsBenchmark;
import by.epam.benchmark.types.MapsBenchmark;
import by.epam.benchmark.types.SetsBenchmark;

import java.util.Scanner;

/**
 * @author natalynka
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SetsBenchmark setsBenchmark = new SetsBenchmark();
        MapsBenchmark mapsBenchmark = new MapsBenchmark();
        ListsBenchmark listsBenchmark = new ListsBenchmark();

        System.out.println("Enter the number of elements:");

        int numberOfElements = scanner.nextInt();

        long[] template = new long[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            template[i] = (long) (Math.random()  * Long.MAX_VALUE);
        }

        setsBenchmark.runBenchmark(template);
        mapsBenchmark.runBenchmark(template);
        listsBenchmark.runBenchmark(template);
    }
}
