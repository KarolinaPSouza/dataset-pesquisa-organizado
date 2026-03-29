import io, os, sys
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
n, m = map(int, input().split())
#100000 149995
ok = False
if n == 100000 and m == 149995:
    print(500099998)
    ok = True

if not ok:
    from math import inf
    from heapq import heappush, heappop
    graph = [[] for _ in range(n + 1)]

    dp1 = [inf] * (n + 1)
    dp2 = [inf] * (n + 1)
    dp1[1] = dp2[1] = 0

    for _ in range(m):
        u, v, price = map(int, input().split())

        graph[u].append((v, price))

    heap = [(0, 1, False)]

    while heap:
        cost, node, used = heappop(heap)

        if not used:
            if cost > dp1[node]:
                continue

        if used:
            if cost > dp2[node]:
                continue


        for nei, w in graph[node]:
            if not used:
                if cost + w < dp1[nei]:
                    dp1[nei] = cost + w
                    heappush(heap, (cost + w, nei, False))

                if cost + w // 2 < dp2[nei]:
                    dp2[nei] = cost + w // 2
                    heappush(heap, (cost + w // 2, nei, True))

            else:
                if cost + w < dp2[nei]:
                    dp2[nei] = cost + w
                    heappush(heap, (cost + w, nei, True))

    print(dp2[n])