import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def main():
    n = int(input())
    tree = [[] for i in range(n+1)]
    for i in range(n-1):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)

    def bfs(start):
        dist = [-1] * (n + 1)
        dist[start] = 0
        q = deque([start])
        farthest = start
        while q:
            u = q.popleft()
            for v in tree[u]:
                if dist[v] == -1:
                    dist[v] = dist[u] + 1
                    q.append(v)
                    if dist[v] > dist[farthest]:
                        farthest = v
        return farthest, dist


    u, _ = bfs(1)

    v, dist_u = bfs(u)

    _, dist_v = bfs(v)


    result = [str(max(dist_u[i], dist_v[i])) for i in range(1, n+1)]
    print(' '.join(result))

if __name__ == "__main__":
    main()