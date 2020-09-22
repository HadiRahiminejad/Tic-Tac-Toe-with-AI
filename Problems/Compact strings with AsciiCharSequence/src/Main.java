import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {
    private  byte[] array;

    AsciiCharSequence(byte[] arr) {
        this.array = arr;
    }
    @Override
    public int length() {
        int lngh = 0;
        lngh = array.length;
        return lngh;
    }

    @Override
    public char charAt(int i) {
        char ch;
        ch = (char) array[i];
        return ch;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {


        return new AsciiCharSequence(Arrays.copyOfRange(array, i, i1));
    }

    @Override
    public String toString() {

        return new String(array);
    }
}