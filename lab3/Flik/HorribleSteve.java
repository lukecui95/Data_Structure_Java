import static org.junit.Assert.*;

import org.junit.Test;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
    }

    @Test
    public void testFlik(){
        int a = 129;
        int b = 129;
        boolean ans = a == b;
        assertTrue(ans);

    }

}
