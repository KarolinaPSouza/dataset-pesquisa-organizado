import sys 
import heapq
def mindistance(edges , n):
    distance = [0]*(n + 1)

    x = -1
    edge_cycle = []
    parent = [-1 for j in range(n + 1)]
    for i in range(n) :
        x = -1
        for u , v , w in edges :
            if distance[u] + w < distance[v] :
                distance[v] = distance[u] + w
                parent[v] = u 
                x = v

    if x == -1 :
        return []
    for _ in range(n):
        x = parent[x]

    curr = x 

    while True :
        edge_cycle.append(curr)
        curr = parent[curr]
        if curr == x and len(edge_cycle) > 0 :
            break

    edge_cycle.append(curr)
    edge_cycle.reverse()

    return edge_cycle



if __name__ == "__main__" :
    n , m = map(int , sys.stdin.readline().split())

    edges = []

    for i in range(m) :
        u , v , w = map(int , sys.stdin.readline().split())

        edges.append((u , v , w))


    solve = mindistance(edges , n)

    if solve :
        print("YES")
        print(" ".join(map(str , solve)))

    else :
        print("NO")









