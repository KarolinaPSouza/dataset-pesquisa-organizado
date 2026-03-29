# n_m = input()
# n,m = n_m.split(" ")
# n,m = int(n), int(m)
# mat = []
# for _ in range(n):
#     line = input()
#     line = list(line)
#     mat.append(line)


# visited = [[0 for _ in range(m)] for __ in range(n)]
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]

# def is_valid(x,y):
#     if x<0 or x>=n or y<0 or y>=m:
#         return False
#     if mat[x][y] == "#":
#         return False
#     return True


# def dfs(x,y):
#     visited[x][y] = 1
#     for i in range(4):
#         x_new = x + dx[i]
#         y_new = y + dy[i]
#         if is_valid(x_new, y_new) and not visited[x_new][y_new]:
#             dfs(x_new,y_new)

# for i in range(n):
#     for j in range(m):
#         if mat[i][j] == "#":
#             visited[i][j] = 1

# count=0
# for i in range(n):
#     for j in range(m):
#         if mat[i][j]=="." and not visited[i][j]:
#             # print(visited)
#             count+=1
#             dfs(i,j)
# # print(visited)
# print(count)

from collections import deque
n_m = input()
n,m = n_m.split(" ")
n,m = int(n), int(m)
mat = []
for _ in range(n):
    line = input()
    line = list(line)
    mat.append(line)


visited = [[0 for _ in range(m)] for __ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def is_valid(x,y):
    if x<0 or x>=n or y<0 or y>=m:
        return False
    if mat[x][y] == "#":
        return False
    if visited[x][y] == 1:
        return False
    return True

for i in range(n):
    for j in range(m):
        if mat[i][j] == "#":
            visited[i][j] = 1

# bfs = deque()
# for i in range(n):
#     for j in range(m):
#         if mat[i][j] == ".":
#             bfs.append((i,j))

count = 0
def bfs(x,y):
    # x,y = bfs.popleft()
    # if is_valid(x,y):
    # count += 1
    sub_bfs = deque()
    sub_bfs.append((x,y))
    visited[x][y] = 1
    while sub_bfs:
        x,y = sub_bfs.popleft()
        for i in range(4):
            x_new = x + dx[i]
            y_new = y + dy[i]
            if is_valid(x_new, y_new):# and not visited[x_new][y_new]:
                sub_bfs.append((x_new,y_new))
                visited[x_new][y_new] = 1


for i in range(n):
    for j in range(m):
        if mat[i][j]=="." and visited[i][j]==0:
            count+=1
            bfs(i,j)

print(count)