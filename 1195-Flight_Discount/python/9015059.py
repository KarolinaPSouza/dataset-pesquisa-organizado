from heapq import heappop, heappush


def dijkstra(graph, start):
    """ 
        Uses Dijkstra's algortihm to find the shortest path from node start
        to all other nodes in a directed weighted graph.
    """
    n = len(graph)
    dist, parents = [float("inf")] * n, [-1] * n
    dist[start] = 0

    queue = [(0, start)]
    while queue:
        path_len, v = heappop(queue)
        if path_len == dist[v]:
            for w, edge_len in graph[v]:
                if edge_len + path_len < dist[w]:
                    dist[w], parents[w] = edge_len + path_len, v
                    heappush(queue, (edge_len + path_len, w))

    return dist, parents

c, f = map(int, input().split())

g = {i: [] for i in range(c*2)}

for _ in range(f):
    a, b, d = map(int, input().split())
    g[a-1].append((b-1,d))
    g[(a-1)+c].append((b-1+c,d))
    g[a-1].append((b-1+c,d//2))

dist, parents = dijkstra(g, 0)
print(min(dist[c-1], dist[c-1+c]))