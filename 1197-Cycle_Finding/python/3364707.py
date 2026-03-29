from sys import setrecursionlimit, stdin
from collections import defaultdict, deque, Counter
from itertools import combinations, permutations, product
from functools import lru_cache
from heapq import heappush, heappop
setrecursionlimit(300005)
input = lambda: stdin.readline().rstrip("\r\n")
LOGN = 20
INF = 10 ** 18
MOD = 1000000007
# ============================ START OF MY CODE ============================

def bellman_ford_negative_cycle(n, edges, start):
    dist = [INF for _ in range(n)]
    prev = [-1 for _ in range(n)]
    dist[start] = 0
    node = 0
    for _ in range(n):
        node = -1
        for (u, v, w) in edges:
            if dist[u] != INF and dist[v] > dist[u] + w:
                dist[v] = max(- INF, dist[u] + w)
                prev[v] = u
                node = v

    if node == -1:
        return []  # no reachable negative cycle from start

    for _ in range(n):
        node = prev[node]
    path = []
    cur = node
    while True:
        path.append(cur)
        if cur == node and len(path) > 1:
            break
        cur = prev[cur]
    path.reverse()
    return path

def solve():
    N, M = map(int, input().split())
    edges = []
    for _ in range(M):
        a, b, c = map(int, input().split())
        a -= 1; b -= 1
        edges.append((a, b, c))
    for i in range(N):
        edges.append((N, i, 0))

    P = bellman_ford_negative_cycle(N + 1, edges, N)
    if len(P) == 0:
        print("NO")
    else:
        print("YES")
        print(" ".join(str(c + 1) for c in P))

if __name__ == "__main__":
    solve()