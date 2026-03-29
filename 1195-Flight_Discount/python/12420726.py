import heapq
import sys

INF = 10**14

input = sys.stdin.buffer.readline  # Redefine input for speed.
n, m = map(int, input().split())

adj = [[] for _ in range(2*n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    adj[a-1].append((b-1, c))
    adj[a-1].append((b-1+n, c//2))
    adj[a-1+n].append((b-1+n, c))


distance = [INF] * (2*n)  # (*without discount, *with discount)
distance[0] = 0
dijkstra_pq = [(0, 0)]
while dijkstra_pq:
    dist, node = heapq.heappop(dijkstra_pq)
    if dist == distance[node]:
        for other, cost in adj[node]:
            if distance[other] > dist + cost:
                distance[other] = dist + cost
                heapq.heappush(dijkstra_pq, (dist + cost, other))

print(min(distance[n-1], distance[2*n-1]))