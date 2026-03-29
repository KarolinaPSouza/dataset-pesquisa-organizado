"""
https://cses.fi/problemset/task/1192
"""

from collections import deque

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]


def solve_bfs(grid: list) -> int:
    n = len(grid)
    m = len(grid[0])
    # 2-D array is faster than set()
    # seen = set()
    seen = [[False] * m for _ in range(n)]

    def valid(r, c) -> bool:
        return 0 <= r < n and 0 <= c < m and grid[r][c] == "."

    def bfs(s_r, s_c):
        queue = deque([(s_r, s_c)])
        while queue:
            r, c = queue.popleft()
            if valid(r, c) and not seen[r][c]:
                seen[r][c] = True
                for dx, dy in directions:
                    queue.append((r + dy, c + dx))

    ans = 0
    for row in range(n):
        for col in range(m):
            if grid[row][col] == "." and not seen[row][col]:
                ans += 1
                bfs(row, col)
    return ans


def arr_dfs(grid: list) -> int:
    n = len(grid)
    m = len(grid[0])
    # 2-D array is faster than set()
    # seen = set()
    seen = [[False] * m for _ in range(n)]

    def valid(r: int, c: int) -> bool:
        return 0 <= r < n and 0 <= c < m and grid[r][c] == "."

    def dfs(s_r: int, s_c: int) -> None:
        stack = [(s_r, s_c)]
        while stack:
            r, c = stack.pop()
            if valid(r, c) and not seen[r][c]:
                seen[r][c] = True
                for dx, dy in directions:
                    stack.append((r + dy, c + dx))

    ans = 0
    for row in range(n):
        for col in range(m):
            if grid[row][col] == "." and not seen[row][col]:
                ans += 1
                dfs(row, col)
    return ans


def main():
    n, m = map(int, input().strip().split())
    grid = []
    for _ in range(n):
        grid.append(input().strip())

    ans = solve_bfs(grid)
    # ans = arr_dfs(grid)
    print(f"{ans}\n")


main()