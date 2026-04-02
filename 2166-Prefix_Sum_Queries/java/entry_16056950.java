import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_16056950 {
    int n, q;
    int[] arr;

    class SegmentTree {

        long[] sum;
        long[] maxPre;
        int[] arr;
        int n;

        public SegmentTree(int[] arr) {
            this.n = arr.length;
            this.sum = new long[4*n];
            this.maxPre = new long[4*n];
            this.arr = arr;

            Arrays.fill(maxPre, Integer.MIN_VALUE);

            createTree(0, 0, n-1);
        }

        void createTree(int node, int start, int end) {
            if(start > end)
                return;
            else if(start == end) {
                sum[node] = arr[start];
                maxPre[node] = arr[start];
                return;
            }

            int mid = start + (end-start)/2;

            createTree(2*node +1, start, mid);
            createTree(2*node +2, mid+1, end);

            sum[node] = sum[2*node + 1] + sum[2*node + 2];
            maxPre[node] = Math.max(maxPre[2*node + 1], sum[2*node+1] + maxPre[2*node+2]);
        }

        void update(int ind, int val) {
            updateNode(0, 0, n-1, ind, val);
        }

        void updateNode(int node, int start, int end, int ind, int val) {
            if(start == end) {
                sum[node] = val;
                maxPre[node] = val;
                return;
            }

            int mid = start + (end-start)/2;

            if(ind <= mid) {
                updateNode(2*node +1, start, mid, ind, val);
            } else {
                updateNode(2*node +2, mid+1, end, ind, val);
            }

            sum[node] = sum[2*node +1] + sum[2*node + 2];
            maxPre[node] = Math.max(maxPre[2*node + 1], maxPre[2*node+2] + sum[2*node+1]);
        }

        long get(int a, int b) {
            return getNode(0, 0, n-1, a, b)[1];
        }

        long[] getNode(int node, int start, int end, int a, int b) {
            if(start == a && end == b) {
                return new long[]{sum[node], maxPre[node]};
            } else if(a > end || b < start)
                return new long[]{0, Integer.MIN_VALUE};

            int mid = start + (end-start)/2;

            if(b <= mid) {
                return getNode(2*node + 1, start, mid, a, b);
            } else if(a > mid) {
                return getNode(2*node+2, mid+1, end, a, b);
            } else {
                long[] x = getNode(2*node+1, start, mid, a, mid);
                long[] y = getNode(2*node +2, mid+1, end, mid+1, b);
                return new long[]{x[0] + y[0], Math.max(x[0] + y[1], x[1])};
            }
        }
    }

    void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        this.n = Integer.parseInt(tokenizer.nextToken());
        this.q = Integer.parseInt(tokenizer.nextToken());

        this.arr = new int[n];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i= 0; i<n; i++) {
            this.arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        SegmentTree tree = new SegmentTree(arr);

        StringBuilder output = new StringBuilder();

        for(int i=0; i<q; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            if(tokenizer.nextToken().equals("1")) {
                int k = Integer.parseInt(tokenizer.nextToken());
                int u = Integer.parseInt(tokenizer.nextToken());

                tree.update(k-1, u);
            } else {
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());

                output.append(Math.max(0, tree.get(a-1, b-1)));
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    public static void main (String ...args) throws Exception {
        new entry_16056950().init();
    }
}