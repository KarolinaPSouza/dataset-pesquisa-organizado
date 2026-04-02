import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class entry_16038189 {
    public static void main(String[] args) throws Exception {
        StringBuilder output=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int arr[]=new int[n];
        long sum=0,max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
            max=Math.max(max,sum);
            sum=Math.max(sum,0);
        }
        output.append(max);
        System.out.println(output);
    }
}