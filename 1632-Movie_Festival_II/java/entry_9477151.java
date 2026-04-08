//package SortingAndSearching;

import java.io.*;
import java.util.*;

public class entry_9477151 {
    static int temp[][];
    static void merge(int arr[][],int start,int mid,int end)
    {
        int left = start;
        int right = mid+1;
        int idx = start;

        while(left<=mid && right<=end)
        {
            if(arr[left][1]<arr[right][1])
            {
                temp[idx++] = arr[left++];
            }
            else
            {
                temp[idx++] = arr[right++];
            }
        }

        while(left<=mid)
            temp[idx++] = arr[left++];
        while(right<=end)
            temp[idx++] = arr[right++];

        for(int i=start;i<=end;i++)
        {
            arr[i] = temp[i];
        }
    }
    static void mergerSort(int arr[][],int start,int end)
    {
//        System.out.println(start +" "+end);
        if(start>=end) return;
        int mid = (end+start)/2;
        mergerSort(arr,start,mid);
        mergerSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[][] = new int[n][2];
        temp = new int[n][2];

        for(int i=0;i<n;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
//        shuffle(arr,n);
//        Arrays.sort(arr, (a, b) ->
//                a[1]-b[1]);
//        for(int arr1[] : arr)
//            System.out.println(Arrays.toString(arr1));
        mergerSort(arr,0,n-1);

        TreeMap<Integer,Integer> pq = new TreeMap<Integer,Integer>();

        pq.put(0,1);

        int ans = 0;
        int size = 1;
        for(int i=0;i<n;i++)
        {
            Map.Entry<Integer,Integer> e = pq.floorEntry(arr[i][0]);
            if(e != null)
            {
                if(e.getValue() == 1)
                    pq.remove(e.getKey());
                else
                    pq.put(e.getKey(),e.getValue()-1);

                pq.put(arr[i][1],pq.getOrDefault(arr[i][1],0)+1);

                ans++;
            }
            else if(size<k)
            {
                pq.put(arr[i][1],pq.getOrDefault(arr[i][1],0)+1);
                ans++;
                size++;
            }
        }
        out.println(ans);
        out.close();
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}