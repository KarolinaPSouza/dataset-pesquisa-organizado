import sys
from heapq import heappush, heappop
input = sys.stdin.readline
INF = float('inf')

def dijkstra(n, G):
    dist = [[INF, INF] for _ in range(n + 1)]
    dist[1][0] = 0
    pq = [(0, 1, 0)]
    while pq:
        d, u, used = heappop(pq)
        if d > dist[u][used]:
            continue
        if u == n:
            return d
        for v, wt in G[u]:
            if not used:
                new_d = d + wt // 2
                if new_d < dist[v][1]:
                    dist[v][1] = new_d
                    heappush(pq, (new_d, v, 1))
            new_d = d + wt
            if new_d < dist[v][used]:
                dist[v][used] = new_d
                heappush(pq, (new_d, v, used))
    return min(dist[n])

def main():
    n, m = map(int, input().split())
    G = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v, wt = map(int, input().split())
        G[u].append((v, wt))
    print(dijkstra(n, G))

if __name__ == "__main__":
    main()