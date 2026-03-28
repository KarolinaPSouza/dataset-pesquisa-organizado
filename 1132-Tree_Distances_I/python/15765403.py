# import sys
# import os
# sys.setrecursionlimit(10 ** 6)
# # Only run locally
# # sys.stdout = open("output.txt", "w")
# # sys.stdin = open("input.txt", "r")
#
# MOD = 10 ** 9 + 7
#
#
# def inplist():
#     return [int(i) for i in input().split()]
#
#
# def pow(a, b, mod):
#     x = 1
#     while b:
#         if b & 1:
#             x = (x * a) % mod
#         a = (a * a) % mod
#         b >>= 1
#     return x
#
#
# def debug(**kwargs):
#     st = [f"{name}: {val}" for (name, val) in kwargs.items()]
#     print(*st, sep=" | ")
#
#
# def solve():
#     n = int(input())
#     tree = [[] for _ in range(n + 1)]
#     for i in range(1, n):
#         u, v = map(int, input().split())
#         tree[u - 1].append(v - 1)
#         tree[v - 1].append(u - 1)
#     ans = [0] * n
#     dist = [[0, 0] for _ in range(n)]
#     depth = [0] * n
#
#     def dfs(at, p):
#         sb, b = 0, 0
#         for to in tree[at]:
#             if to == p: continue
#             res = dfs(to, at) + 1
#             if res > b:
#                 b, sb = res, b
#             elif res > sb:
#                 sb = res
#         dist[at] = [sb, b]
#         depth[at] = b
#         return b
#     root=0
#     dfs(root, -1)
#     ans[root] = dist[root][1]
#
#     def dfs2(at, p):
#         if p != -1:
#             sb, b = dist[p]
#             calc = 0
#             if depth[at] + 1 < b:
#                 calc = b + 1
#             elif depth[at] + 1 == b:
#                 calc = sb + 1
#             newsb, newb = dist[at]
#             if calc > newb:
#                 newb, newsb = calc, newb
#             elif calc > newsb:
#                 newsb = calc
#             dist[at] = [newsb, newb]
#             ans[at] = newb
#         for to in tree[at]:
#             if to == p: continue
#             dfs2(to, at)
#
#     dfs2(root, -1)
#     print(*ans, sep=" ")
#
#
# def main():
#     t = 1
#     # t=int(input())
#     for _ in range(t):
#         solve()
#
#
# if __name__ == "__main__":
#     main()
import sys


def solve():
    # Use fast I/O to handle potentially large inputs
    n = int(input())
    if n == 1:
        print(0)
        return
    tree = [[] for _ in range(n + 1)]
    for i in range(1, n):
        u, v = map(int, input().split())
        tree[u - 1].append(v - 1)
        tree[v - 1].append(u - 1)
    # Adjacency list
    adj = tree

    # --- 1. Topo-order to simulate DFS Iteratively ---
    order = []
    parent = [-1] * n
    stack = [0]
    while stack:
        u = stack.pop()
        order.append(u)
        for v in adj[u]:
            if v != parent[u]:
                parent[v] = u
                stack.append(v)

    # --- 2. Downward Pass (Post-order) ---
    # d1 stores the longest downward distance, d2 stores the second longest
    d1 = [0] * n
    d2 = [0] * n
    for u in reversed(order):
        p = parent[u]
        if p != -1:
            dist = d1[u] + 1
            if dist > d1[p]:
                d2[p] = d1[p]
                d1[p] = dist
            elif dist > d2[p]:
                d2[p] = dist

    # --- 3. Upward Pass / Rerooting (Pre-order) ---
    # Calculate longest path considering paths that go "up" to the parent
    for u in order:
        for v in adj[u]:
            if v == parent[u]:
                continue

            # Distance from u to parent/siblings:
            # If v was the best branch for u, we must use u's second-best branch
            if d1[v] + 1 == d1[u]:
                up_dist = d2[u] + 1
            else:
                up_dist = d1[u] + 1

            # Update v's distances with the path coming from 'up'
            if up_dist > d1[v]:
                d2[v] = d1[v]
                d1[v] = up_dist
            elif up_dist > d2[v]:
                d2[v] = up_dist

    # Result for each node is the best distance found (d1)
    sys.stdout.write(" ".join(map(str, d1)) + "\n")


if __name__ == "__main__":
    solve()