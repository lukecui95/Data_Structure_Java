import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("Aca"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("AccA"));
        assertTrue(palindrome.isPalindrome("zbcbz"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(""));

    }

    OffByOne obo = new OffByOne();
  
    @Test
    public void testisPalindromeOne() {

        assertFalse(palindrome.isPalindrome("aca",obo));
        assertFalse(palindrome.isPalindrome("df",obo));
        assertFalse(palindrome.isPalindrome("zz",obo));
        assertTrue(palindrome.isPalindrome("a" ,obo));
        assertTrue(palindrome.isPalindrome("aab" ,obo));
        assertTrue(palindrome.isPalindrome("flake" ,obo));
        assertTrue(palindrome.isPalindrome("" ,obo));


    }

    OffByN obn = new OffByN(5);
    @Test
    public void testisPalindromeN() {

        assertFalse(palindrome.isPalindrome("aca",obn));
        assertFalse(palindrome.isPalindrome("fh",obn));
        assertFalse(palindrome.isPalindrome("zz",obn));
        assertTrue(palindrome.isPalindrome("a" ,obn));
        assertTrue(palindrome.isPalindrome("aaf" ,obn));
        assertTrue(palindrome.isPalindrome("fa" ,obn));
        assertTrue(palindrome.isPalindrome("" ,obn));

    }

}     //Uncomment this class once you've created your Palindrome class.