import java.io.*;
import java.util.*;
public class entry_6074577 {
    static ArrayList<Integer>[] children;
    static int[]colors;
    static boolean[] visited;
    static boolean works = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer sr = new StringTokenizer(line);
        int n = Integer.parseInt(sr.nextToken());
        int m = Integer.parseInt(sr.nextToken());
        children = new ArrayList[n+1];
        colors = new int[n+1]; //the colorings for each of the children!
        visited = new boolean[n+1];

        for(int i = 0; i < children.length; i++) {
            children[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            String line2 = br.readLine();
            StringTokenizer st = new StringTokenizer(line2);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            children[a].add(b);
            children[b].add(a);
        }
        for(int i = 1; i < children.length; i++) {
            if(colors[i] == 0) { //some kids that are not connected!
                colors[i] = 1;
                DFS(i, 1);
            }
            if(!works) {
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
        if(works) {
            StringBuilder builder = new StringBuilder("");
            for(int i = 1; i < colors.length; i++) {
                builder.append(colors[i] + " ");
            }
            System.out.println(builder.substring(0, builder.length()-1));

        }
    }
    public static void DFS(int n, int color) { //include the child and the color!
        if(children[n].size() == 0 || visited[n]) { //color n should not equal to color!!!!!!
            return;
        }
        else { //set the child to be the other color!
            visited[n] = true;
            for(int i = 0; i < children[n].size(); i++) {
                if(colors[children[n].get(i)] == color) {
                    works = false;
                    return;
                }
                else {
                    if(colors[n] == 1) {
                        colors[children[n].get(i)] = 2;
                    }
                    else {
                        colors[children[n].get(i)] = 1;
                    }
                    DFS(children[n].get(i), colors[children[n].get(i)]);
                }
            }
        }
    }
}