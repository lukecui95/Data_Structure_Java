public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int res = x - y ;
        if(res == -1 || res == 1) {return true;
        } else {
            return false;
        }
    }

}
