import sys
from heapq import heappush, heappop
input = sys.stdin.readline
INF = float('inf')

def dijkstra(n, G):
    # Initialize distances: [without coupon, with coupon]
    dist = [[INF, INF] for _ in range(n + 1)]
    dist[1][0] = 0
    pq = [(0, 1, 0)]  # (distance, city, coupon_used)

    while pq:
        d, u, used = heappop(pq)
        if d > dist[u][used]:
            continue
        if u == n:
            return d  # Reached the destination

        for v, wt in G[u]:
            if not used:
                # Try using the coupon
                new_d = d + wt // 2
                if new_d < dist[v][1]:
                    dist[v][1] = new_d
                    heappush(pq, (new_d, v, 1))

            # Don't use the coupon (or already used)
            new_d = d + wt
            if new_d < dist[v][used]:
                dist[v][used] = new_d
                heappush(pq, (new_d, v, used))

    return min(dist[n])  # Return the minimum distance to reach n

def main():
    n, m = map(int, input().split())
    G = [[] for _ in range(n + 1)]  # Adjacency list
    for _ in range(m):
        u, v, wt = map(int, input().split())
        G[u].append((v, wt))
    print(dijkstra(n, G))

if __name__ == "__main__":
    main()