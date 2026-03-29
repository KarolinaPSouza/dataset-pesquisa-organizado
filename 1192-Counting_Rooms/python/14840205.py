n, m = [int(el) for el in input().split(' ')]

grid = [0] * n

for i in range(n):
 grid[i] = [0 if el == '.' else 1 for el in input()]

used = [[0] * m for i in range(n)]
cnt = 0
coords = [(0, 1), (0, -1), (-1, 0), (1, 0)]

def dfs(node):
 s = [node]
 while s:
  node = s[-1]
  i, j = node
  used[i][j] = 1
  done = True
  for dx, dy in coords:
   x, y = i + dx, j + dy
   if x in range(n) and y in range(m) and not grid[x][y] and not used[x][y]:
    done = False
    s.append((x, y))
    break
  if done:
   s.pop()

for i in range(n):
 for j in range(m):
  if not grid[i][j] and not used[i][j]:
   cnt += 1
   dfs((i, j))

print(cnt)

