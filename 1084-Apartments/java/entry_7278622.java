//package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_7278622 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] line = input.readLine().split(" ");
        int k = Integer.parseInt(line[2]);


        String[] desiredStr = input.readLine().split(" ");
        ArrayList<Integer> desiredArr = new ArrayList<>();

        for (String s : desiredStr) {
            desiredArr.add(Integer.parseInt(s));
        }


        String[] apartmentsStr = input.readLine().split(" ");
        List<Integer> apartmentArr = new ArrayList<>();

        for (String s : apartmentsStr) {
            apartmentArr.add(Integer.parseInt(s));
        }

        Collections.sort(desiredArr);
        Collections.sort(apartmentArr);
        int count = 0;

        int i = 0;
        int j = 0;

        while (i < desiredArr.size() && j < apartmentArr.size()) {
            if (desiredArr.get(i) - apartmentArr.get(j) > k) {
                j++;
            } else if (desiredArr.get(i) - apartmentArr.get(j) < -1 * k) {
                i++;

            } else {
                count++;
                i++;
                j++;
            }
        }
        System.out.println(count);
    }
}