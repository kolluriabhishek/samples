package TrendTracker;
import java.util.*;
import java.io.*;
public class trendtracker {
    private class Entry
    {
        public String hashtag;
        int pop;
        Entry(String ht, int p){
            hashtag = ht;
            pop=p;
        }
    }
    private ArrayList<Entry> E = new ArrayList<>();
    private ArrayList<Integer> S = new ArrayList<>();

    trendtracker(String fpath){
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(fpath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 3; i++) {
            S.add(-1);
        }
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Entry en = new Entry(line,0);
            E.add(en);
        }
    }
    int size()
    {
        return E.size();
    }
    int search (String key)
    {
        int low = 0;
        int high = E.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Entry entry = E.get(mid);

            int temp = entry.hashtag.compareTo(key);
            if (temp == 0) {
                return mid;
            } else if (temp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Not found
    }
    void tweeted(String ht)
    {
        int index = search(ht);
        if(index >=0) {
            E.get(index).pop += 1;

            //update the T list with latest updated index vaues

            ArrayList<Entry> sortedEntries = new ArrayList<>(E);
            Collections.sort(sortedEntries, (a, b) -> b.pop - a.pop);

            // Update S with top three indices
            for (int i = 0; i < 3; i++) {
                if (i < sortedEntries.size()) {
                    S.set(i, E.indexOf(sortedEntries.get(i)));
                } else {
                    S.set(i, -1); // Fill remaining slots with -1
                }
            }

        }
    }
    int popularity(String ht)
    {
        int index = search(ht);
        if(index >= 0)
        return E.get(index).pop;
        else
            return -1;
    }
    String top_trend()
    {
        return E.get(S.get(0)).hashtag;
    }
    void top_three_trends(ArrayList<String> T)
    {
        int min = Math.min(3,E.size());
        if(T.size()<3)
        {
            for(int i=0;i<min;i++){
                T.add(E.get(i).hashtag);
            }
        }
            for(int i=0;i<min;i++)
            {
                if(S.get(i)>=0){
                    T.set(i,E.get(S.get(i)).hashtag);
                }
            }

    }
}
