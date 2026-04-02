import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_12558294 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] input=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            input[i]=Integer.parseInt(st.nextToken());
        }

        long max=input[0];
        long current=0;

        for(int i=0;i<input.length;i++)
        {
            current+=input[i];
            if(current>max)
            {
                max=current;
            }
            else if(current<0)
            {
                current=0;
            }
        }

        System.out.println(max);
        br.close();
    }
}