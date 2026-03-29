import sys
import heapq
from collections import defaultdict

input = sys.stdin.readline
INF = float('inf')

def solve():
    n, m = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(m):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))

    dist = [[INF] * 2 for _ in range(n + 1)]
    dist[1][0] = 0

    # state: (cost_so_far, node, used_discount)
    pq = [(0, 1, 0)]

    while pq:
        cost, u, used = heapq.heappop(pq)
        if dist[u][used] < cost:
            continue
        for v, w in graph[u]:
            # without using discount
            if dist[v][used] > cost + w:
                dist[v][used] = cost + w
                heapq.heappush(pq, (dist[v][used], v, used))
            # use discount if not yet used
            if used == 0 and dist[v][1] > cost + (w // 2):
                dist[v][1] = cost + (w // 2)
                heapq.heappush(pq, (dist[v][1], v, 1))

    print(dist[n][1])

solve()