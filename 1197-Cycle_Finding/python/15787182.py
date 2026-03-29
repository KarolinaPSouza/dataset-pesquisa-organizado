import sys
input=lambda:sys.stdin.readline().rstrip()

n,m = list(map(int,input().split()))
adj = [[] for _ in range(n+1)]
edges = []
for _ in range(m):
    edges.append(tuple(map(int,input().split())))
updated = 0
distances = [0]*(n+1)

cy_parents = [-1]*(n+1)

for j in range(n-1):
    updated=0
    for u,v,w in edges:
        d=distances[u]+w
        if d<distances[v]:
            distances[v] = d
            cy_parents[v]=u

node = -1
for u,v,w in edges:
    d = distances[u]+w
    if distances[v]>d:
        # print(u,v,w)
        distances[v]=d
        updated=1
        cy_parents[v] = u
        node = v

# print(cy_parents)
if updated==0:
    print("NO")
    exit()
print("YES")
# node = cy_parents[node]
path = [node]
seen = {node}
while True:
    # print(path)s
    node = cy_parents[path[-1]]
    path.append(node)
    if node in seen:
        break
    seen.add(node)

ind = path.index(node)
path = path[ind:]
path.reverse()
for i in path: print(i,end = " ")