// import java.util.Scanner;
import java.util.*;
import java.io.*;


public class entry_15542295 {

    public static void main(String args[]) throws Exception
    {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] first= br.readLine().split(" ");

        int n=Integer.parseInt(first[0]);
        long x = Integer.parseInt(first[1]);

        String[] second_line=br.readLine().split(" ");
        long[] arr=new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i]= Long.parseLong(second_line[i]);
        }

        HashMap <Long,Integer> mappy = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            // long val = arr[i];
            long vl_needed = x - arr[i];

            if(mappy.containsKey(vl_needed))
            {

                System.out.println((mappy.get(vl_needed)+1) + " " + (i+1));
                return;
            }

            mappy.put(arr[i],i);


        }


        System.out.println("IMPOSSIBLE");


        // sc.close();
    }
} 