import java.util.*;

class cses {
    public static final int mod = 1000000007;
    static int[] costs;
    static int[] pages;
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = sc.nextInt();
        pages = new int[n];
        costs = new int[n];

        for(int i = 0; i < n; i++){
            costs[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            pages[i] = sc.nextInt();
        }

        int[] prev = new int[x+1];
        for(int i=0 ; i<n ; i++){
            int[] curr = new int[x+1];

            for(int j=0 ; j<=x ; j++){  
                int include = 0;
                if(j - costs[i] >= 0){
                    include = prev[j-costs[i]] + pages[i];
                }
                int exclude = prev[j];

                curr[j] = Math.max(include, exclude);
            }
            prev = curr;
        }

        System.out.println(prev[x]);  
    }
}