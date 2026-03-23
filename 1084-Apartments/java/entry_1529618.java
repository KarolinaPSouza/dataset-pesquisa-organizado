import java.util.*;
import java.io.*;

public class entry_1529618 {
    static BufferedReader r = new BufferedReader(new InputStreamReader (System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException{
        // Reads in first line (variables)
        StringTokenizer st1 = new StringTokenizer(r.readLine());
        // Initializes static variables
        int numApps = Integer.parseInt(st1.nextToken());
        int numAparts = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int count=0;

        // Reads in second line (applicants) and sorts highest to lowest
        StringTokenizer st2 = new StringTokenizer(r.readLine());
        PriorityQueue<Integer> applicants = new PriorityQueue<Integer>();
        for(int i=0; i<numApps; i++) {
            applicants.add(Integer.parseInt(st2.nextToken()));
        }

        StringTokenizer st3 = new StringTokenizer(r.readLine());
        PriorityQueue<Integer> apartments = new PriorityQueue<Integer>();
        for(int j=0; j<numAparts; j++) {
            apartments.add(Integer.parseInt(st3.nextToken()));
        }

        while(apartments.size()>0 && applicants.size()>0) {
            if(apartments.peek()<=applicants.peek()+k && apartments.peek()>=applicants.peek()-k) {
                count++;
                apartments.poll();
                applicants.poll();
            }
            else if(apartments.peek()>applicants.peek()+k){
                applicants.poll();
            }
            else {
                apartments.poll();
            }
        }
        pw.println(count);
        pw.close();
        r.close();
    }
}