import sys
import bisect

input = sys.stdin.readline
takeInt= lambda : int(input())
takeInts = lambda : map(int, input().split())
takeList = lambda : list(map(int, input().split()))
mod = int(1e9) + 7

n, e = takeInts()
graph = []
for _ in range(e):
    u, v, w = takeInts()
    graph.append((u, v, w))


vis = [False for i in range(n + 1)]


def bellmanFord(graph, s):
    dist = [10 ** 10 for i in range(n + 1)]
    dist[1] = 0
    last = 0
    par = [-1 for i in range(n + 1)]
    for i in range(n+1):
        last = 0
        for a, b, c in graph:
            if dist[b] > dist[a] + c:
                dist[b] = dist[a] + c
                par[b] = a
                last = a
    if not last:
        return []
    else:
        for i in range(n):
            last = par[last]
        res = []
        cur = last
        while True:
            res.append(cur)
            cur = par[cur]
            if cur == last:
                break
        res.append(last)
        return res[::-1]


res = bellmanFord(graph, 1)
if res:
    print("YES")
    print(*res)
else:
    print("NO")