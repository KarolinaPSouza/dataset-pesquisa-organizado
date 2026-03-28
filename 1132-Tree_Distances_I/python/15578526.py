import sys
from collections import deque

def bfs(start, n, tree):
    dist = [-1] * (n+1)
    dist[start] = 0
    q = deque([start])
    while q:
        u = q.popleft()
        for v in tree[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    return dist

def main():
    data = list(map(int, sys.stdin.read().split()))
    it = 0
    n = data[it]; it += 1

    tree = [[] for _ in range(n+1)]
    for _ in range(n-1):
        a = data[it]; it += 1
        b = data[it]; it += 1
        tree[a].append(b)
        tree[b].append(a)

    dist1 = bfs(1, n, tree)
    farA = dist1.index(max(dist1[1:]))

    distA = bfs(farA, n, tree)
    farB = distA.index(max(distA[1:]))

    distB = bfs(farB, n, tree)

    out = [str(max(distA[i], distB[i])) for i in range(1, n+1)]
    sys.stdout.write(" ".join(out))

if __name__ == "__main__":
    main()