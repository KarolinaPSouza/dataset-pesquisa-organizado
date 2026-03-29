//package com.rajan.cses.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class entry_6142288 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int) 1E9 + 7;

    public static void main(String[] args) throws Exception {
        int n=Integer.parseInt(reader.readLine());
        int[][] data=new int[n][3];
        for(int i=0;i<n;i++){
            data[i]=parseInt(reader.readLine(), 3);
        }
        Arrays.sort(data, (x, y)->Integer.compare(x[0], y[0]));
        long[] dp=new long[n+1];
        for(int i=n-1;i>=0;i--){
            int j=search(data, data[i][1]);
            dp[i]=Math.max(dp[i], data[i][2]+dp[j]);
            dp[i]=Math.max(dp[i], dp[i+1]);
        }
        writer.write(dp[0]+"\n");
//        writer.write(solution(data, 0)+"\n");
        writer.flush();
    }

    private static int search(int[][] data, int end){
        int left=0, right=data.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(data[mid][0]>end && (mid==0 || data[mid-1][0]<=end)){
                return mid;
            }else if(data[mid][0]<=end){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return data.length;
    }

    private static long solution(int[][] nums, int i) {
        int n=nums.length;
        if(i>=n){
            return 0;
        }
        int j=i+1;
        while(j<n && nums[j][0]<=nums[i][1]){
            j++;
        }
        long ans=nums[i][2]+solution(nums, j);
        ans=Math.max(ans, solution(nums, i+1));
        return ans;
    }

    private static boolean canComplete(int[] k, int t, long time) {
        long total = 0L;
        for (int p : k) {
            total += time / (p * 1L);
            if (total >= t) {
                return true;
            }
        }
        return total >= t;
    }

    private static void printArray(int[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }

    private static void printArray(long[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }

    private static int[] parseInt(String str) {
        String[] parts = str.split("\\s+");
        int[] ans = new int[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(parts[i]);
        }
        return ans;
    }

    private static int[] parseInt(String str, int n) {
        int[] ans = new int[n];
        int idx = 0;
        for (int k = 0; k < str.length(); ) {
            int j = k;
            int sum = 0;
            while (j < str.length() && str.charAt(j) != ' ') {
                if (str.charAt(j) == '-') {
                    j++;
                    continue;
                }
                sum = sum * 10 + str.charAt(j) - '0';
                j++;
            }
            ans[idx++] = (str.charAt(k) == '-' ? -1 : 1) * sum;
            k = j + 1;
        }
        return ans;
    }

    private static long[] parseLong(String str) {
        String[] parts = str.split("\\s+");
        long[] ans = new long[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Long.parseLong(parts[i]);
        }
        return ans;
    }

    private static int[][] sort(int[][] data, int i, int j, Comparator<int[]> comparator) {
        if (i == j) {
            return new int[][]{data[i].clone()};
        }
        int mid = i + (j - i) / 2;
        int[][] left = sort(data, i, mid, comparator);
        int[][] right = sort(data, mid + 1, j, comparator);
        return merge(left, right, comparator);
    }

    private static int[][] merge(int[][] left, int[][] right, Comparator<int[]> comparator) {
        int n1 = left.length, n2 = right.length;
        int[][] merged = new int[n1 + n2][];
        int idx = 0, leftIdx = 0, rightIdx = 0;
        while (leftIdx < n1 && rightIdx < n2) {
            if (comparator.compare(left[leftIdx], right[rightIdx]) <= 0) {
                merged[idx++] = left[leftIdx++];
            } else {
                merged[idx++] = right[rightIdx++];
            }
        }
        while (leftIdx < n1) {
            merged[idx++] = left[leftIdx++];
        }
        while (rightIdx < n2) {
            merged[idx++] = right[rightIdx++];
        }
        return merged;
    }
}