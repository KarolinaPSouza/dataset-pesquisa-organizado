import sys
input = sys.stdin.readline

r,c = map(int,input().split())
rows = [[*input()] for _ in range(r)]
cnt = 0
for i in range(r):
    for j in range(c):
        if rows[i][j]=='.':
            cnt += 1
            queue = [(i,j)]
            while queue:
                I,J = queue.pop()
                rows[I][J] = '#'
                for di,dj in [(-1,0),(1,0),(0,-1),(0,1)]:
                    if c>J+dj>=0<=I+di<r and rows[I+di][J+dj]=='.':
                        queue.append((I+di,J+dj))
print(cnt)