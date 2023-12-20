//An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by 
//rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
 //If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother)

//  Input: img = [[100,200,100],[200,50,200],[100,200,100]]
// Output: [[137,141,137],[141,138,141],[137,141,137]]
// Explanation:
// For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
// For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
// For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138


class Filter {
    public static void main(String args[])
    {

        int img[][] = {{100,200,100},{200,50,200},{100,200,100}};
        int res[][] = imageSmoother(img);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(res[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static int[][] imageSmoother(int[][] img) {
            int r = img.length;
            int c = img[0].length;
            int out[][] = new int[r][c];

            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    out[i][j] = filter_cube(img,i,j);
                }
            }
            return out;
    }

    // this function return the avg value of surrounding cells
    static int filter_cube(int[][] img ,int x,int y)
    {
        int m = img.length; 
        int n = img[0].length;
        int sum = 0;
        int c = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int ar = x+i;
                int ac = y+j;

                if(ar<0 || ac<0 || ar >=m || ac>=n)
                    continue;

                sum = sum + img[ar][ac];
                c++;
            }
        }
        return sum/c;
    }
}
