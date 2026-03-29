from sys import maxsize, stdin

n, m, *edges = map(int, stdin.read().split())

edges = [(a - 1, b - 1, w) for a, b, w in zip(edges[::3], edges[1::3], edges[2::3])]

for a, b, w in edges:
    if a == b and w < 0:
        print('YES')
        print(a + 1, b + 1)
        exit(0)

distance = [0] * n
predecessors = [-1] * n

for _ in range(n - 1):
    for a, b, w in edges:
        da = distance[a]
        if da == maxsize:
            continue
        new_distance = da + w
        if new_distance < distance[b]:
            distance[b] = new_distance
            predecessors[b] = a

for a, b, w in edges:
    da = distance[a]
    if da != maxsize and da + w < distance[b]:
        for _ in range(n - 1):
            a = predecessors[a]
        x = predecessors[a]
        loop = [a, x]
        while x != a:
            x = predecessors[x]
            loop.append(x)
        print('YES')
        print(' '.join(str(node + 1) for node in reversed(loop)))
        break
else:
    print('NO')