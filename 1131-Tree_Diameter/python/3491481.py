# =============== author: kuanc | created: 02/04/22 22:51:48 =============== #
from sys            import setrecursionlimit, stdin, stderr
from bisect         import bisect_left, bisect_right
from collections    import defaultdict, deque, Counter
from itertools      import combinations, permutations, product
from functools      import lru_cache, cmp_to_key, reduce
from heapq          import heapify, heappush, heappop, heappushpop, heapreplace
setrecursionlimit(300005)
LOGN  = 20
INF   = 1 << 60
MOD   = 10 ** 9 + 7
input = lambda: stdin.readline().rstrip("\r\n")
dbg   = lambda *A, **M: stderr.write("\033[91m" + \
        M.get("sep", " ").join(map(str, A)) + M.get("end", "\n") + "\033[0m")
# ============================ START OF MY CODE ============================ #

def diameter(n, G):
    def bfs(start):
        dist = [-1 for _ in range(n)]
        dist[start] = 0
        stk = [start]
        while stk:
            node = stk.pop()
            for (neigh, neigh_d) in G[node]:
                if dist[neigh] != -1:
                    continue
                dist[neigh] = dist[node] + neigh_d
                stk.append(neigh)
        max_i = dist.index(max(dist))
        return max_i, dist

    u, _ = bfs(0)
    v, dist = bfs(u)
    diam = dist[v]
    path = [v]
    while u != v:
        for (neigh, neigh_d) in G[v]:
            if dist[neigh] + neigh_d == dist[v]:
                path.append(neigh)
                v = neigh
                break
    return diam, path

def solve():
    N = int(input())
    adj = [[] for _ in range(N)]
    for _ in range(N - 1):
        a, b = map(int, input().split())
        a -= 1; b -= 1
        adj[a].append((b, 1))
        adj[b].append((a, 1))

    ans, _ = diameter(N, adj)
    print(ans)

if __name__ == "__main__":
    solve()