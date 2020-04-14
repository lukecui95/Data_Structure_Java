public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque res = new LinkedListDeque();

        for (int i = 0; i<word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        Deque res = wordToDeque(word);

        while (res.size()>1){
            if (res.removeFirst()!= res.removeLast()) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {


        int left = 0;
        int right = word.length()-1;

        while(left<right) {
            if (!cc.equalChars(word.charAt(left),word.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
