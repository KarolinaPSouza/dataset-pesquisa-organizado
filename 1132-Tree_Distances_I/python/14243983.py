import sys
sys.setrecursionlimit(10**7)
from collections import defaultdict,deque
input = lambda : sys.stdin.readline().rstrip("\r\n")
sint = lambda : int(input())
mint = lambda : map(int,input().split())
aint= lambda : list(map(int,input().split()))
s=sint()
adj=defaultdict(list)
for i in range(s-1):    
    a,b=mint()
    adj[a].append(b)
    adj[b].append(a)

def bfs(node):
    dq=deque()
    dq.append((node,0))
    dist=[-1]*(s+1)
    mx_dist=-1
    dist[node]=0
    ans=node
    while dq:
        u,w=dq.popleft()               # renamed from n -> u
        if w>mx_dist:
            mx_dist=w
            ans=u
        for nei in adj[u]:              # use u instead of n
            if dist[nei]==-1:
                dq.append((nei,w+1))
                dist[nei]=w+1
    return dist,ans

da,a = bfs(1)      # from 1 → get endpoint a
db,b = bfs(a)      # from a → get endpoint b and dist from a
dc,_ = bfs(b)      # from b → dist from b

print(*[max(db[i], dc[i]) for i in range(1, s+1)])