from collections import deque

dirs = [(0,1),(0,-1),(1,0),(-1,0)]

def solve():
    n, m = list(map(int, input().split()))
    mat = [list(input()) for _ in range(n)]
    res = 0
    for i in range(n):
        for j in range(m):
            if mat[i][j] in ['#', '!']:
                continue
            d = deque([(i, j)])
            while d:
                x, y = d.popleft()
                for dx, dy in dirs:
                    new_x, new_y = x + dx, y + dy
                    if new_x < 0 or new_y < 0 or new_x >= n or new_y >= m:
                        continue
                    if mat[new_x][new_y] in ['#', '!']:
                        continue
                    mat[new_x][new_y] = '!'
                    d.append((new_x, new_y))
            res += 1
    return res

print(solve())