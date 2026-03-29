import java.util.*;

public class entry_7163194 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] dist = new long[n+1];
        long[] relax = new long[n+1];
        ArrayList<Tuple> edge = new ArrayList<>();

        for (int i=0; i<m; i++){
            Tuple temp = new Tuple();
            temp.one = sc.nextLong();
            temp.two = sc.nextLong();
            temp.three = sc.nextLong();
            edge.add(temp);
        }
        sc.close();

        for (int i=1; i<=n; i++){
            relax[i] = -1;
        }
        runBellmanFord(n, edge, dist, relax);

    }

    private static void runBellmanFord(int n, ArrayList<Tuple> edge, long[] dist, long[] relax){
        int x = -1;
        for (int i=1; i<=n; i++){
            x = -1;
            for (Tuple temp: edge){
                long one = temp.one;
                long two = temp.two;
                long distance = temp.three;
                if(dist[(int) one] + distance < dist[(int) two]){
                    dist[(int) two] = distance + dist[(int) one];
                    relax[(int) two] = one;
                    x = (int) two;
                }
            } 
        }
        if(x==-1){
            System.out.print("NO");
        } else{
            for (int i=1; i<=n; i++){
                //System.out.println(x);
                x = (int) relax[x];
            }

            ArrayList<Long> foundCycle = new ArrayList<>();

            //long count = x;
            //while(true){
            for (long count = x; ; count = relax[ (int) count]){
                //System.out.println(count);
                //count = relax[(int) count-1];
                foundCycle.add(count);
                //count++;
                if(count==x && foundCycle.size()>1){
                    break;
                }
            }

            System.out.println("YES");
            for (int i=foundCycle.size()-1; i>=0; i--){
                System.out.print(foundCycle.get(i)+" ");
            }
        }

    }
}


class Tuple {
    public long one;
    public long two;
    public long three;
}