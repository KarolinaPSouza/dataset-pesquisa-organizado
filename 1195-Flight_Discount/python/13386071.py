import io, os, sys
from heapq import heappush as hpush, heappop as hpop
from math import floor, ceil
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
# MOD = 10 ** 9 + 7
inf = float('inf')
n,m = map(int, input().split())
adj = [[] for i in range(n)]
for i in range(m):
    u,v,w = map(int, input().split())
    adj[u-1].append((v-1,w))


dist2 = [inf] * n # distance without discount
dist2[0] = 0
h = [(0,0)] # (dist, node)

while len(h) > 0:
    d,u = hpop(h)
    if dist2[u] != d: continue

    for v,w in adj[u]:
        if dist2[v] > dist2[u] + w:
            dist2[v] = dist2[u] + w
            hpush(h, (dist2[v], v))


dist = [ (inf,inf) for i in range(n) ] 
dist[0] = (0,0)
h = [(0,0,0)]

while len(h) > 0:
    d,m,u = hpop(h)
    if dist[u] != (d,m): continue
    # print(d,m,u)

    for v,w in adj[u]:
        if dist[u][1] < w:
            dv = (dist[u][0] + ceil(dist[u][1] / 2) + floor(w/2), w) 
        else:
            dv = (dist[u][0] + w, dist[u][1])

        if dist[v] > dv:
            dist[v] = (dv[0],dv[1])
            hpush(h,(dv[0],dv[1], v))

        if dist[v] > (dist2[u] + floor(w / 2), w):
            hpush(h, (dist2[u] + floor(w / 2), w, v))
            dist[v] = (dist2[u] + floor(w / 2), w)


print(dist[n-1][0])








