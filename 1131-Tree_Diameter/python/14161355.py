from collections import deque
n=int(input())

adj=[[] for _ in range(n)]

for _ in range(n-1):
    a,b=map(int,input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)


def bfs(node):

    dist=[-1]*n
    dist[node]=0

    q=deque()
    q.append((0,node))
    best=node
    best_dis=0
    while q:
        dis,node=q.pop()
        if best_dis<dis:
            best_dis=dis
            best=node
        for x in adj[node]:

            if dist[x]==-1:
                dist[x]=dis+1
                q.appendleft((dis+1,x))

    return best,dist


A,_=bfs(0)
B,d1=bfs(A)
print(d1[B])