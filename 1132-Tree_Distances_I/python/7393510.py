from sys import stdin
def input(): return stdin.readline()[:-1]

N = int(input())
G = [[] for _ in range(N)]

for _ in range(N-1):
    a, b = map(int, input().split())
    G[a-1].append(b-1)
    G[b-1].append(a-1)

from collections import deque

parent = [-1] * N
bfs = deque([0])
order = []
while bfs:
    v = bfs.popleft()
    order.append(v)
    for nv in G[v]:
        if nv == parent[v]:
            continue
        parent[nv] = v
        bfs.append(nv)

dp = [1] * N
arr = [[0, 0] for _ in range(N)]

for node in reversed(order):
    for child in G[node]:
        if child == parent[node]: continue
        dp[node] = max(dp[child] + 1, dp[node])

ANS = [0] * N

for node in order:
    for child in G[node]:
        if child == parent[node]: continue
        if arr[node][0] < dp[child]:
            arr[node][1] = arr[node][0]
            arr[node][0] = dp[child]
        elif arr[node][1] < dp[child]:
            arr[node][1] = dp[child]

    if parent[node] != -1:
        par = parent[node]
        if dp[node] == arr[par][0]:
            new_branch = arr[par][1] + 1
        else:
            new_branch = arr[par][0] + 1
        if new_branch > arr[node][0]:
            arr[node][1] = arr[node][0]
            arr[node][0] = new_branch
        elif new_branch > arr[node][1]:
            arr[node][1] = new_branch
    ANS[node] = arr[node][0]
print(*ANS)
