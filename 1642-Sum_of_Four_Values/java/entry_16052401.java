import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class entry_16052401 {
    public static void main(String[] args) throws Exception {
        StringBuilder output=new StringBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(stt.nextToken());
        long x=Long.parseLong(stt.nextToken());
        stt=new StringTokenizer(br.readLine());
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(stt.nextToken());
        }

        Map<Long,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long target=x-arr[i]-arr[j];
                if(map.containsKey(target)){
                    int ans[]=map.get(target);
                    output.append(i+1).append(" ")
                    .append(j+1).append(" ")
                    .append(ans[0]+1).append(" ")
                    .append(ans[1]+1);
                    break;
                }
            }
            if(output.length()>0) break;
            for(int j=0;j<i;j++){
                map.put(arr[i]+arr[j],new int[]{j,i});
            }
        }

        if(output.length()==0) output.append("IMPOSSIBLE");
        System.out.println(output);
    }
}
