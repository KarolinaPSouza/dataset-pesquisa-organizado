import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class entry_13454544 {

 private static List<List<Integer>> subordinateTree;
 private static int subordinates[];

 public static void main(String[] args) throws NumberFormatException, IOException {

  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

  int numEmployees = Integer.parseInt(input.readLine());
  subordinates = new int[numEmployees+1];

  subordinateTree = new ArrayList<>();
  for (int i=0; i<=numEmployees;i++) {
   subordinateTree.add(new ArrayList<>());
  }

  String[] parts = input.readLine().split(" ");
        for (int i = 0; i < parts.length; i++) {
            int boss = Integer.parseInt(parts[i]);
            subordinateTree.get(boss).add(i + 2);
        }

  Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);

        while (!stack1.isEmpty()) {
            int node = stack1.pop();
            stack2.push(node);
            for (int child : subordinateTree.get(node)) {
                stack1.push(child);
            }
        }

        while (!stack2.isEmpty()) {
            int node = stack2.pop();
            for (int child : subordinateTree.get(node)) {
                subordinates[node] += 1 + subordinates[child];
            }
        }

  StringBuilder sb = new StringBuilder();
  for (int i=1; i<=numEmployees; i++) {
   sb.append(subordinates[i]);
   sb.append(" ");
  }

  System.out.println(sb.toString().trim());  
  input.close();
 }

}