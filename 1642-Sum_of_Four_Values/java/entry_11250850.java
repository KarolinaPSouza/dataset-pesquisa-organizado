//package org.example.cses_search_and_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class entry_11250850 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1[] = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int target = Integer.parseInt(line1[1]);
        String line2[] = br.readLine().split(" ");
        int[][] nums = new int[n][2];
        for(int i=0;i<n;i++)
        {
            nums[i][0] = Integer.parseInt(line2[i]);
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a,b) -> a[0] - b[0]);
        for(int i=0;i<n-1;i++)
        {
            for(int x = i+1;x<n;x++)
            {
                int newTarget = target - nums[i][0] - nums[x][0];
                int j = x + 1, k = n-1;
                while(j < k)
                {
                    if(nums[j][0] + nums[k][0] == newTarget)
                    {
                        System.out.println((nums[i][1] +1) + " "+ (nums[x][1] +1) + " " + (nums[j][1]+1) +" " + (nums[k][1]+1));
                        return;
                    }
                    else if(nums[j][0] + nums[k][0] < newTarget)
                    {
                        j++;
                    }
                    else
                    {
                        k--;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");


    }
}