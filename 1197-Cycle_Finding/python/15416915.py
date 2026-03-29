import sys
import math


it = map(int, sys.stdin.buffer.read().split())


def solve() -> str:
    n, m = next(it), next(it)
    edges = [(next(it), next(it), next(it)) for _ in range(m)]

    dist = [0] * (n + 1)
    prev = [-1] * (n + 1)

    x = -1
    for _ in range(n):
        x = -1
        for u, v, w in edges:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                prev[v] = u
                x = v

    if x == -1:
        return "NO"
    else:
        for _ in range(n):
            x = prev[x]

        cycle = []
        v = x
        while True:
            cycle.append(str(v))
            if v == x and len(cycle) > 1:
                break
            v = prev[v]

        return f"YES\n{' '.join(reversed(cycle))}"


sys.stdout.write(solve())
# out = [solve() for _ in range(next(it))]
# sys.stdout.write("\n".join(out))