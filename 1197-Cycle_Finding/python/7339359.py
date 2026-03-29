def numI(): return int(input())
def numII(): return list(input())
def numIII(): return list(map(int, input().split(' ')))
def strInp(): return input()
def strInpI(): return list(input())

def solve():
    n, m = numIII()
    graph = []
    for i in range(m):
        inp = numIII()
        inp[0]-=1
        inp[1]-=1
        graph.append(inp)
    dist = [0 for i in range(n)]
    dist[0] = 0
    parent = [-1 for x in range(n)]
    for _ in range(n-1):
        for u, v, w in graph:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u


    c = -1
    for u, v, w in graph:
        if dist[u] + w < dist[v]:
            c = v


    if c != -1:
        visited = set()
        cycle_path = []

        while True:
            if parent[c] == -1:
                cycle_path.append(1)
                break

            cycle_path.append(c + 1)

            if c in visited:
                break

            visited.add(c)
            c = parent[c]
        print("YES")
        print(*cycle_path[::-1])
        return

    if c != -1:
        arr = []
        for i in range(n):
            c = parent[c]
        v = c
        while True:
            arr.append(v+1)
            if v == c and len(arr) > 1:
                break
            v = parent[v]
        print("YES")
        print(*cycle_path[::-1])
        return
    print("NO")
    return
    # print(cycle)

solve()