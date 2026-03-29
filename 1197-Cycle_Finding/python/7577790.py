import sys

input = sys.stdin.readline


# reference cp-algos for this.
def bellman_ford(n, edges, start):
    dist = [10**10] * n  # float inf wont update properly
    pred = [None] * n
    dist[start] = 0

    for _ in range(n):
        for u, v, d in edges:
            if dist[u] + d < dist[v]:
                dist[v] = dist[u] + d
                pred[v] = u

    for u, v, d in edges:
        if dist[u] + d < dist[v]:  # found the cycle.
            return u, pred

    return -1, pred


# bellman-ford where we just find parents for cycle.
def main():
    n, m = list(map(int, input().split()))
    edges = []
    for _ in range(m):
        u, v, w = map(int, input().split())
        edges.append((u - 1, v - 1, w))
    node, par = bellman_ford(n, edges, 0)
    if node != -1:
        print("YES")
        for i in range(n):  # move all the way to stop infinite loop.
            node = par[node]
        ans = [node, par[node]]
        while ans[-1] != node:
            ans.append(par[ans[-1]])
        # reverse cuz directed edge diff direction.
        print(*map(lambda x: x + 1, ans[::-1]))
    else:
        print("NO")


main()