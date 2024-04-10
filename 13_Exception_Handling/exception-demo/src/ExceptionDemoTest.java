import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;



import java.io.IOException;

public class ExceptionDemoTest {

    @Test
    public void shouldThrowException()
    {
        assertThrows(IOException.class, () -> {
            ExceptionDemo et = new ExceptionDemo();
            String filepath = "exception-demo/src/UTF-8-demo.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            et.unhappyMethod(reader);
        });
    }
}
