import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            hs.add(Integer.parseInt(s[i]));
        }
        System.out.println(hs.size());
    }
}