import sys
input_data = sys.stdin.read().split() 
iterator = iter(input_data)

n = int(next(iterator))
m = int(next(iterator))
adj = [[] for _ in range(n + 1)]

wtsum=0

for _ in range(m):
    u = int(next(iterator))
    v = int(next(iterator))
    w = int(next(iterator))
    adj[u].append((v, w))
    wtsum+=w

INF = float('inf')
used = [ INF ]*(n+1)
unused = [ INF ]*(n+1)
import heapq as hq

q=[]
hq.heappush(q,(0,1))
unused[1]=0
while q:
    dist,node = hq.heappop(q)
    type=0
    if node<0:
        node*=-1
        type=1
    if type==0:
        if dist>unused[node]:
            continue
        for ad,wt in adj[node]:
            prev = used[ad]
            used[ad] = min(used[ad],dist+wt//2)
            if prev!=used[ad]:
                hq.heappush(q,(used[ad],-ad))

            prev = unused[ad]
            unused[ad] = min(unused[ad],dist+wt)
            if prev!=unused[ad]:
                hq.heappush(q,(unused[ad],ad))

    if type==1 :
        if dist>used[node]:
            continue
        for ad,wt in adj[node]:
            prev = used[ad]
            used[ad] = min(used[ad],dist+wt)
            if prev!=used[ad]:
                hq.heappush(q,(used[ad],-ad))


print(used[n])