




import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Task{
 int duration , deadline;
 Task(int duration , int deadline){
  this.duration = duration;
  this.deadline = deadline;
 }
}
class Pair implements Comparable<Pair>{
 long first;
 int second ;
 Pair(long first, int second){
  this.first = first;
  this.second = second;
 }
 public int compareTo(Pair other) {
        return Long.compare(this.first, other.first);
    }

}
public class entry_14648640 {
 static int MOD = (int)Math.pow(10, 9) + 7;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        Pair arr[] = new Pair[n];
        for(int i = 0 ; i <n ; i++) {
         long el = sc.nextLong();
         arr[i]  = new Pair(el , i + 1);
        }
        Arrays.sort(arr,Comparator.comparingLong(p -> p.first));
        for(int i = 0; i < n - 3 ; i++) {
         for(int j = i + 1; j < n - 2 ; j++) {
          int p = j + 1;
          int l = n - 1;
          while(p < l) {
           long sum = arr[i].first + arr[j].first + arr[p].first + arr[l].first;
           if(sum == k) {
            System.out.print(arr[i].second + " " + arr[j].second + " " + arr[p].second + " " + arr[l].second );
            return;
           }
           else if(sum > k) {
            l--;
           }
           else {
            p++;
           }
          }
          }
        }
        System.out.println("IMPOSSIBLE");

    }
    private static boolean isValid(long [] arr , long mid , int k ) {
     int partitions = 1;
     long sum = 0;
     for(int i = 0 ; i < arr.length ; i++) {
      sum += arr[i];
      if(sum > mid){
       partitions++;
       sum = arr[i];
      }
     }
     return partitions <= k;
    }
    private static boolean helperBinarySearch(int []arr , long mid , int k) {
     long sum =0;
     for(int i = 0 ; i < arr.length; i++) {
      sum+=(mid / arr[i]);
      if(sum >= k) {
       return true;
      }
     }
     return false;
    }
    public static long helper(int[] arr , int i,  int n) {
     if(i ==  n) {
      return 1;
     }
        long left = helper(arr, i + 1, n);
        long right = helper(arr, i + 1, n);
        return (left + right) % MOD;
    }

    private static int helperBs(List<Integer> list , int element) {
     int low = 0;
     int high = list.size() - 1;
     while(low <= high) {
      int mid = (low +high)/ 2;
      if(list.get(mid) > element) {
       high = mid - 1;
      }
      else {
       low = mid + 1;
      }
     }
     return low;
    }
    private static void swap(long []arr , int a , int b) {
     long temp = arr[a];
     arr[a]  = arr[b];
     arr[b]  = temp;
    }

    private static void helperFerris(List<Integer> list , int no , int maxW) {
     int l =0;
     int h = list.size() - 1;
     int count= 0;
     Collections.sort(list);
     while(h >= l) {
      if(list.get(l) + list.get(h) <= maxW) {
       count+=1;
       h--;
       l++;
      }
      else {
       count++;
       h--;
      }
     }
     System.out.println(count);
    }
    private static void helper(List<Integer> ticketPrices , List<Integer> custPrices) {
     int count =0;
     Collections.sort(ticketPrices);
     ArrayList<Integer>ans = new ArrayList<>();
     for(int i = 0 ; i < custPrices.size() ; i++) {
      ans.add(0);
     }
     for(int i = 0 ; i < custPrices.size() ; i++) {
      int highPrice = findMaxBound(ticketPrices , custPrices.get(i));
      if(highPrice == 0) {
       ans.set(i , -1);
      }
      else {
       highPrice--;
       ans.set(i , ticketPrices.get(highPrice));
       ticketPrices.remove(highPrice);
      }
     }
     for(int i = 0 ;i < ans.size() ; i++) {
      System.out.println(ans.get(i));
     }

    }
    private static int findMaxBound(List<Integer> ticketPrices, int n) {
     int low = 0;
     int ans = ticketPrices.size();
     int high = ticketPrices.size() -1;
     while(low <= high) {
      int mid = (low + high)/2;
      if(ticketPrices.get(mid) > n) {
       ans = mid;
       high= mid - 1;
      }
      else {
       low = mid + 1;
      }
     }
     return ans;
    }

 }