package TrendTracker;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class MainTest {
    static int k=1;
    public static void main(String[] args) {
// Setup
        ArrayList<String> R = new ArrayList<String>();
        String s, line;
//  constructor, size(), popularity(), tweeted()
        trendtracker T1 = new trendtracker("small.txt");
        test(T1.size() == 4);
        test(T1.popularity("#algorithms") == 0);
        test(T1.popularity("#cs4all") == 0);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 0);
//5
        T1.tweeted("#programming");
        test(T1.popularity("#algorithms") == 0);
        test(T1.popularity("#cs4all") == 0);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 1);
        test(T1.popularity("#CS") == 0);
//10
        T1.tweeted("#programming");
        test(T1.popularity("#algorithms") == 0);
        test(T1.popularity("#cs4all") == 0);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 2);
        test(T1.popularity("#CS") == 0);
//15
        T1.tweeted("#programming");
        test(T1.popularity("#algorithms") == 0);
        test(T1.popularity("#cs4all") == 0);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //20
        T1.tweeted("#cs4all");
        test(T1.popularity("#algorithms") == 0);
        test(T1.popularity("#cs4all") == 1);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //24
        T1.tweeted("#algorithms");
        test(T1.popularity("#algorithms") == 1);
        test(T1.popularity("#cs4all") == 1);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //29
        T1.tweeted("#cs4all");
        test(T1.popularity("#algorithms") == 1);
        test(T1.popularity("#cs4all") == 2);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //34
        T1.tweeted("#datastructures");
        test(T1.popularity("#algorithms") == 1);
        test(T1.popularity("#cs4all") == 2);
        test(T1.popularity("#datastructures") == -1);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //39
        trendtracker T2 = new trendtracker("small.txt");
        T2.tweeted("#programming");
        T2.tweeted("#programming");
        T2.tweeted("#programming");
        T2.tweeted("#programming");
        T2.tweeted("#programming");
        T2.tweeted("#CS");
        T2.tweeted("#CS");
        T2.tweeted("#CS");
        T2.tweeted("#CS");
        T2.tweeted("#cs4all");
        T2.tweeted("#cs4all");
        T2.tweeted("#cs4all");
        T2.tweeted("#algorithms");
        T2.tweeted("#algorithms");
        test(T2.popularity("#algorithms") == 2);
        test(T2.popularity("#cs4all") == 3);
        test(T2.popularity("#programming") == 5);
        test(T2.popularity("#CS") == 4);

        //43
// Enforce no usage of global variables
        test(T1.popularity("#algorithms") == 1);
        test(T1.popularity("#cs4all") == 2);
        test(T1.popularity("#programming") == 3);
        test(T1.popularity("#CS") == 0);

        //47
// Test top_trend(), top_three_trends()
        trendtracker T3 = new trendtracker("small.txt");
        T3.top_three_trends(R);
        test(R.size() == 3);
        T3.tweeted("#programming");
        test(T3.top_trend().compareTo("#programming") == 0);
        T3.top_three_trends(R);
        test(R.get(0).compareTo("#programming") == 0);
        T3.tweeted("#CS");
        T3.tweeted("#CS");
        test(T3.top_trend().compareTo("#CS") == 0);
        T3.top_three_trends(R);

        //51

//test(R.size() == 3);
        test(R.get(0).compareTo("#CS") == 0);
        test(R.get(1).compareTo("#programming") == 0);
        T3.tweeted("#algorithms");
        T3.tweeted("#algorithms");
        T3.tweeted("#algorithms");
        test(T3.top_trend().compareTo("#algorithms") == 0);
        T3.top_three_trends(R);
//test(R.size() == 3);
        //54

        test(R.get(0).compareTo("#algorithms") == 0);
        test(R.get(1).compareTo("#CS") == 0);
        test(R.get(2).compareTo("#programming") == 0);

        //57

        T3.tweeted("#cs4all");
        T3.tweeted("#cs4all");
        T3.tweeted("#cs4all");
        T3.tweeted("#cs4all");
        test(T3.top_trend().compareTo("#cs4all") == 0);
        T3.top_three_trends(R);
//test(R.size() == 3);
        test(R.get(0).compareTo("#cs4all")== 0);
        test(R.get(1).compareTo("#algorithms") == 0);
        test(R.get(2).compareTo("#CS") == 0);

        //61
// At this point:
// cs4all: 4
// algorithms: 3
// C++: 2
// programming: 1
        T3.tweeted("#programming");
        T3.tweeted("#programming");
        T3.tweeted("#programming");
        T3.tweeted("#programming");

        //65

        test(T3.top_trend().compareTo("#programming") == 0);
        T3.top_three_trends(R);
//test(R.size() == 3);
        test(R.get(0).compareTo("#programming") == 0);
        test(R.get(1).compareTo("#cs4all") == 0);
        test(R.get(2).compareTo("#algorithms")== 0);

        //69

// At this point:
// programming: 5
// cs4all: 4
// algorithms: 3
// C++: 2
        T3.tweeted("#cs4all");
        T3.tweeted("#cs4all");
        T3.tweeted("#algorithms");
        test(T3.top_trend().compareTo("#cs4all")== 0);
        T3.top_three_trends(R);
//test(R.size() == 3);
        test(R.get(0).compareTo("#cs4all") == 0);
        test(R.get(1).compareTo("#programming") == 0);
        test(R.get(2).compareTo("#algorithms")== 0);

        //73
// At this point:
// cs4all: 6
// programming: 5
// algorithms: 4
// C++: 2
        for (int i = 0; i < 10000; ++i)
            T3.tweeted("#CS");
        test(T3.top_trend().compareTo("#CS") == 0);
        T3.top_three_trends(R);
//test(R.size() == 3);
        test(R.get(0).compareTo("#CS") == 0);
        test(R.get(1).compareTo("#cs4all")== 0);
        test(R.get(2).compareTo("#programming")== 0);

        //73

        trendtracker T4 = new trendtracker("hashtags.txt");
        test(T4.size() == 300000);

        //74
        BufferedReader f;
        try {
            f = new BufferedReader(new FileReader("tweeted.txt"));
            String L = f.readLine();
            while (L!=null)
            {
                T4.tweeted(L);
                L = f.readLine();
            }
            f.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        test(T4.popularity("#programming") == 10);
        test(T4.popularity("#computer") == 9);
        test(T4.popularity("#is") == 8);
        test(T4.popularity("#very") == 7);
        test(T4.popularity("#fun") == 6);
        test(T4.popularity("#but") == 5);
        test(T4.popularity("#sometimes") == 5);
        test(T4.popularity("#can") == 5);
        test(T4.popularity("#be") == 5);
        test(T4.popularity("#challenging") == 5);
        test(T4.top_trend().compareTo("#programming") == 0);

        //85

        T4.top_three_trends(R);
        test(R.get(0).compareTo("#programming") == 0);
        test(R.get(1).compareTo("#computer")== 0);
        test(R.get(2).compareTo("#is") == 0);
// Test a Trendtracker with a single hashtag
        trendtracker T5 = new trendtracker("tiny.txt");
        test(T5.size() == 1);
        test(T5.popularity("#solo") == 0);
        test(T5.popularity("#duo") == -1);
        T5.tweeted("#solo");
        test(T5.popularity("#solo") == 1);
        test(T5.popularity("#duo") == -1);
        test(T5.top_trend().compareTo("#solo")== 0);
        T5.top_three_trends(R);
        test(R.size() == 1);
        test(R.get(0).compareTo("#solo")== 0);
        System.out.println("Assignment complete.");
    }
    public static void test(Boolean a) {
        if (a) {
            System.out.println(k+"Match!!!");
            k++;

        }
        else {
            System.out.println(k + "Fail!");
            k++;
        }
        return;
    }
}