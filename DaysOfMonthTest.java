import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class DaysOfMonthTest {
private PrintStream _saved;
}
private ByteArrayOutputStream _actual;
private ByteArrayOutputStream _expected;
private PrintStream _out;
@Before
public void before() {
        _saved = System.out;
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(
                              new BufferedOutputStream(_actual)));
        _out = new PrintStream(
                new BufferedOutputStream(_expected));
}
@After
public void after() {
        System.setOut(_saved);
}
@Test
public void wrong_month() {
        _out.println("Usage: DaysOfMonth <year> <month>");
        _out.flush();
        String arg[] = new String[] {"2012", "13"};
        DaysOfMonth.main(arg);
        System.out.flush();
        assertEquals(_expected.toString(), _actual.toString());
}
@Test
public void wrong_args() {
        _out.println("Usage: DaysOfMonth <year> <month>");
        _out.flush();
        String arg[] = new String[] {"2012"};
        DaysOfMonth.main(arg);
        System.out.flush();
        assertEquals(_expected.toString(), _actual.toString());
}
