import sys
sys.setrecursionlimit(10**6)
from collections import deque

def solution(n, tree, start):
    # Find the farthest node from start
    def dfs_farthest(u):
        dist = [-1] * (n+1)
        dist[u] = 0
        q = deque([start])

        while q:
            u = q.popleft()

            for v in tree[u]:
                if dist[v] != -1:
                    continue
                dist[v] = dist[u] + 1
                q.append(v)

        leaf = max(range(1, n+1), key=lambda x: dist[x])
        return leaf, dist

    start, _ = dfs_farthest(start)

    start, dist_u = dfs_farthest(start)

    _, dist_v = dfs_farthest(start)

    return [max(dist_u[i], dist_v[i]) for i in range(1, n+1)]

if __name__ == "__main__":
    n = int(input())

    from collections import defaultdict

    tree = defaultdict(list)

    for _ in range(n-1):
        a, b = tuple(map(int, input().split()))
        tree[a].append(b)
        tree[b].append(a)

    print(*solution(n, tree, 1))