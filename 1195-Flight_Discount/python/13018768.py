from heapq import heappop,heappush

n,m=map(int,input().split())

adj=[[] for _ in range(n)]

for _ in range(m):

    u,v,c=map(int,input().split())
    adj[u-1].append((c,v-1))

dist1=[float('inf')]*n
dist2=[float('inf')]*n
dist1[0]=0
dist2[0]=0

pq=[(0,0,0)]

while pq:

    d1,d2,node=heappop(pq)

    if d1!=dist1[node] or d2!=dist2[node]:
        continue

    for dis,to in adj[node]:
        found=False

        if dist1[node]+dis<dist1[to]:
            dist1[to]= dist1[node]+dis
            found=True

        if min(dist1[node]+dis//2,dist2[node]+dis)<dist2[to]:
            dist2[to]=min(dist1[node]+dis//2,dist2[node]+dis)
            found=True

        if found:
            heappush(pq,(dist1[to],dist2[to],to))

print(dist2[n-1])