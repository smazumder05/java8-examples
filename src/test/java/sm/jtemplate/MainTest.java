package sm.jtemplate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import sm.jtemplate.Main;

public class MainTest {
    @Test
    public void testTriple() {
        assertThat(Main.triple("AB"), equalTo("ABABAB"));
    }
}
