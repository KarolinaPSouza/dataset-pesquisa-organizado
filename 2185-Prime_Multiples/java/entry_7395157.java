import java.util.*;
import java.io.*;
public class entry_7395157 {
    static long[] diffVals;
    static int k;
    static long[] primeNums;
    static long n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        primeNums = new long[k];
        diffVals = new long[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            primeNums[i] = Long.parseLong(st.nextToken());
        }
        DFS("0", 0, n);
        DFS("0", 0, n);
        long finNum = 0;
        for (int i = 1; i <= diffVals.length; i++) {
            if (i % 2 == 0) {
                finNum -= diffVals[i - 1];
            }
            else {
                finNum += diffVals[i - 1];
            }
        }
        System.out.println(finNum/2);
        /*for (long val : diffVals) {
            System.out.println(val);
        }*/
        br.close();
    }

    public static void DFS(String cur, int oneCount, long curNum) {
        if (cur.length() == k + 1) {
            if (oneCount != 0 && curNum > 0 && curNum <= n) {
                diffVals[oneCount - 1] += curNum;
            }
            return;
        }
        DFS(cur + '0', oneCount, curNum);
        /*if (curNum * primeNums[cur.length()] < 0) {
            System.out.println(curNum + " " + primeNums[cur.length()]);
            return;
        }*/
        curNum /=primeNums[cur.length() - 1];
        //System.out.println(curNum + " " + primeNums[cur.length()]);
        DFS(cur + '1', oneCount + 1, curNum);
    }
}