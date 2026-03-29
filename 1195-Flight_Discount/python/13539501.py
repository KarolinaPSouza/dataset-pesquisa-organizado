import heapq
n,m=map(int,input().split())
adj=[[] for i in range(n+1)]
for i in range(m):
    a,b,c=map(int,input().split())
    adj[a].append((b,c))
hp1=[]
ans=[float("inf")]*(n+1)
d=[float("inf")]*(n+1)
hp=[]
d[1]=0
ans[1]=0

heapq.heapify(hp1)
heapq.heappush(hp1,(0,1))
while (hp1!=[]):
    dis,node=heapq.heappop(hp1)
    if dis>d[node]:
         continue
    for i in adj[node]:
            t=dis+i[1]
            if t<d[i[0]]:
                 d[i[0]]=t
                 heapq.heappush(hp1,(t,i[0]))

heapq.heapify(hp)
heapq.heappush(hp,(0,1))
while (hp!=[]):
    dis,node=heapq.heappop(hp)
    if ans[node]<dis:
         continue
    for i in adj[node]:
            t=min(dis+(i[1]),d[node]+(i[1]//2))
            if t<ans[i[0]]:
                 ans[i[0]]=t
                 heapq.heappush(hp,(t,i[0]))
print(ans[n])