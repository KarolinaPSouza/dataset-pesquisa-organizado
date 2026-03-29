import java.util.Scanner;
public class entry_13714479 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] price=new int[n];
        int[] pages=new int[n];
        for(int i=0;i<n;i++) {
            price[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++) {
            pages[i]=sc.nextInt();
        }
        int[] dp=new int[x + 1];
        for (int i=0;i<n;i++) {
            for (int j=x;j>=price[i];j--) {
                dp[j] = Math.max(dp[j], dp[j - price[i]] + pages[i]);
            }
        }
        System.out.println(dp[x]);
        sc.close();
    }
}