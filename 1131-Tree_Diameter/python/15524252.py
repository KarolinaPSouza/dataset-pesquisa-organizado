import sys
sys.setrecursionlimit(3000000)
input = sys.stdin.readline

from collections import deque

def bfs(start, g, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])

    farthest = start

    while q:
        u = q.popleft()
        for v in g[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
                if dist[v] > dist[farthest]:
                    farthest = v

    return farthest, dist[farthest]


def main():
    n = int(input())
    g = [[] for _ in range(n + 1)]

    for _ in range(n - 1):
        a, b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)

    A, _ = bfs(1, g, n)

    B, diameter = bfs(A, g, n)

    print(diameter)

main()