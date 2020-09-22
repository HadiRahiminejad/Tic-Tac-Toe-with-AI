import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class ConcatenateStringsProblem {

    public static StringBuilder concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        String str = Arrays.toString(strings);

        StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1 = new StringBuilder();
        char found;
        char[] alpha = {'A', 'a','B', 'b','C', 'c','D', 'd','E','e','F', 'f', 'G', 'g','H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm','N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q','R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
        for (int j = 0; j < sb.length(); j++) {
        for (int i = 0; i < alpha.length; i++) {

               if (sb.charAt(j) == alpha[i]) {
                  found = sb.charAt(j);
                   sb1.append(found);
               }
           }
       }
        //System.out.println(found);
        return sb1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        StringBuilder result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}