from heapq import heappop, heappush

def dijkstra(graph, start):
    """ 
        Uses Dijkstra's algortihm to find the shortest path from node start
        to all other nodes in a directed weighted graph.
    """
    n = len(graph)
    dist, parents = [float("inf")] * n, [-1] * n
    dist[start] = 0
    parents[start] = start
    queue = [(0, start)]
    while queue:
        path_len, v = heappop(queue)
        if path_len == dist[v]:
            for w, edge_len in graph[v]:
                if edge_len + path_len < dist[w]:
                    dist[w], parents[w] = edge_len + path_len, v
                    heappush(queue, (edge_len + path_len, w))

    # return dist, parents
    return dist

n,m = map(int,input().split())

graph = [[] for _ in range(2*n)]
for _ in range(m):
    a,b,c = map(int,input().split())
    a -= 1
    b -= 1
    graph[a].append((b,c))
    graph[a].append((b+n,c//2))
    graph[a+n].append((b+n,c))
res = dijkstra(graph,0)
# print(graph,res)
print(min(res[n-1],res[n+n-1]))