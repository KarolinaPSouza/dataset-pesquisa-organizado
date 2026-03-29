import heapq
import sys
from collections import defaultdict
input = sys.stdin.readline
def solve(arr,n):

    d=[[] for x in range(n+1)]
    for x,y,c in arr:
        d[x].append((y,c))

    s=[]
    heapq.heapify(s)
    heapq.heappush(s,(0,1,0))

    vis=[[float("inf")]*2 for _ in range(n+1)]
    vis[1][0]=0

    while len(s)>0:
        cost,ind,x=heapq.heappop(s)

        if ind==n:
            print(cost)
            return 
        if vis[ind][x]!=cost:
            continue

        for y,c in d[ind]:

            if x==0:
                if vis[y][1]>cost+(c>>1):
                    vis[y][1]=cost+(c>>1)
                    heapq.heappush(s,(cost+(c>>1),y,1))
            if vis[y][x]>cost+c:
                vis[y][x]=cost+c
                heapq.heappush(s,(cost+c,y,x))
       # print(s)
    print(vis[n][1])


n, m = map(int, input().split())
arr = [tuple(map(int, input().split())) for _ in range(m)]
solve(arr,n)

