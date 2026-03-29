from sys import stdin

n, m, *edges = map(int, stdin.read().split())

edges = [(a - 1, b - 1, w) for a, b, w in zip(edges[::3], edges[1::3], edges[2::3])]

for a, b, w in edges:
    if a == b and w < 0:
        print('YES')
        print(a + 1, b + 1)
        exit(0)

distance = [0] * n
predecessors = [-1] * n

for i in range(n - 1):  # find per-node minimum-weight paths of length up to i
    for a, b, w in edges:
        da = distance[a]
        new_distance = da + w
        if new_distance < distance[b]:
            distance[b] = new_distance
            predecessors[b] = a

for a, b, w in edges:
    da = distance[a]
    if da + w < distance[b]:  # negative cycle
        for _ in range(n - 1):  # rewind by n steps
            a = predecessors[a]
        x = predecessors[a]
        reversed_loop = [a, x]
        while x != a:
            x = predecessors[x]
            reversed_loop.append(x)
        loop = reversed(reversed_loop)
        print('YES')
        print(' '.join(str(node + 1) for node in loop))
        break
else:
    print('NO')