import sys
import heapq

def solve():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    adj = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        adj[a].append((b, c))

    INF = float('inf')
    dist = [[INF, INF] for _ in range(n + 1)]
    dist[1][0] = 0  # Start from node 1, no coupon used

    pq = [(0, 1, 0)]  # cost, node, used_coupon_flag

    while pq:
        cost, u, used = heapq.heappop(pq)

        if dist[u][used] < cost:
            continue

        for v, w in adj[u]:
            # 1. Without using coupon
            if dist[v][used] > cost + w:
                dist[v][used] = cost + w
                heapq.heappush(pq, (dist[v][used], v, used))

            # 2. Using coupon now
            if used == 0:
                new_cost = cost + (w // 2)
                if dist[v][1] > new_cost:
                    dist[v][1] = new_cost
                    heapq.heappush(pq, (new_cost, v, 1))

    print(dist[n][1])  # Cost to reach node n with coupon used

solve()