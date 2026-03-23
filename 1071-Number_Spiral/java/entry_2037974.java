import java.util.*;
import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;

class NumberSpiral {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        PrintWriter out = new PrintWriter(System.out); 

        int t = Integer.parseInt(bf.readLine());
        while(t-->0){
            String[] input = bf.readLine().split(" ");
            Long row = Long.parseLong(input[0]);
            Long col = Long.parseLong(input[1]);

            if(row == col){
                out.println(row*row - row + 1);
            }else if(row < col){
                if(col%2==0){
                    out.println((col-1)*(col-1) + row);                      // 3,4 -> 12
                }else{
                    out.println(col*col - row +1);          // 4,5 -> 22
                }
            }else{
                if(row%2==0){
                    out.println(row*row - col + 1);                          // 4, 3 -> 14
                }else{
                    out.println((row-1)*(row-1)+col);                          // 3, 2 -> 6
                }
            }
        }

        out.flush();
        out.close();
        bf.close();
    }
}