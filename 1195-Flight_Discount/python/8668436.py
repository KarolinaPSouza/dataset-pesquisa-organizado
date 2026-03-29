from collections import defaultdict
from heapq import heappop, heappush


n,m = [int(x) for x in input().split()]
graph = defaultdict(list)
for _ in range(m):
    u,v,w = [int(x) for x in input().split()]
    graph[u].append((v,w))

heap = [(0,1)]
visited = set()
dist = [float('inf')]*(n*2+1)
dist[1] = 0
dist[n+1] = 0
while heap:
    _,node = heappop(heap)
    if node in visited: continue
    if node == 2*n: break
    visited.add(node)
    hasCoupan = node <= n
    for nxt,w in graph[node%n]:
        #use coupon for next flight
        if hasCoupan and dist[node] + (w>>1) < dist[nxt+n]:
            dist[nxt+n] = dist[node] + (w>>1)
            heappush(heap,(dist[nxt+n],nxt+n))

        #skip using the coupon
        if hasCoupan and dist[node] + w < dist[nxt]:
            dist[nxt] = dist[node] + w
            heappush(heap,(dist[nxt],nxt))

        #no coupon to use
        if not hasCoupan and dist[node] + w < dist[nxt+n]:
            dist[nxt+n] = dist[node] + w
            heappush(heap,(dist[nxt+n],nxt+n))

print(dist[-1])
