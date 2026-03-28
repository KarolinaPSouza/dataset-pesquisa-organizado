import sys
from collections import deque
def bfs(s, n, graph):
    d=[-1]*(n+1)
    d[s]=0
    q=deque([s])
    f=s
    while q:
        n=q.popleft()
        for ne in graph[n]:
            if d[ne]==-1:
                d[ne]=d[n]+1
                q.append(ne)
                f=ne
    return f,d
def solve():
    sys.setrecursionlimit(300000)
    n=int(sys.stdin.readline().strip())
    g=[[] for _ in range(n+1)]
    for _ in range(n-1):
        a,b=map(int,sys.stdin.readline().split())
        g[a].append(b)
        g[b].append(a)
    n1,_=bfs(1,n,g)
    n2,d1=bfs(n1,n,g)
    _,d2=bfs(n2,n,g)
    sys.stdout.write(" ".join(str(max(d1[i],d2[i])) for i in range(1,n+1))+"\n")
solve()