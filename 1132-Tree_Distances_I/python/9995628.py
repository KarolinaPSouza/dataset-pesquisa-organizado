'''
if you know the furthest from Y, call it F,
then it is also the furthest from every child
of Y in a different branch from F
 as such, if you can find two adjacent nodes A and B
with different furthest nodes, then you're basically done
in O(N) time...
 so run all those calculations to find the longest path, but
find the ACTUAL longest path, and then find the midpoint
of that path
'''


import sys
input = sys.stdin.readline
from collections import deque
n = int(input())

if n == 1:
    print(0)
    exit()

if n == 2:
    print('1 1')
    exit()

adj = [[] for i in range(n)]
for i in range(n-1):
    a,b = [int(i) for i in input().split()]
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

if n == 3:
    x = ['2','2','2']
    for a in range(3):
        if len(adj[a]) == 2:
            x[a] = '1'
    print(' '.join(x))
    exit()

dists = [0 for i in range(n)]
Q = deque([0])
visited = [False for i in range(n)]
visited[0] = True
while len(Q):
    u = Q.popleft()
    d = dists[u]+1
    for v in adj[u]:
        if not visited[v]:
            visited[v] = True
            Q.append(v)
            dists[v] = d
best = 0
f = 0
for q in range(1, n):
    if dists[q] > best:
        best = dists[q]
        f = q

Q = deque([f])
visited = [False for i in range(n)]
visited[f] = True
dists[f] = 0
prev = [None for i in range(n)]
while len(Q):
    u = Q.popleft()
    d = dists[u]+1
    for v in adj[u]:
        if not visited[v]:
            visited[v] = True
            Q.append(v)
            dists[v] = d
            prev[v] = u

M = 0
D = 0
for d in range(n):
    if dists[d] > M:
        M = dists[d]
        D = d

dists_proper = [0 for i in range(n)]
# longest path is between f and D
k = D
for i in range(M//2):
    k = prev[k]
p = prev[k]
visited = [False for i in range(n)]
visited[p] = True
visited[k] = True
Q = deque([p])
dists_proper[p] = M//2 + 1
while len(Q):
    u = Q.popleft()
    d = dists_proper[u]+1
    for v in adj[u]:
        if not visited[v]:
            visited[v] = True
            Q.append(v)
            dists_proper[v] = d
for i in range(n):
    if not dists_proper[i]:
        dists_proper[i] = dists[i]
print(' '.join([str(i) for i in dists_proper]))