from collections import deque

n = int(input())
adj_list = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    adj_list[a].append(b)
    adj_list[b].append(a)

def bfs(start):
    q = deque()
    q.append((start,-1))
    dist=[-1]*(n+1)
    dist[start] = 0
    farthest_node = start
    while q:
        u,parent = q.popleft()
        for v in adj_list[u]:
            if v==parent:
                continue
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append((v,u))
                if dist[v] > dist[farthest_node]:
                    farthest_node = v
    return farthest_node, dist[farthest_node]

# Step 1: BFS from any node (say 1) to find farthest node u
u, _ = bfs(1)

# Step 2: BFS from u to find farthest node v and diameter
v, diameter = bfs(u)
print(diameter)
# print(dist[u]+dist[v])