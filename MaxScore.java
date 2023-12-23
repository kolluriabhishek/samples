//Leetcode
public class MaxScore {
    public static void main(String[] args) {
        int sol = maxScore("011101");
        System.out.println(sol);
    }
    public static int maxScore2(String str) {
        int result = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            int currentScore = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(j) == '0') {
                    currentScore++;
                }
            }

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    currentScore++;
                }
            }

            result = Math.max(result, currentScore);
        }

        return result;
    }
    public static int maxScore(String strrrring) {
        int maxScore =0;
        int n= strrrring.length();
        for(int i=1;i<=n-1;i++){

            //number of 0 before i
            int a = check(strrrring,i,'0');
            //numbe of 1's after i
            int b = check(strrrring,i,'1');

            if(maxScore < a+b)
                maxScore = a+b;
        }
        return maxScore;
    }

    public static int check(String s, int i,Character ch) {
        int c=0;
        int st = 0,ed=0;
        if(ch == '0')
        {
            st = 0;
            ed = i;
        }
        if(ch == '1')
        {
            st = i;
            ed = s.length();
        }
        System.out.print("---->>"+ch);
        System.out.print("======>>>"+ st);
        System.out.println("======>>>>"+ed);
        for(int j=st;j<ed;j++)
        {
            if(s.charAt(j) == ch){
                c++;
            }
        }
        return c;
    }
}
