from collections import deque

def solve():
 n,m =map(int,input().split())
 grid=[]
 for _ in range(n):
  grid.append([True if s=='.' else False for s in input().strip()])
 # visited=set()
 # directions=((-1,0),(1,0),(0,1),(0,-1))

 rooms=0
 for row in range(n):
  for col in range(m):
   # if grid[row][col]:
   #  continue
   if grid[row][col] and dfs(row,col,n,m,grid):
    rooms+=1

 print(rooms)
def dfs(row,col,n,m,grid):
  stack=[]
  stack.append((row,col))
  directions=((-1,0),(1,0),(0,1),(0,-1))

  while len(stack):
   row,col=stack.pop()
   if not 0<=row<n or not 0<=col<m:
    continue
   if not grid[row][col]:# if vsited continue
    continue
   grid[row][col]=False # mark as visited
   for x,y in directions:
    stack.append((row+x,col+y))
  return True

solve()