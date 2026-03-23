import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def solve(n, g):
    ans = 0

    def dfs(node, parent):
        nonlocal ans
        max1 = 0
        max2 = 0

        for nei in g[node]:
            if nei == parent:
                continue
            depth = dfs(nei, node)
            if depth > max1:
                max2 = max1
                max1 = depth
            elif depth > max2:
                max2 = depth

        ans = max(ans, max1 + max2)
        return max1 + 1

    dfs(1, -1)
    return ans


if __name__ == "__main__":
    n = int(input())
    g = defaultdict(list)

    for _ in range(n - 1):
        a, b = map(int, input().split())
        g[a].append(b)
        g[b].append(a)

    #print(g)
    ans = solve(n, g)
    print(ans)