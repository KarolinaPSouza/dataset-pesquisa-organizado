import java.io.*;
import java.util.*;
public class entry_16044648 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }
    String next() { 
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
        tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
        return tokenizer.nextToken();
    }
    public int nextInt() { 
        return Integer.parseInt(next());
    }
    public long nextLong() { 
        return Long.parseLong(next());
    }
    public double nextDouble() { 
        return Double.parseDouble(next());
    }
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        int n = r.nextInt();
        int x = r.nextInt();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = r.nextInt();
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        boolean isFound = false;
        int idx1 = -1;
        int idx2 = -1;
        for(int i =0;i<n;i++){
            int idx = Arrays.binarySearch(copy,x-arr[i]);
            if(idx>=0){
                if(arr[i]==x-arr[i]&&hm.get(arr[i])<2) continue;
                isFound = true;
                idx1 = arr[i];
                idx2 = x - arr[i]; 
                break;
            }
        }
        if(isFound){
            for(int i = 0;i<n;i++){
                if(arr[i]==idx1){
                    pw.print((i+1)+" ");
                    break;
                }
            }
            for(int i = n-1;i>=0;i--){
                if(arr[i]==idx2){
                    pw.print((i+1));
                    break;
                }
            }
        }else
            pw.println("IMPOSSIBLE");
        pw.close(); 
    }
}