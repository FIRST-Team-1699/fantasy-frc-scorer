package tst;

import com.frc1699.main.Constants;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PropertiesTest {


    @Test
    public void testLoadProperties(){
        String tbaKey = Constants.getProperties().getProperty("tbakey");
        assertNotEquals("", tbaKey);
        System.out.println(tbaKey);
    }
}
