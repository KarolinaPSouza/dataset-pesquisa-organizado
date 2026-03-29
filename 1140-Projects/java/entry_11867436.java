import java.io.*;
import java.util.*;

class FastIO extends PrintWriter{
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i,OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }
}
class Task {
    int start;
    int end;
    int reward;

    Task(int start, int end, int reward) {
        this.start = start;
        this.end = end;
        this.reward = reward;
    }
}

public class entry_11867436 {
    static FastIO sc = new FastIO();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        // Sort tasks by starting time
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

        // Initialize dp array
        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        // Calculate maximum reward using DP
        // long maxReward = 0;
        // for (int i = 0; i < n; i++) {
        //     maxReward = Math.max(getMaximumReward(i, tasks, dp, n), maxReward);
        // }

        sc.print(getMaximumReward(0, tasks, dp, n));
        sc.flush();
    }

    public static long getMaximumReward(int i, Task[] tasks, long[] dp, int n) {
        if (i >= n) {
            return 0; // No tasks left
        }

        if (dp[i] != -1) {
            return dp[i]; // Return memoized value
        }

        // Include current task's reward
        long totalReward = tasks[i].reward;

        // Find next non-overlapping task
        int nextTaskIndex = getUpperBound(tasks, tasks[i].end, i + 1, n);

        // Add the reward from the next task (if any)
        totalReward += getMaximumReward(nextTaskIndex, tasks, dp, n);

        // Store the result in dp array
        dp[i] = Math.max(totalReward, getMaximumReward(i + 1, tasks, dp, n)); // Compare with skipping the current task
        return dp[i];
    }

    public static int getUpperBound(Task[] tasks, int endingTime, int startIndex, int n) {
        int low = startIndex, high = n - 1, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (tasks[mid].start > endingTime) {
                ans = mid; // Update answer to the current index
                high = mid - 1; // Search the left half
            } else {
                low = mid + 1; // Search the right half
            }
        }
        return ans; // Return the first valid index or `n`
    }

}