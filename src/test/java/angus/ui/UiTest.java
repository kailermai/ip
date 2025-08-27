package angus.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class UiTest {
    // Solution below inspired by
    // https://www.geeksforgeeks.org/advance-java/unit-testing-of-system-out-println-with-junit/
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Ui ui = new Ui();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
    @Test
    public void testPrintGreetingsMessage() {
        ui.printGreetingsMessage();
        String expected = """
                \t____________________________________________________________
                \tHello! I'm Angus o_O
                \tWhat can I do for you today?
                \t____________________________________________________________""" + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
    }
    @Test
    public void testPrintGoodbyeMessage() {
        ui.printGoodbyeMessage();
        String expected = """
                \t____________________________________________________________
                \tGoodbye. Hope to see you again soon!
                \t____________________________________________________________""" + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
    }
}
