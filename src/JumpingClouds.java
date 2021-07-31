import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int jumpIndex = 0;
        Integer[] cArray = c.toArray(new Integer[c.size()]);
        for (; jumpIndex < cArray.length; ) {
            int futureJumpIndex = jumpIndex + 2;
            if (futureJumpIndex < cArray.length && cArray[futureJumpIndex] == 0) {
                jumpIndex = jumpIndex + 2;
            } else
                jumpIndex++;
            if (jumpIndex < cArray.length)
                jumps++;
        }
        return jumps;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
