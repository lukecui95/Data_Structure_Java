public class OffByN implements CharacterComparator {

    private int n;

    public OffByN (int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int res = x - y ;
        if(res == n || res == -n) {return true;
        } else {
            return false;
        }
    }

}
