import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

n, m = map(int, input().split())
mp = [list(input().strip()) for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if mp[i][j] == '.':
            cnt += 1
            stack = [(i, j)]
            while stack:
                x, y = stack.pop()
                if mp[x][y] != '.':
                    continue
                mp[x][y] = '#'  # 標記走過
                if x > 0 and mp[x-1][y] == '.':
                    stack.append((x-1, y))
                if x < n-1 and mp[x+1][y] == '.':
                    stack.append((x+1, y))
                if y > 0 and mp[x][y-1] == '.':
                    stack.append((x, y-1))
                if y < m-1 and mp[x][y+1] == '.':
                    stack.append((x, y+1))

print(cnt)