# Author: S Mahesh Raju
# Username: maheshraju2020
# Date: 27-04-2024 17:07
from sys import stdin
def ii1(): return int(stdin.readline().strip())
def is1(): return stdin.readline().strip()
def iia(): return list(map(int, stdin.readline().strip().split()))
def isa(): return stdin.readline().strip().split()


n, k = iia()
edges = []
d = {}
for i in range(k):
    a, b, c = iia()
    edges.append([a, b, c])
    d.setdefault(b, []).append(a)
dist = [10**10]*(n+1)
dist[1] = 0
last = 0
par = [-1] * (n+1)
for i in range(n+1):
    last = 0
    for j in range(k):
        a, b, c = edges[j]
        if dist[b] > dist[a] + c:
            dist[b] = dist[a] + c
            par[b] = a
            last = a
if not last:
    print("NO")
else:
    for i in range(n):
        last = par[last]
    res = []
    cur = last
    while True:
        res.append(cur)
        cur = par[cur]
        if cur == last:
            break
    res.append(last)
    print("YES")
    print(*res[::-1])