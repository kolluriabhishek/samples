import java.util.ArrayList;
import java.util.Scanner;

public class KillNextPerson {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> people = new ArrayList<Integer>();

        for(int i=1;i<=n;i++){
            people.add(i);
        }
        boolean fg = false;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while(people.size()!=1)
        {
            int l = people.size();
            if(l%2==1){
                temp.add(people.get(l-1));
            }


        }



//        while(people.size()!=1){
//            if(fg==1){
//                System.out.println(people.get(j));
//                people.remove(j);
//                Thread.sleep(100);
//                fg=0;
//                j++;
//                if(j> people.size()) j=j% people.size();
//                continue;
//            }
//            if(fg==0)
//            {
//                fg=1;
//                j++;
//                if(j> people.size()) j=j% people.size();
//            }
//        }
        System.out.println("================");
        System.out.println(people);
    }
}
