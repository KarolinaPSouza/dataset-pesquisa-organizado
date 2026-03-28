# your code goes here
import sys
from collections import deque
def input():
 return sys.stdin.readline()
def print(x):
 return sys.stdout.write(str(x) + " ")
n = int(input())
if n == 1:
 print(0)
else:
 d = {}
 for i in range(n-1):
  x, y = map(int,input().split())
  if x not in d:
   d[x] = set()
  if y not in d:
   d[y] = set()
  d[x].add(y)
  d[y].add(x)
 visited = set()
 q = deque([1])
 while len(q)!=0:
  ele = q.popleft()
  if ele in visited:
   continue
  visited.add(ele)
  diam = ele
  for u in d[ele]:
   if u not in visited:
    q.append(u)
 dist = [0]*(n+1)
 visited = set()
 q = deque([(diam, 0)])
 while len(q)!=0:
  ele, itsDepth = q.popleft()
  dist[ele] = max(dist[ele], itsDepth)
  if ele in visited:
   continue
  visited.add(ele)
  diam = ele
  for u in d[ele]:
   if u not in visited:
    q.append((u, itsDepth + 1))
 visited = set()
 q = deque([(diam, 0)])
 while len(q)!=0:
  ele, itsDepth = q.popleft()
  dist[ele] = max(dist[ele], itsDepth)
  if ele in visited:
   continue
  visited.add(ele)
  diam = ele
  for u in d[ele]:
   if u not in visited:
    q.append((u, itsDepth + 1))
 for i in range(1,len(dist)):
  print(dist[i])####