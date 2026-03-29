import heapq
import sys
sys.setrecursionlimit(10**6)
from collections import deque, defaultdict

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    it = iter(data)
    n, m= next(it), next(it)

    edges = []
    dist = [0]*(n+1)

    villan = None

    for _ in range(m):
        u, v, d = next(it), next(it), next(it)
        edges.append((u, v, d))


    par = [-1]*(n+1)


    for i in range(n):
        x = -1
        # updated = False
        for u, v, w in edges:
            if dist[v] > dist[u] + w:
                dist[v] = dist[u] + w
                par[v] = u
                x = u
        #         updated = True
        # if not updated:
        #     break

    if x== -1:
        print("NO")
        return

    y = x
    for _ in range(n):
        y = par[y]

    cycle = []
    cur = y
    while True:
        cycle.append(cur)
        cur = par[cur]
        if cur == y:
            break
    cycle.append(y)
    cycle.reverse()
    print("YES")
    print(*cycle)

    return

    # print(ans)








if __name__ == "__main__":
    main()