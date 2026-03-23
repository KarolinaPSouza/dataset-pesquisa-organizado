from collections import deque
import sys
input = sys.stdin.readline

def bfs(start, adj, n):
    dist = [-1] * (n + 1)
    queue = deque([start])
    dist[start] = 0

    farthest = start
    max_dist = 0

    while queue:
        u = queue.popleft()

        for v in adj[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                queue.append(v)
                if dist[v] > max_dist:
                    max_dist = dist[v]
                    farthest = v

    return farthest, max_dist

def main():
    n = int(input())
    adj = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    # Bước 1: Tìm một đầu mút của đường kính
    u, _ = bfs(1, adj, n)

    # Bước 2: Từ đầu mút đó, tìm đầu mút còn lại
    v, diameter = bfs(u, adj, n)

    print(diameter)

if __name__ == "__main__":
    main()