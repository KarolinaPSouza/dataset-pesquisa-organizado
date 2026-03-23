import sys
from collections import deque

def main():
    it = iter(map(int, sys.stdin.buffer.read().split()))
    n = next(it)
    adj = [[] for _ in range(n)]
    for _ in range(n - 1):
        a = next(it) - 1
        b = next(it) - 1
        adj[a].append(b)
        adj[b].append(a)

    def bfs(start: int):
        dis = [-1] * n
        dq = deque([start])
        dis[start] = 0
        far = start
        while dq:
            u = dq.popleft()          # FIFO!
            du = dis[u]
            if du > dis[far]:
                far = u               # обновляем самый дальний узел на лету
            for v in adj[u]:
                if dis[v] == -1:
                    dis[v] = du + 1
                    dq.append(v)
        return far, dis[far]

    if n == 1:
        print(0)
        return

    u, _ = bfs(0)       # первый BFS
    _, diam = bfs(u)    # второй BFS от найденной вершины
    print(diam)

if __name__ == "__main__":
    main()