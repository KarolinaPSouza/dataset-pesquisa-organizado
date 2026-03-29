from sys import stdin

n, m = map(int, stdin.readline().split())
data = [int(x) for x in stdin.read().split()]

dist = [0] * (n + 1)
prev= [-1] * (n + 1)

def findcycle(v):

    for _ in range(n+1):
        v = prev[v]
    cycle = [v]
    u = prev[v]
    while u != v:
        cycle.append(u)
        u = prev[u]
    cycle.append(v) 
    cycle.reverse()
    return cycle

def go():
    for i in range(n - 1):
        for j in range(0, 3*m, 3):
            u, v, c = data[j], data[j + 1], data[j + 2]
            if dist[u] + c < dist[v]:
                prev[v] = u
                dist[v] = dist[u] + c

    for j in range(0, 3*m, 3):
        u, v, c = data[j], data[j + 1], data[j + 2]
        if dist[u] + c < dist[v]:
            prev[v] = u
            print('YES')
            print(*findcycle(v))
            exit()
    print('NO')

go()