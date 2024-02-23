public class SubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {

        System.out.println(maxLengthBetweenEqualCharacters("the"));
    }

    public static String maxLengthBetweenEqualCharacters(String str) {

        int n=str.length();
        String s = "";

        for(int i=0;i<n;i++)
        {
            s=s+str.charAt(i);
            s=s+str.charAt(i);

        }

        return s;
    }
}
