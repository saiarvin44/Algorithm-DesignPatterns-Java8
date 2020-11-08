package Java8.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {
    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader br) ->
                br.readLine() + " " + br.readLine());
        System.out.println(result);
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/saibalaj/PERSONAL/java/basics/src/Java8.lambdas/data.txt"))) {
            return processor.process(br);
        }
    }
}
