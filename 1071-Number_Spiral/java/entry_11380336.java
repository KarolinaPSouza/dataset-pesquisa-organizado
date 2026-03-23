import java.io.*;

public class entry_11380336 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t!=0){
            String[] entry_11380336 = br.readLine().split(" ");
            int row = Integer.parseInt(entry_11380336[0]);
            int col = Integer.parseInt(entry_11380336[1]);
            long answer=0;
            if(row>col){
                if(row%2==0){
                    long ele = (long) row * row;
                    answer = ele - col +1;
                }
                else{
                    long ele = (long) (row - 1) *(row-1)+1;
                    answer = ele + col -1;
                }
            }
            else{
                if(col%2!=0){
                    long ele = (long) col * col;
                    answer = ele - row + 1;
                }
                else{
                    long ele = (long) (col - 1) *(col-1)+1;
                    answer = ele + row - 1;
                }
            }
            System.out.println(answer);
            t--;
        }

    }
}