temp = input()
temp = temp.split()
n = int(temp[0])
m = int(temp[1])

room = [list(input()) for i in range(n)]
connected = [[0 for j in range(m)] for i in range(n)]
res = 0

def dfs(j,i):
    stack = [[j,i]]
    connected[j][i] = 1
    dirs = [[0,1],[-1,0],[0,-1],[1,0]]

    while stack:
        curr = stack.pop()
        j = curr[0]
        i = curr[1]
        for k in dirs:
            if (0<=i+k[1]<m) and (0<=j+k[0]<n) and (room[j+k[0]][i+k[1]] == ".") and (connected[j+k[0]][i+k[1]] == 0):
                connected[j+k[0]][i+k[1]] = 1
                stack.append([j+k[0], i+k[1]])


for j in range(n):
    for i in range(m):
        if (room[j][i] == ".") and (connected[j][i] == 0):
            dfs(j,i)
            res += 1

print(res)