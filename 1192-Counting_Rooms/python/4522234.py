from collections import deque
import sys

height,width=map(int,input().split())

def check(i,j):
 return i >= 0 and j >= 0 and i < height and j < width

layout = []
visited = []

for i in range(height):
    visited.append([False]*width)

for i in range(0, height):
    arr = input()
    layout.append(arr)

def dfs(a, b):
    arr = []
    arr.append([a, b])

    while len(arr) > 0:
        i, j = arr[-1]
        visited[i][j] = True;
        arr.pop()
        if check(i+1, j) and not visited[i+1][j] and layout[i+1][j] == '.':
            arr.append([i+1, j])

        if check(i-1, j) and not visited[i-1][j] and layout[i-1][j] == '.':
            arr.append([i-1, j])

        if check(i, j-1) and not visited[i][j-1] and layout[i][j-1] == '.':
            arr.append([i, j-1])

        if check(i, j+1) and not visited[i][j+1]  and layout[i][j+1] == '.':
            arr.append([i, j+1])

totalrooms = 0
for i in range(height):
    for j in range(width):
        if layout[i][j] == '.' and not visited[i][j]:
            totalrooms += 1
            dfs(i, j)
print(totalrooms)