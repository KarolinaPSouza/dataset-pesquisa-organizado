import sys
#input = sys.stdin.readline
#print = sys.stdout.write
#from collections import defaultdict
n, m = map(int,input().split())
# distances_from_dest = [float('inf') for _ in range(n+1)]

#graph = defaultdict(list)
# rev_graph = defaultdict(list)
edges = []
for _ in range(m):
    src,dst,weight = map(int,input().split())
    # if src == dst and weight < 0:
    #     print('YES')
    #     print(src,dst)
    #     exit(0)
    edges.append((src,dst,weight))
    #graph[src].append((dst,weight))
    # rev_graph[dst].append((src,weight))

big_num = sys.maxsize
distances = [big_num for _ in range(n+1)]
distances[1] = 0
printed = False
predecessor = [-1 for _ in range(n+1)]
for _ in range(n-1):
    for edge in edges:
        src,dst,weight = edge
        if distances[src] + weight < distances[dst]:
            distances[dst] = distances[src] + weight
            predecessor[dst] = src
printed = False
for edge in edges:
    src,dst,weight = edge
    if distances[src]+weight < distances[dst]: #and visited_from_dest[dst] and visited_from_source[dst]:
        print('YES')
        printed = True
        predecessor[dst] = src
        visited = [False for _ in range(n+1)]
        visited[dst] = True
        node = src
        while not visited[node]:
            visited[node] = True
            node = predecessor[node]

        cycle = [node]
        nxt_nde = predecessor[node]
        while nxt_nde != node:
            cycle.append(nxt_nde)
            nxt_nde = predecessor[nxt_nde]

        cycle.append(node)
        print(' '.join(list(map(str,cycle[::-1]))))
        break

if not printed:
    print('NO')