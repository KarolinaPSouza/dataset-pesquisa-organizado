import java.util.*;
 
public class entry_2331433{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);	
		int N = in.nextInt(), K = in.nextInt();
 
		int N1 = N/2, N2 = N - N1;
 
		int[] t1 = new int[N1], t2 = new int[N2];
		long[] arr1 = new long[1 << N1], arr2 = new long[1 << N2];
 
		for(int i = 0; i < N1; i++)
			t1[i] = in.nextInt();
		for(int i = 0; i < N2; i++)
			t2[i] = in.nextInt();
 
		for(int mask = 1; mask < (1 << N1); mask++){
			int hpos = 31 - Integer.numberOfLeadingZeros(mask), hnum = 1 << hpos;
			arr1[mask] += arr1[mask ^ hnum] + t1[hpos];
		}
		for(int mask = 1; mask < (1 << N2); mask++){
			int hpos = 31 - Integer.numberOfLeadingZeros(mask), hnum = 1 << hpos;
			arr2[mask] += arr2[mask ^ hnum] + t2[hpos];
		}
 
		Arrays.sort(arr1);
		Arrays.sort(arr2);
 
		int first = (1 << N2) - 1, last = first;
		long ans = 0;
		for(int i = 0; i < (1 << N1); i++){
			while(last >= 0 && arr1[i] + arr2[last] > K)
				--last;
			while(first - 1 >= 0 && arr1[i] + arr2[first - 1] >= K)
				--first;
			if(first >= 0 && last >= 0 && arr1[i] + arr2[first] == K)
				ans += last - first + 1;
		}
 
		System.out.println(ans);
	}
}