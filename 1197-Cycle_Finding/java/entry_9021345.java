// Ilya Grigorev

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class entry_9021345 {

    public static Long INF = (long)2000000000;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Graph<Integer> graph = new Graph<>();

        int n = s.nextInt();
        int m = s.nextInt();

        for (int i = 0; i < n; ++i) {
            graph.insertVertex(i, i);
        }

        for (int i = 0; i < m; ++i) {
            int from = s.nextInt() - 1;
            int to = s.nextInt() - 1;
            long w = s.nextInt();
            graph.insertEdge(graph.vertexByIndex.get(from), graph.vertexByIndex.get(to), w);
        }

        graph.BellmanFord((long)0, INF, 0);

        s.close();
    }
}

/***
 * Generic class Vertex with key of type V
 * connected by edges with key of type E.
 * 
 * @author Dvid025
 */
class Vertex<V> {

    // Label of a vertex
    public V key;

    // Value for distance
    public Long d;

    // Parent Vertex in shortest path

    public Vertex<V> p;

    // List of edges that connect vertex with its adjacency vertices
    public List<Edge<V>> adjacent;

    // Unique index of a vertex
    public int index;

    public Vertex(V key, int index) {
        this.key = key;
        this.index = index;
        this.adjacent = new LinkedList<>();
    }

    /**
     * Degree function
     * @return degree of a vertex
     */
    public int degree() {
        return this.adjacent.size();
    }

    /**
     * Determines whether instance is
     * equal to other object.
     * 
     * @return true if equal else false
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex<?>)) {
            return false;
        }
        return (((Vertex<?>)o).index == this.index);
    }

}

/***
 * Generic class edge with key of type E
 * that connects vertices with keys of type V.
 * 
 * @author Dvid025
 */
class Edge<V> {

    // Label of edge
    public Long key;

    // Endvertices
    public Vertex<V> from;
    public Vertex<V> to;

    public Edge(Vertex<V> from, Vertex<V> to, Long key) {
        this.from = from;
        this.to = to;
        this.key = key;
    }
}

/***
 * Generic class Pair that
 * represents a pair of two elements of
 * types F and S, respectively.
 * 
 * @author Dvid025
 */
class Pair<F, S> {
    public F first;
    public S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}

/***
 * Generic class Graph that 
 * represents a undirected graph implemented
 * using adjacency lists.
 * 
 * @author Dvid025
 */
class Graph<V> {

    // List of vertices
    public List<Vertex<V>> vertices;

    // List of edges
    public List<Edge<V>> edges;

    // Random Access Table for Vertices
    public List<Vertex<V>> vertexByIndex;

    public Graph() {
        vertices = new LinkedList<>();
        edges = new LinkedList<>();
        vertexByIndex = new ArrayList<>();
    }

    /**
     * Insertion of a new vertex.
     * @param element label of a new vertex
     * @param index unique index
     * @return new Vertex object
     */
    public Vertex<V> insertVertex(V element, int index) {
        Vertex<V> vertex = new Vertex<>(element, index);
        vertices.add(vertex);
        vertexByIndex.add(vertex);

        return vertex;
    }

    /**
     * Insertion of a new edge.
     * @param from an endvertex object
     * @param to an endvertex object
     * @param key label of a new edge
     * @return new Edge object
     */
    public Edge<V> insertEdge(Vertex<V> from, Vertex<V> to, Long key) {
        Edge<V> edge = new Edge<>(from, to, key);
        from.adjacent.add(edge);
        // to.adjacent.add(edge);
        edges.add(edge);

        return edge;
    }

    /**
     * Gets an edge between adjacent vertices.
     * @param u an endvertex
     * @param v an endvertex
     * @return edge object connecting u and v
     */
    public Edge<V> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<V> edge : u.adjacent) {
            if ( ( (edge.from == u) && (edge.to == v) )) {
                return edge;
            }
        }

        return null;
    }

    /**
     * Determines whether two vertices are adjacent.
     * @param u a vertex object
     * @param v a vertex object
     * @return true if adjacent, else false
     */
    public boolean areAdjacent(Vertex<V> u, Vertex<V> v) {
        for (Edge<V> edge : u.adjacent) {
            if ( ( (edge.from == u) && (edge.to == v) ) ) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the pair of endvertices of a given edge.
     * @param edge an edge object
     * @return pair of endvertices
     */
    public Pair<Vertex<V>, Vertex<V>> endVertices(Edge<V> edge) {
        Pair<Vertex<V>, Vertex<V>> pair = new Pair<>(edge.from, edge.to);
        return pair;
    }

    private void relax(Vertex<V> u, Vertex<V> v, Long key) {
        // System.out.println(  ((Wrapper)v.d).value + " > " + ((Wrapper)u.d.add(key)).value + "?" + "(" + (u.index+1) + " to " + (v.index+1) + ")"  );
        if (v.d > u.d + key) {
            v.d = u.d + key;
            v.p = u;
            // System.out.println((v.index + 1) + " now has a parent " + (u.index + 1));
        }
    }

    public void BellmanFord(Long minValue, Long maxValue, int startIndex) {
        for (Vertex<V> v : vertices) {
            v.p = null;
            v.d = maxValue;
        }

        vertexByIndex.get(startIndex).d = minValue;

        for (int i = 0; i < vertices.size() - 1; ++i) {
            for (Edge<V> edge : edges) {
                relax(edge.from, edge.to, edge.key);
            }
        }

        // Cycle vertex
        Vertex<V> start = null;
        for (Edge<V> edge : edges) {
            if (edge.to.d > edge.from.d + edge.key) {
                edge.to.d = edge.from.d + edge.key;
                edge.to.p = edge.from;
                start = edge.to;
            }
        }

        if (start != null) {
            System.out.println("YES");
            for(int i = 0; i < vertices.size(); i++) {
                start = start.p;
            }

            List<Integer> cycle = new ArrayList<>();

            for (Vertex<V> v = start;; v = v.p) {
                cycle.add(v.index);

                if (v.equals(start) && cycle.size() > 1) {
                    break;
                }
            }

            for(int i = cycle.size() - 1; i >= 0; --i) { 
                System.out.print((cycle.get(i) + 1) + " ");
            }
        } else {
            System.out.println("NO");
        }
    }
}