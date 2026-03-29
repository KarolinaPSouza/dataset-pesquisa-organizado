//package csesDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class entry_9113798 {
    static class FastReader {
        private final InputStream in;
        final private int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int ptr = 0;
        private int bytesRead = 0;

        public FastReader(InputStream stream) {
            this.in = stream;
        }

        private boolean hasNextByte() {
            if (ptr < bytesRead) {
                return true;
            } else {
                ptr = 0;
                try {
                    bytesRead = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bytesRead <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte()) return buffer[ptr++];
            else return -1;
        }

        public boolean hasNext() {
            while (hasNextByte() && !(buffer[ptr] >= 33 && buffer[ptr] <= 126)) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new InputMismatchException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (b >= 33 && b <= 126) {
                sb.append((char) b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    private static int binary_search(int [][] arr , int val , int end){
        int possAns = -1;
        int last = end;
        int first = 0;

        while(first <= last){
            int mid = (last + first)/2;
            if(arr[mid][1] < val){
                possAns = Math.max(mid , possAns);
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        return possAns;
    }
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        FastReader sc = new FastReader(System.in);
        int numberOfProjects = sc.nextInt();


        int [][] projectsDescription = new int [numberOfProjects][3];

        for(int i = 0 ; i < numberOfProjects ; i++){
            projectsDescription[i][0] = sc.nextInt();
            projectsDescription[i][1] = sc.nextInt();
            projectsDescription[i][2] = sc.nextInt();
        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numberOfProjects = Integer.parseInt(br.readLine().trim());
//
//        int[][] projectsDescription = new int[numberOfProjects][3];
//
//        for (int i = 0; i < numberOfProjects; i++) {
//            String[] project = br.readLine().trim().split(" ");
//            projectsDescription[i][0] = Integer.parseInt(project[0]);
//            projectsDescription[i][1] = Integer.parseInt(project[1]);
//            projectsDescription[i][2] = Integer.parseInt(project[2]);
//        }
        Arrays.sort(projectsDescription , (a, b) -> a[1] - b[1]);
        long [] maxProfit = new long [numberOfProjects];
        maxProfit[0] = projectsDescription[0][2];

//        for(int i = 0 ; i < numberOfProjects ; i++){
//            System.out.println(projectsDescription[i][0] + "  "
//                    + projectsDescription[i][1] + "  "
//                    + projectsDescription[i][2]);
//        }

        for(int i = 1 ; i < numberOfProjects ; i++){
            maxProfit[i] = Math.max(maxProfit[i-1] , projectsDescription[i][2]);
            int indexOfLastProject = binary_search(projectsDescription , projectsDescription[i][0] , i);

            if(indexOfLastProject != -1){
                maxProfit[i] = Math.max(maxProfit[i] , maxProfit[indexOfLastProject] + projectsDescription[i][2]);
            }
        }
        System.out.println(maxProfit[numberOfProjects - 1]);
//        Arrays.stream(maxProfit).forEach(e -> System.out.print(e + "  "));

    }
}

/*
* Input
The first input line contains an integer n: the number of projects.
After this, there are n lines. Each such line has three integers a_i, b_i, and p_i: the starting day, the ending day, and the reward.
Output
Print one integer: the maximum amount of money you can earn.
Constraints
1 <= n <= 2*10^5
1 <= a_i <= b_i <= 10^9
1 <= p_i <= 10^9
Example
Input:
4
2 4 4
3 6 6
6 8 2
5 7 3
Output:
7
*
10
14 14 98
76 76 58
94 94 57
92 92 45
82 82 14
86 86 41
87 87 72
14 14 26
27 27 85
48 48 52
522
* */