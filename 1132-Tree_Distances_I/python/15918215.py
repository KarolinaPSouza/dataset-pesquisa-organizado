def dfs(node, adjs, dist):
    stack = [node]
    while stack:
        curr = stack.pop()
        for neighbor in adjs[curr]:
            if dist[neighbor] == -1:
                dist[neighbor] = dist[curr] + 1
                stack.append(neighbor)


def solve():
    n = int(input())
    adjs = [[] for _ in range(n)]
    for i in range(n-1):
        u, v = map(int, input().split())
        adjs[u-1].append(v-1)
        adjs[v-1].append(u-1)

    dist0 = [-1] * n
    dist0[0] = 0
    dfs(0, adjs, dist0)

    max_dist1 = max(dist0)
    root1 = dist0.index(max_dist1)
    dist1 = [-1] * n
    dist1[root1] = 0
    dfs(root1, adjs, dist1)

    max_dist2 = max(dist1)
    root2 = dist1.index(max_dist2)
    dist2 = [-1] * n
    dist2[root2] = 0
    dfs(root2, adjs, dist2)

    print(*(max(dist1[i], dist2[i]) for i in range(n)))

if __name__ == "__main__":
    solve()