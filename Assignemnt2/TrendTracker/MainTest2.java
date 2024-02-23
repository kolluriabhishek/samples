package TrendTracker;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class MainTest2 {
    static int k=1;
    public static void main(String[] args){
// Setup
        ArrayList<String> R = new ArrayList<String>();
        String s, line;

        trendtracker T4 = new trendtracker("hashtags.txt");
        test(T4.size() == 300000);
        BufferedReader f;
        try {
            f = new BufferedReader(new FileReader("tweeted.txt"));
            String L = f.readLine();
            long count =0;
            while (L!=null)
            {
                count++;
                System.out.println(count);
                T4.tweeted(L);
                L = f.readLine();
            }
            f.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        test(T4.popularity("#programming") == 10);
    }
    public static void test(Boolean a) {
        if (a) {
System.out.println(k+"Match!!!");
k++;
        }
        else
        {
            System.out.println(k+"Fail!");
            k++;
        }
        return;
    }
}