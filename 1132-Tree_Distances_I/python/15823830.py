import sys

from collections import deque

it = map(int, sys.stdin.buffer.read().split())


def solve() -> str:
    n = next(it)
    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = next(it), next(it)
        adj[a].append(b)
        adj[b].append(a)

    def bfs(start_node):
        dists = [-1] * (n + 1)
        dists[start_node] = 0
        queue = deque([start_node])

        max_dist = 0
        furthest_node = start_node

        while queue:
            u = queue.popleft()

            if dists[u] > max_dist:
                max_dist = dists[u]
                furthest_node = u

            for v in adj[u]:
                if dists[v] == -1:
                    dists[v] = dists[u] + 1
                    queue.append(v)

        return furthest_node, dists

    u, _ = bfs(1)
    v, dists_from_u = bfs(u)
    _, dists_from_v = bfs(v)

    results = []
    for i in range(1, n + 1):
        results.append(str(max(dists_from_u[i], dists_from_v[i])))

    return " ".join(results)


# out = [solve() for _ in range(next(it))]
# sys.stdout.write("\n".join(out))
sys.stdout.write(solve())
