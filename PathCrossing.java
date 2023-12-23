import java.security.KeyPair;
import java.util.*;

//Leetcode
public class PathCrossing {
    public static void main(String[] args) {
        boolean out = pathCrossing("NNSWWEWSSESSWENNW");
        System.out.println(out) ;
    }

    public static boolean pathCrossing(String str) {

        Set<String> visited = new HashSet<>();

        int cx=0;
        int cy=0;
        visited.add(cx+" "+cy);

        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == 'N') cy++;
            if (str.charAt(i) == 'E') cx++;
            if (str.charAt(i) == 'W') cx--;
            if (str.charAt(i) == 'S') cy--;
            if (visited.contains(cx + " " + cy)) {
                return true;
            }
            visited.add(cx + " " + cy);
        }
        return false;
    }
}
