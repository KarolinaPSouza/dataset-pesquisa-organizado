import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_1694146 {

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();
        int n = reader.readSingleInt();

        Node[] nodes = new Node[n+1];

        for(int i = 1; i<=n; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i<n-1; i++){
            int[] e = reader.readIntArray(2);
            nodes[e[0]].adj.add(nodes[e[1]]);
            nodes[e[1]].adj.add(nodes[e[0]]);
        }

        ArrayDeque<Node> dq = new ArrayDeque<>();
        nodes[1].seenInitial = true;
        dq.addLast(nodes[1]);

        Node ep1 = null;

        while(dq.size() > 0){
            Node p = dq.removeFirst();
            ep1 = p;
            for(int i = 0; i<p.adj.size(); i++){
                Node c = p.adj.get(i);
                if(c.seenInitial) continue;
                c.seenInitial = true;
                dq.addLast(c);
            }
        }


        int[] distanceToEP1 = new int[n+1];
        ep1.seenByEP1 = true;
        dq.addLast(ep1);
        int count = 0;

        Node ep2 = null;

        while(dq.size() > 0){
            int dqSize = dq.size();
            for(int i = 0; i<dqSize; i++){
                Node p = dq.removeFirst();
                distanceToEP1[p.id] = count;
                ep2 = p;
                for(int j = 0; j<p.adj.size(); j++){
                    Node c = p.adj.get(j);
                    if(c.seenByEP1) continue;
                    c.seenByEP1 = true;
                    dq.addLast(c);
                }
            }
            count++;
        }


        int[] distanceToEP2 = new int[n+1];
        ep2.seenByEP2 = true;
        dq.addLast(ep2);
        count = 0;

        while(dq.size() > 0){
            int dqSize = dq.size();
            for(int i = 0; i<dqSize; i++){
                Node p = dq.removeFirst();
                distanceToEP2[p.id] = count;
                for(int j = 0; j<p.adj.size(); j++){
                    Node c = p.adj.get(j);
                    if(c.seenByEP2) continue;
                    c.seenByEP2 = true;
                    dq.addLast(c);
                }
            }
            count++;
        }

        int[] maxPaths = new int[n];

        for(int i = 1; i<=n; i++){
            maxPaths[i-1] = Math.max(distanceToEP1[i], distanceToEP2[i]);
        }

        writer.writeIntArrayWithSpaces(maxPaths);

        /*
        There are two nodes at the edge of the on the longest path,
        Every nodes longest path will end at one of these two nodes.
        Proof, let the end node of the longest point from node a be
        y. Let the distance from a to y = x. If y is an end point of the longest path,
        then we are done. Else, let z be furtherest distance from x that is on the
        diameter ends.
        */
    }


    public static class Node {

        int id;
        boolean seenInitial, seenByEP1, seenByEP2;
        ArrayList<Node> adj = new ArrayList<>();

        public Node(int id){
            this.id = id;
        }

    }




    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }


    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static class FastReader {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;


        public int readSingleInt() throws IOException {
            return Integer.parseInt(reader.readLine());
        }

        public int[] readIntArray(int numInts) throws IOException {
            int[] nums = new int[numInts];
            tokenizer = new StringTokenizer(reader.readLine());
            for(int i = 0; i<numInts; i++){
                nums[i] = Integer.parseInt(tokenizer.nextToken());
            }
            return nums;
        }

        public String readString() throws IOException {
            return reader.readLine();
        }

    }



    public static class FastWriter {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        public void writeSingleInteger(int i) throws IOException {
            writer.write(Integer.toString(i));
            writer.newLine();
            writer.flush();
        }

        public void writeSingleLong(long i) throws IOException {
            writer.write(Long.toString(i));
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayWithSpaces(int[] nums) throws IOException {
            for(int i = 0; i<nums.length; i++){
                writer.write(nums[i] + " ");
            }
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayWithoutSpaces(int[] nums) throws IOException {
            for(int i = 0; i<nums.length; i++){
                writer.write(Integer.toString(nums[i]));
            }
            writer.newLine();
            writer.flush();
        }

        public void writeString(String s) throws IOException {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }

    }
}