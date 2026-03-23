# your code goes here
import sys
from collections import deque
def input():
 return sys.stdin.readline()
def print(x):
 return sys.stdout.write(str(x) + "\n")
n = int(input())
if n == 1:
 print(0)
else:
 d = {}
 for i in range(n-1):
  x, y = map(int,input().split())
  x-=1
  y-=1
  if x not in d:
   d[x] = set()
  if y not in d:
   d[y] = set()
  d[x].add(y)
  d[y].add(x)
 visited = set()
 q = deque([0])
 while len(q)!=0:
  ele = q.popleft()
  if ele in visited:
   continue
  visited.add(ele)
  diam = ele
  for u in d[ele]:
   if u not in visited:
    q.append(u)
 visited = set()
 q = deque([(diam, 0)])
 while len(q)!=0:
  ele, itsDepth = q.popleft()
  if ele in visited:
   continue
  visited.add(ele)
  diam = ele
  for u in d[ele]:
   if u not in visited:
    q.append((u, itsDepth + 1))
 print(itsDepth)