import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {
    public void someMethod() {
        anotherMethod();
        System.out.println("Life goes on...");
    }

    public void anotherMethod() {
        String filepath = "exception-demo/src/UTF-8-demo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            unhappyMethod(reader);
            // unhappyMethod();
            // System.out.println("working with output from unhappyMethod");
        } catch (IOException e) {
            System.out.println("Exception handled in anotherMethod.");
            e.printStackTrace();
        } finally {
            System.out.println("leaving anotherMethod");
        }
    }

    public void unhappyMethod(BufferedReader reader) throws IOException {
        String line;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            lineCount += 1;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) > 127) {
                    throw new IOException("Non-ASCII character found at line " + lineCount);
                }
            }
        }
    }

    public static void main(String[] args) {
        ExceptionDemo et = new ExceptionDemo();
        et.someMethod();
    }
}
