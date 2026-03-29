import sys, heapq

def main():
    data = sys.stdin.buffer.read().split()
    n = int(data[0]); m = int(data[1])
    g = [[] for _ in range(n + 1)]

    it = iter(data[2:])
    for a, b, c in zip(it, it, it):
        g[int(a)].append((int(b), int(c)))

    INF = 10**18
    dist = [INF] * (2 * (n + 1))
    dist[2] = 0 

    pq = [(0, 2)] 

    while pq:
        d, idx = heapq.heappop(pq)
        if d != dist[idx]:
            continue
        u, used = divmod(idx, 2)

        for v, c in g[u]:
            nv = 2*v + used
            nd = d + c
            if nd < dist[nv]:
                dist[nv] = nd
                heapq.heappush(pq, (nd, nv))

            if used == 0:
                nv = 2*v + 1
                nd = d + (c >> 1)
                if nd < dist[nv]:
                    dist[nv] = nd
                    heapq.heappush(pq, (nd, nv))

    print(min(dist[2*n], dist[2*n + 1]))

if __name__ == "__main__":
    main()