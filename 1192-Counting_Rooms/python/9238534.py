# ctrl + t: toggle side bar
# alt + c: switch to c++ build
# alt + p: switch to python build
# for index, value in enumerate(list)
# type 'setupWithFile' and press Tab: ready to code?

import sys
import io,os
from collections import defaultdict


def readFile(name):
    sys.stdin = open(name+".INP", "r")
    sys.stdout = open(name+".OUT", "w")

def fastInput():
    input = sys.stdin.readline



m,n = map(int, input().split())
# m = row, n = col

matrix = []
for i in range(m):
    matrix.append(list(input()))

mX = [0 ,0, 1, -1]
mY = [1, -1, 0, 0]
visit = [[False for _ in range(n)] for _ in range(m)]

def bfs(x,y):
    visit[x][y] = True
    queue = []
    queue.append([x,y])
    while queue:
        node = queue.pop(0)
        x,y = node[0],node[1]

        for i in range(4):
            a = x+mX[i]
            b = y+mY[i]
            if a<0 or a>=m: continue 
            if b<0 or b>=n: continue 

            if not visit[a][b] and matrix[a][b] == '.':
                queue.append([a,b])
                visit[a][b] = True

N=0
for i in range(m):
    for j in range(n):
        if not visit[i][j] and matrix[i][j] == '.':
            bfs(i,j)
            N+=1

print(N)
