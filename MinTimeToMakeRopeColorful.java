public class MinTimeToMakeRopeColorful {

    public static void main(String[] args) {
        int k;
        int arr[] = {1,2,3,4,5};
        k= minCost("abaac",arr);
        System.out.println(k);
    }
    public static int minCost(String colors, int[] neededTime) {

        int res = 0;
        int n = colors.length();
        int j=0;
        for(int i=1;i<n;i++)
        {
            if(colors.charAt(i-1) != colors.charAt(i) && j-i >1){
                int temp = findMinCost(colors,neededTime,i,j);
                res += temp;
                j=i;
            }

        }

        return res;
    }

    private static int findMinCost(String colors, int[] neededTime, int i, int j) {

        int out=9999;

        for(int x=j;x<=i;x++){
            if(out > neededTime[x]){
                out = neededTime[x];
            }
        }
        return out;
    }

}
