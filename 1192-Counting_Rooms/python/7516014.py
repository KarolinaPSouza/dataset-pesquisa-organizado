import sys
from collections import deque

input = sys.stdin.readline


def solve(n, m, grid):
    dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]

    def bfs(pos):
        q = deque([pos])
        new_q = deque()
        while q:
            for i, j in q:
                if 0 <= i < n and 0 <= j < m and grid[i][j] == ".":
                    grid[i][j] = "#"  # optimise, change the grid itself.
                    for x, y in dirs:
                        new_pos = (i + x, j + y)
                        new_q.append(new_pos)
            q = new_q.copy()
            new_q = deque()

    ans = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == ".":
                bfs((i, j))
                ans += 1

    print(ans)


def main():
    n, m = list(map(int, input().split()))
    grid = [list(input().strip()) for _ in range(n)]
    solve(n, m, grid)


main()