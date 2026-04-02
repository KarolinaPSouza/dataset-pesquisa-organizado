/**
 * Author: Balu
 * Created: Mon Oct 06 16:31:30 IST 2025
**/

import java.util.*;
import java.io.*;

public class entry_14817220 {
    static long mod = (int) 1e9 + 7;

    public static long pow(long a, long b) {
        long re = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                re = (re * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return re;
    }

    public static void revArr(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),60000);
        PrintWriter pw = new PrintWriter(System.out);
        int tt = 1;
        while (tt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Integer.parseInt(st.nextToken());
            int a[][] = new int[n][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i][0] = Integer.parseInt(st.nextToken());
                a[i][1] = i;
            }
            // sort(a);
            Arrays.sort(a, (b, c) -> {
                return b[0] - c[0];
            });

            boolean found = false;

            for (int i = 0; i < n - 3 && !found; i++) {
                if(4*a[i][0] > x ) continue; 
                for (int j = i + 1; j < n - 2 && !found; j++) {
                    int k = j + 1;
                    int l = n - 1;
                    if(2*(a[i][0] + a[j][0]) > x) continue;
                    while (k < l) {
                        if (a[j][0] + a[k][0] == x - a[i][0] - a[l][0]) {
                            found = true;
                            pw.println((a[i][1] + 1) + " " + (a[j][1] + 1) + " " + (a[k][1] + 1) + " "  + (a[l][1] + 1));
                            break;
                        }
                        if (a[j][0] + a[k][0] > x - a[i][0] - a[l][0]) {
                            l--;
                        } else
                            k++;

                    }
                }

            }
            if (!found) {
                pw.println("IMPOSSIBLE");
            }

        }
        pw.flush();
    }
}