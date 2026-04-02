//package graphAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_12464908 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputRead = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(inputRead.nextToken());
        int m = Integer.parseInt(inputRead.nextToken());

        List<List<Integer>> adj = new ArrayList<>(n+1);
        int[] colors = new int[n+1];

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
            colors[i] = -1;
        }

        for(int i=0;i<m;i++){
            inputRead = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(inputRead.nextToken());
            int b = Integer.parseInt(inputRead.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean isColor = false;
        for(int i=1;i<=n;i++){
            if(colors[i] == -1){
                queue.push(i);
                colors[i] = 1;

                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int x=0;x<size;x++){
                        int node = queue.removeFirst();
                        for(int c : adj.get(node)){
                            if(colors[c] == -1){
                                colors[c] = (colors[node] == 1) ? 2 : 1;
                                queue.add(c);
                            }else{
                                isColor = colors[c] == colors[node];
                                if(isColor) break;
                            }
                        }
                        if(isColor) break;
                    }
                    if(isColor) break;
                }

                if(isColor) break;
            }
        }

        StringBuilder output = new StringBuilder();
        if(isColor)
            output.append("IMPOSSIBLE");
        else{
            for(int i=1;i<=n;i++)
                output.append(colors[i]).append(" ");
        }

        System.out.println(output);
    }
}