import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ElementWithIndex1 implements Comparable<ElementWithIndex1> {
    int value;
    int index;

    public ElementWithIndex1(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(ElementWithIndex1 o) {
        return Integer.compare(this.value, o.value);
    }
}

public class entry_8555223 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] elemental = br.readLine().split(" ");
        int n = Integer.parseInt(elemental[0]);
        int k = Integer.parseInt(elemental[1]);

        String[] tokens = br.readLine().split(" ");
        ElementWithIndex1[] arr = new ElementWithIndex1[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ElementWithIndex1(Integer.parseInt(tokens[i]), i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i].value + arr[j].value + arr[left].value + arr[right].value;
                    if (sum == k) {
                        //System.out.println(arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right]);
                        ArrayList<Integer> sorted = new ArrayList<>();
                        sorted.add(arr[i].index+1);
                        sorted.add(arr[j].index+1);
                        sorted.add(arr[left].index+1);
                        sorted.add(arr[right].index+1);
                        Collections.sort(sorted);
                        for (int idx : sorted) {
                            System.out.print(idx + " ");
                        }
                        System.out.println();
                        return; // Assuming you only need one valid quadruplet
                    } else if (sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}