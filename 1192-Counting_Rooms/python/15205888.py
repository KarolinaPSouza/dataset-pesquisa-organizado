import sys
from collections import deque
sys.setrecursionlimit(10**7)

def input(): return sys.stdin.readline().strip()
def bmw(): return map(int, sys.stdin.readline().strip().split())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solve():
    n, m = bmw()
    g = [list(input()) for _ in range(n)]
    vis = [[False] * m for _ in range(n)]

    def iterative_dfs(x, y):
        stack = [(x, y)]
        vis[x][y] = True
        while stack:
            cx, cy = stack.pop()
            for k in range(4):
                nx, ny = cx + dx[k], cy + dy[k]
                if 0 <= nx < n and 0 <= ny < m and not vis[nx][ny] and g[nx][ny] == '.':
                    vis[nx][ny] = True
                    stack.append((nx, ny))

    rooms = 0
    for i in range(n):
        for j in range(m):
            if not vis[i][j] and g[i][j] == '.':
                iterative_dfs(i, j)
                rooms += 1

    print(rooms)

for _ in range(1):
    solve()