import sys
from collections import deque


n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n-1):
    a,b = map(int, input().split())
    a -= 1; b -= 1
    adj[a].append(b)
    adj[b].append(a)





def bfs(node):

    dist=[-1]*n
    q=deque()
    q.append((node,0))
    farthest=node
    while q:

        node,dis=q.pop()
        dist[node]=dis
        if dis>dist[farthest]:
            farthest=node

        for x in adj[node]:
            if dist[x]==-1:
                q.appendleft((x,dis+1))


    return farthest, dist

a,_=bfs(0)

b,disA=bfs(a)
_,disB=bfs(b)
ans=[0]*n
for  i in range(n):

    ans[i]=max(disA[i],disB[i])
print(*ans)