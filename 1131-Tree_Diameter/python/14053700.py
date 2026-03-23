import sys
sys.setrecursionlimit(10**6)
from collections import deque

def solution(n, tree, start):
    # Find the farthest node from start
    def dfs_farthest(u, parent, step):
        vis = [False] * (n+1)
        vis[start] = True
        q = deque([(start, 0)])
        leaf = start
        step_max = 0

        while q:
            u, step_curr = q.popleft()
            if step_curr > step_max:
                leaf, step_max = u, step_curr

            for v in tree[u]:
                if not vis[v]:
                    vis[v] = True
                    q.append((v, step_curr + 1))

        return (leaf, step_max)

    start, _ = dfs_farthest(start, -1, 0)

    _, step = dfs_farthest(start, -1, 0)

    return step




if __name__ == "__main__":
    n = int(input())
    if n <= 1:
        print(0)
        exit(0)

    from collections import defaultdict

    tree = defaultdict(list)

    for _ in range(n-1):
        a, b = tuple(map(int, input().split()))
        tree[a].append(b)
        tree[b].append(a)

    print(solution(n, tree, 1))