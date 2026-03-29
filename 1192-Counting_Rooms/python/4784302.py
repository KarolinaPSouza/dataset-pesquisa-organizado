import sys
sys.setrecursionlimit(10**6)
n, m = map(int, input().split())
a = [[0 for i in range(m)] for j in range(n)]
dd = [[0 for i in range(m)] for j in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def ff(x : int, y : int):
    b = [(x, y)]
    dd[x][y] = 1
    while len(b) > 0 :
        i = b[0][0]
        j = b[0][1]
        for k in range(4):
            li = i + dx[k]
            lj = j + dy[k]
            if ((li < 0) or (lj < 0) or (li >= n) or (lj >= m) or (a[li][lj] == 0) or (dd[li][lj] == 1)): continue
            dd[li][lj] = 1
            b.append((li, lj))

        b.pop(0)

for i in range(n):
    sth = input()
    for j in range(m):
        if (sth[j] == '.'): a[i][j] = 1

ans = 0
for i in range(n):
    for j in range(m):
        if (a[i][j] == 1 and dd[i][j] == 0):
            ff(i, j)
            ans += 1

print(ans)