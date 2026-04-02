
import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;
public class entry_3265734 {


    static void solve(int tc) {

        int n = fs.nInt(),x = fs.nInt();
        Pair[]val = new Pair[n];
        for(int i=0;i<n;i++){
            val[i] = new Pair(fs.nInt(),i+1);
        }
        Arrays.sort(val,Comparator.comparingInt(o -> o.f));
        Map<Long,Pair> valuesToPosision = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long toFind = x - val[i].f - val[j].f;
                if(valuesToPosision.containsKey(toFind)){
                    Pair p = valuesToPosision.get(toFind);
                    if(checK(val[i].s,val[j].s,p.f,p.s)){
                        out.println(val[i].s+" "+val[j].s+" "+p.f+" "+p.s);
                        return;
                    }
                }
            }
            for(int j=0;j<n;j++){
                if(i!=j){
                    valuesToPosision.put((long)val[i].f+val[j].f,new Pair(val[i].s,val[j].s));
                }
            }
        }
        out.println("IMPOSSIBLE");
    }
    static boolean checK(int a,int b,int c,int d){
        Set<Integer> set = new HashSet<>();
        set.add(a);set.add(b);set.add(c);set.add(d);
        return set.size() == 4;
    }
    static class PairI{
        int f,s,ind;
        PairI(int f,int s,int ind){
            this.f = f;
            this.s = s;
            this.ind = ind;
        }
    }
    static class Pair{
        int f;
        int s;
        Pair(int f,int s){
            this.f = f;
            this.s = s;
        }
    }
    static boolean multiTestCase = false;static FastScanner fs;static PrintWriter out;
    static void println(int tc,int ans){
        out.println("Case #"+tc+": "+ans);
    }
    static void println(int tc,String ans){
        out.println("Case #"+tc+": "+ans);
    }
    static void sort(int[]ar){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:ar)
            list.add(i);
        Collections.sort(list);
        for(int i=0;i<ar.length;i++){
            ar[i] = list.get(i);
        }
    }
    public static void main(String[] args) {
        try{
            fs = new FastScanner();out = new PrintWriter(System.out);
            int tc = (multiTestCase)? fs.nInt() : 1;
            int t = 1;
            while ( t <= tc ){
                solve(t);t++;
            }
            out.flush();out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String n() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String nLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        int nInt() {return Integer.parseInt(n()); }
        long nLong() {return Long.parseLong(n());}
        int[]aI(int n){
            int[]ar = new int[n];
            for(int i=0;i<n;i++)
                ar[i] = nInt();
            return ar;
        }
    }
}