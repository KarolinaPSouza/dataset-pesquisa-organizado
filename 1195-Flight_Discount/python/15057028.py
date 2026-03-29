import sys, heapq
input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        x, y, c = map(int, input().split())
        graph[x].append((y, c))
        # Uncomment the next line if the graph is undirected:
        # graph[y].append((x, c))

    INF = 10**18
    dist = [[INF, INF] for _ in range(n + 1)]
    dist[1][0] = 0

    pq = [(0, 1, 0)]  # (cost, node, used_coupon)
    while pq:
        cost, node, used = heapq.heappop(pq)
        if cost != dist[node][used]:
            continue

        # EARLY EXIT → huge speed boost if destination found
        if node == n and used == 1:
            print(cost)
            return

        for nei, w in graph[node]:
            new_cost = cost + w
            if new_cost < dist[nei][used]:
                dist[nei][used] = new_cost
                heapq.heappush(pq, (new_cost, nei, used))

            if used == 0:
                half_cost = cost + (w >> 1)  # bitwise divide by 2 → slightly faster
                if half_cost < dist[nei][1]:
                    dist[nei][1] = half_cost
                    heapq.heappush(pq, (half_cost, nei, 1))

    # Fallback (if never early-exited)
    print(dist[n][1])

# ---------- main ----------
if __name__ == "__main__":
    solve()