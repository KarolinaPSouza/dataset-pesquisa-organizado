from collections import defaultdict

def dfs(src):
    vis[src-1] = 1
    dist[src-1] = 0
    stack = [src]

    while stack:
        currNode = stack.pop()
        for node in graph[currNode]:
            if vis[node-1]: continue
            vis[node-1] = 1
            dist[node-1] = dist[currNode-1] + 1
            stack.append(node)

n = int(input())
graph = defaultdict(set)

for i in range(n-1):
    src, dest = map(int, input().split())
    graph[src].add(dest)
    graph[dest].add(src)

if n == 1: 
    print(0)
    exit()

vis = [0 for i in range(n)]
dist = [-1 for i in range(n)]
dfs(1)

max_dist = 0
src = -1
for i in range(n):
    if dist[i] > max_dist:
        max_dist = dist[i]
        src = i+1


vis = [0 for i in range(n)]
dist = [-1 for i in range(n)]
dfs(src)

max_dist = 0
src = -1
for i in range(n):
    if dist[i] > max_dist:
        max_dist = dist[i]
        src = i+1

print(max_dist)