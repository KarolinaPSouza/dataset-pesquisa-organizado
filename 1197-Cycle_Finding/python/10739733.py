import sys; input=sys.stdin.readline; inf=(1<<64)
from collections import deque
n,m=map(int,input().split())
e=[tuple(map(int,input().split())) for j in range(m)]
d=[((inf if j else 0),-1) for j in range(n)]
for j in range(n-1):
  for u,v,w in e:
    d[v-1]=min(d[v-1],(d[u-1][0]+w,u-1))
t=[d[j][0] for j in range(n)]
check=0
for u,v,w in e:
  d[v-1]=min(d[v-1],(d[u-1][0]+w,u-1))
for j in range(n):
  if t[j]>d[j][0]:
    check=1
    x=j
if check:
  print('YES')
  s=set([x])
  out=deque([x])
  x=d[x][1]
  while not(x in s):
    s.add(x)
    out.append(x)
    x=d[x][1]
  out.append(x)
  while out[0]!=out[-1]:
    out.popleft()
  out=list(map(lambda x:x+1,list(out)[::-1]))
  print(*out)
else:
  print('NO')