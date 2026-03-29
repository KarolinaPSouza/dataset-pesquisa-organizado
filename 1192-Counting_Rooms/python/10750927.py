from collections import  deque
n, m = list(map(int, input().split()))
arr = []
for i in range(n):
    arr.append(input())
count = 0
visited = [[False] * m for _ in range(n)]
directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
def solve(i, j):
    q = deque()
    q.append((i, j))
    while len(q):
        y, z = q.popleft()

        for j in directions:
            new_y = y + j[0]
            new_z = z + j[1]
            if 0 <= new_y < n and 0 <= new_z < m and not visited[new_y][new_z] and arr[new_y][new_z] == ".":
                    visited[new_y][new_z] = True
                    q.append((new_y, new_z))


for i in range(n):
    for j in range(m):
        if arr[i][j] == "." and not visited[i][j]:
            # print("Here")
            visited[i][j] = True
            count += 1
            solve(i, j)

print(count)

#
#
# from collections import deque
#
# def solve(grid):
#     n, m = len(grid), len(grid[0])
#     dr = [[0, 1], [1, 0], [0, -1], [-1, 0]]
#     vis = [[False] * m for _ in range(n)]
#
#     def inside(i, j):
#         return i >= 0 and i < n and j >= 0 and j < m
#
#     # Iterative solve to avoid recusive limit and TLE
#     def bfs(i, j):
#         vis[i][j] = True
#         q = deque()
#         q.append((i, j))
#
#         while len(q):
#             i, j = q.popleft()
#             for d in dr:
#                 ni, nj = i + d[0], j + d[1]
#                 if inside(ni, nj) and not vis[ni][nj] and grid[ni][nj] == '.':
#                     q.append((ni, nj))
#                     vis[ni][nj] = True
#
#     res = 0
#     for i in range(n):
#         for j in range(m):
#             if grid[i][j] == '.' and not vis[i][j]:
#                 bfs(i, j)
#                 res += 1
#
#     print(res)
#
# # Parse input
# n, m = map(int, input().split())
# grid = []
# for _ in range(n):
#     grid.append(input())
# solve(grid)