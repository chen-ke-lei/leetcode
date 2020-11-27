package oj.hot200;

public class Q604 {
}

class StringIterator {
    String compressedString;
    int index;
    int num;
    char c;

    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
        index = -1;
        num = 0;
    }

    public char next() {
        if (!hasNext()) return ' ';
        num--;
        return c;
    }

    public boolean hasNext() {
        if (num == 0) {
            index++;
            if(index>=compressedString.length() - 1) return false;
            c = compressedString.charAt(index);
            while (index < compressedString.length() - 1) {
                if (compressedString.charAt(index + 1) >= '0' && compressedString.charAt(index + 1) <= '9') {
                    num = num * 10 + compressedString.charAt(++index) - '0';
                } else {
                    break;
                }
            }
        }
        return index < compressedString.length() - 1 || num != 0;
    }
}
