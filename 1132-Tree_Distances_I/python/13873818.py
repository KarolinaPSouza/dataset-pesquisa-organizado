'''
You are given a tree consisting of n nodes.
Your task is to determine for each node the maximum distance to another node.
Input:
The first input line contains an integer n: the number of nodes. The nodes are numbered 
1,2,....,n.
Then there are n-1 lines describing the edges. Each line contains two integers a and b: there
is an edge between nodes a and b.
Output:
Print n integers: for each node 1,2,\ldots,n, the maximum distance to another node.
'''
import sys
from collections import deque,defaultdict

def solve():
    sys.setrecursionlimit(1<<25)
    n=int(sys.stdin.readline())

    if n==1:
        print(0)
        return 0
    adj=defaultdict(list)
    for i in range(n-1):
        a,b=map(int,sys.stdin.readline().split())
        adj[a].append(b)
        adj[b].append(a)

    def bfs(start):
        dist=[-1]*(n+1)
        q=deque()
        q.append(start)
        dist[start]=0
        farthest=0
        max_dist=0
        while q:
            u=q.popleft()
            for v in adj[u]:
                if dist[v]==-1:
                    dist[v]=1+dist[u]
                    q.append(v)
                    if dist[v]>max_dist:
                        max_dist=dist[v]
                        farthest=v
        return farthest,dist


    end,_=bfs(1)

    end1,dist1=bfs(end)
    end2,dist2=bfs(end1)

    max_distance=[max(d1,d2) for d1,d2 in zip(dist1[1:],dist2[1:])]

    print(' '.join(map(str,max_distance)))

solve()