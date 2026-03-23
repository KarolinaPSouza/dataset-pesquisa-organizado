import java.util.*;
import java.io.*;

public class entry_15804177 { 
    public static void main(String [] args){
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int applicants = in.nextInt();
        int apartments = in.nextInt();
        int maxDiff = in.nextInt();

        int [] desired = new int[applicants];
        for(int i = 0; i < applicants; i++){
            desired[i] = in.nextInt();
        }

        int [] sizes = new int[apartments];
        for(int i = 0; i < apartments; i++){
            sizes[i] = in.nextInt();
        }

        Arrays.sort(desired);
        Arrays.sort(sizes);

        int applicant = 0, apartment = 0, count = 0;
        while(applicant < desired.length && apartment < sizes.length){
            // 1. Calculate the absolute difference between wanted vs availability
            int diff = Math.abs(desired[applicant] - sizes[apartment]);
            // 2. Greedy Choice

            // 2.1 if we have a match, consume apartment and move to next applicant as well
            if(diff <= maxDiff) {
                applicant++;
                apartment++;
                count++;
                // 2.2 we're looking for a bigger apartment, need to move to next available apartment
            } else if(desired[applicant] > sizes[apartment]){
                apartment++;
                // 2.3 we don't want to assign too big of an apartment to this applicant, move to next applicant
            } else {
                applicant++;
            }
        }
        out.println(count);
        out.close();
    }

    static class FastScanner {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer("");
        public String next(){
            while(!tokenizer.hasMoreTokens()){
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                }catch(IOException io){
                    io.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public String nextLine(){
            String line = "";
            try {
                line = reader.readLine();
            }catch(IOException io){
                io.printStackTrace();
            }
            return line;
        }
    }
}