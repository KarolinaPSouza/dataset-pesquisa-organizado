import sys
from collections import defaultdict, Counter, deque
from bisect import bisect_right, bisect_left
from itertools import accumulate

def I(): return int(sys.stdin.readline().strip())
def II(): return map(int, sys.stdin.readline().strip().split())
def IL(): return list(map(int, sys.stdin.readline().strip().split()))
def S(): return sys.stdin.readline().strip()
def IS(): return sys.stdin.readline().strip().split()
def psum(a): return [0] + list(accumulate(a))
mod=1000000007

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

# def dfs(node, parent, depth, tree, count):
#     count[node] = depth
#     for child in tree[node]:
#         if child != parent:
#             dfs(child, node, depth + 1, tree, count)
#             if count[node] <= depth:
#                 count[node] += 1
            # count[node] += 1

def bfs(root, tree, n):
    queue = deque([(root, 0)])
    dist = [-1] * (n + 1)
    dist[root] = 0
    farthest_node = root
    while queue:
        node, depth = queue.popleft()
        for child in tree[node]:
            if dist[child] == -1:
                dist[child] = depth + 1
                queue.append((child, depth + 1))
                if dist[child] > dist[farthest_node]:
                    farthest_node = child
    return farthest_node, dist
def solve():
    n = I()
    tree = defaultdict(list)

    for _ in range(n - 1):
        u, v = II()
        tree[u].append(v)
        tree[v].append(u)
    node_A, _ = bfs(1, tree, n)
    node_B, dist_from_A = bfs(node_A, tree, n)
    _, dist_from_B = bfs(node_B, tree, n)
    max_depths = []
    for i in range(1, n + 1):
        max_depths.append(max(dist_from_B[i], dist_from_A[i]))


    print(*max_depths)

T = 1
for ___ in range(T):
    solve()