import sys
import heapq

# Fast I/O
def get_int():
    return int(sys.stdin.readline())

def get_line():
    return sys.stdin.readline().strip()

def get_ints():
    return list(map(int, sys.stdin.readline().split()))

def get_lines():
    return [line.strip() for line in sys.stdin.readlines()]

INF = 10**18

def dijkstra(start, graph, n):
    dist = [INF] * (n + 1)
    dist[start] = 0
    heap = [(0, start)]
    heappop = heapq.heappop
    heappush = heapq.heappush

    while heap:
        d, u = heappop(heap)
        if d != dist[u]:
            continue
        for v, w in graph[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heappush(heap, (nd, v))
    return dist

# Main logic for the problem
def solve():
    input = sys.stdin.readline
    n, m = map(int, input().split())

    adj = [[] for _ in range(n + 1)]
    radj = [[] for _ in range(n + 1)]
    edges = []

    for _ in range(m):
        a, b, c = map(int, input().split())
        adj[a].append((b, c))
        radj[b].append((a, c))
        edges.append((a, b, c))

    dist1 = dijkstra(1, adj, n)
    dist2 = dijkstra(n, radj, n)

    ans = INF
    for a, b, c in edges:
        # dist1[a] + floor(c/2) + dist2[b]
        if dist1[a] != INF and dist2[b] != INF:
            cost = dist1[a] + (c // 2) + dist2[b]
            if cost < ans:
                ans = cost

    print(ans)

if __name__ == "__main__":
    solve()