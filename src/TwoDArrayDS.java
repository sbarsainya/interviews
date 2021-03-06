import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        Integer[][] arrArray = arr.stream().map(integers ->
                integers.toArray(new Integer[0])).toArray(Integer[][]::new);
        List<Integer> sum = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                sum.add(arrArray[i - 1][j - 1] + arrArray[i - 1][j] + arrArray[i - 1][j + 1]
                        +   arrArray[i][j] +
                        + arrArray[i + 1][j - 1] + arrArray[i + 1][j] + arrArray[i + 1][j + 1]);

            }
        }
        return Collections.max(sum);
    }

}

public class TwoDArrayDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
