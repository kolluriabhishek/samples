import java.util.ArrayList;
import java.util.List;

public class FindGroupedFarmLands {
    public static void main(String[] args) {

        int[][] s = {{1,0,0},{0,1,1},{0,1,1}};

        int[][] output = findFarmland(s);

        System.out.println(output);
    }
    public static int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;

       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(land[i][j] ==1 && (i==0 || land[i-1][j]==0) &&(j==0 || land[i][j-1]==0)){

                   int row=i;
                   int col=j;
                   while(row+1 < m && land[row+1][j]==1)
                       row= row+1;
                   while(col+1 < n && land[i][col+1]==1)
                       col= col+1;

                   list.add(new int[]{i,j,row,col});
               }
           }
       }
    int [][] res = list.toArray(new int[0][]);
       return  res;
    }
}
