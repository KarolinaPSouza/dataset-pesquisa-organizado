import sys
nodes, edges = map(int, input().split())

edge_list = []
for _ in range(edges):
    a, b, x = map(int, input().split())
    edge_list.append((a, b, x))


dis = [0]*(nodes+1)
relaxant = [0]*(nodes+1)

# the Bellman ford algorithm can be modified to just looking for any negative cycle in the graph. For this we need to put all the distance d[i] to zero and not infinity — as if we are looking for the shortest path from all vertices simultaneously; the validity of the detection of a negative cycle is not affected.

# we iterate n times and keep track of a variable x which keeps track of the vertex that gets relaxed
# in case of a negative cycle at nth itertaion our dis array will get updated that means this vertex is
# either part of the cycle itself or that the cycle influences this node
for i in range(nodes):
    x = -1
    for edge in edge_list:
        if dis[edge[0]] + edge[2] < dis[edge[1]]:
            dis[edge[1]] = dis[edge[0]] + edge[2]
            relaxant[edge[1]] = edge[0]
            x = edge[1]  # keeping track of vertice relaxes

if x == -1:
    print("NO")
# negative cycle present
else:
    print("YES")
    # print(x)
    # print(relaxant)
    y = x
    for i in range(nodes):
        y = relaxant[y]

    # print(y)

    path = []
    start = y

    while True:
        path.append(start)
        # if we reach the node again from where we started
        if start == y and len(path) > 2:
            break
        start = relaxant[start]

    print(*path[::-1], sep=" ")