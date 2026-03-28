import sys
from collections import deque

def bfs(start, n, tree):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    while q:
        u = q.popleft()
        for v in tree[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    return dist

def solve_one(n, edges):
    tree = [[] for _ in range(n + 1)]
    for a, b in edges:
        tree[a].append(b)
        tree[b].append(a)

    dist1 = bfs(1, n, tree)
    farA = max(range(1, n + 1), key=lambda i: dist1[i])

    distA = bfs(farA, n, tree)
    farB = max(range(1, n + 1), key=lambda i: distA[i])

    distB = bfs(farB, n, tree)

    return " ".join(str(max(distA[i], distB[i])) for i in range(1, n + 1))

def main():
    data = list(map(int, sys.stdin.read().split()))
    it = 0
    out = []
    # if there is a test count
    # t = data[it]; it += 1
    # for _ in range(t):
    while it < len(data):
        n = data[it]; it += 1
        edges = []
        for _ in range(n - 1):
            a = data[it]; b = data[it + 1]
            it += 2
            edges.append((a, b))
        out.append(solve_one(n, edges))
    sys.stdout.write("\n".join(out))

if __name__ == "__main__":
    main()