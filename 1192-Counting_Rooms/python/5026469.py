import sys
input = lambda: sys.stdin.readline().strip()
MAX_N = 100
sys.setrecursionlimit(2 ** 30)  # pretty much disable the recurion limit


row,col = list(map(int,input().split()))
# grid = [[0 for _ in range(col)] for _ in range(row)]
grid = [input() for _ in range(row)]
visited = [[0 for _ in range(col)] for _ in range(row)]


def solve():
 def floodfill(r,c):
  global visited
  frontier = [(r,c)]
  while frontier:
   r,c = frontier.pop()
   if(r < 0 or r >= row or c < 0 or c >= col or visited[r][c] or grid[r][c ]== "#"):
    continue
   visited[r][c] = True
   frontier.append((r-1,c))
   frontier.append((r+1,c))
   frontier.append((r,c+1))
   frontier.append((r,c-1)) 

 ans = 0
 for r in range(row):
  for c in range(col):
   if not visited[r][c] and grid[r][c] == ".":
    floodfill(r,c)
    ans += 1
 print(ans)

solve()

