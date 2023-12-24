//Leetcode
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlternatingBinaryString {

    public static void main(String[] args) {
        System.out.println(minOperations("1111"));
    }

    public static int minOperations(String s) {
        char setChar1 = '0';
        char setChar2 = '1';
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if(setChar1 != s.charAt(i)){
                c1++;
            }
            if(setChar2 != s.charAt(i)){
                c2++;
            }
            //flip
            char temp = setChar1;
            setChar1 = setChar2;
            setChar2 = temp;
        }
        return Math.min(c1,c2);
    }
}
