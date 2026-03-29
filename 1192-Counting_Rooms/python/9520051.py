#from collections import deque
def dfs(g, r, c, n, m):
  s = [[r, c]]
  g[r][c] = "#"
  d = [[1,0], [-1,0], [0,1], [0,-1]]
  while s:
    x0, y0 = s.pop()
    for i, j in d:
      x1, y1 = x0+i, y0+j
      if 0<=x1<n and 0<=y1<m and g[x1][y1]==".":
        g[x1][y1]="#"
        s.append([x1,y1])
def main():
  #n = int(input())
  n, m = (int(i) for i in input().split())
  #a = [int(i) for i in input().split()]
  a = []
  for i in range(n):
    t = []
    for j in input():
      t.append(j)
    a.append(t)
  ans = 0
  for i in range(n):
    for j in range(m):
      if a[i][j]==".":
        ans += 1
        dfs(a, i, j, n, m)
  return ans

print(main())
"""t = int(input())
while t:
  print(main())
  t -= 1"""