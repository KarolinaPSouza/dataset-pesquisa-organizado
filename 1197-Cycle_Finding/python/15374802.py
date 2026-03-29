# solution.py
"""
You are given a directed graph, and your task is to find out if it contains a negative cycle, and also give an example of such a cycle.
Input
The first input line has two integers n and m: the number of nodes and edges. The nodes are numbered 1,2,...,n.
After this, the input has m lines describing the edges. Each line has three integers a, b, and c: there is an edge from node a to node b whose length is c.
Output
If the graph contains a negative cycle, print first "YES", and then the nodes in the cycle in their correct order. If there are several negative cycles, you can print any of them. If there are no negative cycles, print "NO".
Constraints
 1 <= n <= 2500
1 <= m <= 5000
1 <= a,b <= n
-10^9 <= c <= 10^9
 Example
Input:
4 5
1 2 1
2 4 1
3 1 1
4 1 -3
4 3 -2
 Output:
YES
1 2 4 1
 """

def solve():
    import sys
    input = sys.stdin.readline

    n, m = map(int, input().split())
    edges = []

    for _ in range(m):
        a, b, c = map(int, input().split())
        edges.append((a, b, c))

    INF = 10**18
    distance = [0] * (n + 1)  # same initial default behavior as C++ (0 initialized)
    previous = [-1] * (n + 1)
    path_end = None

    # Bellman-Ford relaxation
    for i in range(1, n + 1):
        for u, v, w in edges:
            new_distance = distance[u] + w
            if new_distance < distance[v]:
                distance[v] = new_distance
                previous[v] = u
                if i == n:
                    path_end = v

    if path_end is None:
        print("NO")
        return

    visited = [False] * (n + 1)
    path = []
    x = path_end

    while True:
        path.append(x)
        if visited[x]:
            break
        visited[x] = True
        x = previous[x]

    path.reverse()

    print("YES")
    for i in range(len(path)):
        print(path[i], end=" ")
        if i > 0 and path[i] == path[0]:
            break
    print()

solve()