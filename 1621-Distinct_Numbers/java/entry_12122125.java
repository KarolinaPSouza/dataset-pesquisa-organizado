import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class t {
    public static void main(String args[]) {

        // BufferedReader reader;
        // try {
        // reader = new BufferedReader(new FileReader("input.txt"));
        // int n = Integer.parseInt(reader.readLine().trim());
        // String[] numbers = reader.readLine().trim().split("\\s+");

        // long[] numArray = new long[n];
        // for (int i = 0; i < numbers.length; i++) {
        // numArray[i] = Integer.parseInt(numbers[i]);
        // }
        // solve(numArray);
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }


        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader.readLine();
            HashSet<String>h=new HashSet<>();
        String str[]= bufferedReader.readLine().split(" ");
        for(String s:str)h.add(s);
        System.out.println(h.size());
        } catch (Exception e) {
        }

    }

    // static void solve(long arr[]) {
    //     // System.out.println(Arrays.toString(arr));
    //    HashSet<Long>h=new HashSet<>();
    //    for(long i:arr)h.add(i);
    //     System.out.println(h.size());
    // }
}