from heapq import heappop, heappush
import sys
input=sys.stdin.readline
n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]
graph2 = [[] for _ in range(n+1)]
for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append((b,c))
    graph2[b].append((a,c))
def dijkstra(graph, source):
    INF = (1<<59)
    black = [False] * (n+1)
    dist = [INF] * (n+1)
    dist[source] = 0
    heap = [(0, source)]
    while heap:
        dist_node, node = heappop(heap)       # Closest node from source
        if not black[node]:
            black[node] = True
            for neighbor in graph[node]:
                neighbor, dist_node_neighbor = neighbor[0], neighbor[1]
                dist_neighbor = dist_node + dist_node_neighbor
                if dist_neighbor < dist[neighbor]:
                    dist[neighbor] = dist_neighbor
                    heappush(heap, (dist_neighbor, neighbor))
    return dist

dist = (dijkstra(graph,source = 1))
dist2 = (dijkstra(graph2,source = n))
ans = (1<<59)
for node in range(1,n+1):
    neighbor_lst = graph[node]
    for neighbor in neighbor_lst:
        neighbor, c = neighbor[0],neighbor[1]
        ans=min(ans, dist[node]+ dist2[neighbor]+ c/2)
print(int(ans))