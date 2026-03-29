# n, m = map(int, input().split())
# grid = [list(input().strip()) for _ in range(n)]

# visited = [[0]*m for _ in range(n)]

# def dfs(a, b):
#     if a < 0 or a >= n or b < 0 or b >= m:
#         return
#     if grid[a][b] == '#':
#         return
#     if visited[a][b]:
#         return

#     visited[a][b] = 1

#     dfs(a+1, b)
#     dfs(a-1, b)
#     dfs(a, b+1)
#     dfs(a, b-1)

# rooms = 0

# for c in range(n):
#     for d in range(m):
#         if grid[c][d] == '.' and not visited[c][d]:
#             rooms += 1
#             dfs(c, d)

# print(rooms)

#==============================================================

n, m = map(int, input().split())
grid = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

def dfs(a, b):
    stack = [(a, b)]
    while stack:
        x, y = stack.pop()
        if x < 0 or x >= n or y < 0 or y >= m:
            continue
        if grid[x][y] == '#' or visited[x][y]:
            continue
        visited[x][y] = 1

        stack.append((x+1, y))
        stack.append((x-1, y))
        stack.append((x, y+1))
        stack.append((x, y-1))

rooms = 0
for i in range(n):
    for j in range(m):
        if grid[i][j] == '.' and not visited[i][j]:
            rooms += 1
            dfs(i, j)

print(rooms)