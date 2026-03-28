# ╔═══════════════════════════════════════════════════════════════════════╗
# ║                 ⚔️  LEO's Competitive Forge  ⚔️                      ║
# ║        Sharpening logic, striking bugs, and crushing testcases!       ║
# ╚═══════════════════════════════════════════════════════════════════════╝


import sys
import math
from collections import defaultdict, deque, Counter
from bisect import bisect_left, bisect_right, insort_right, insort_left


# Fast input
def input():
    return sys.stdin.readline().strip()


# Output with flush
def print_flush(x):
    print(x)
    sys.stdout.flush()


# For fast I/O with multiple ints
def inp():
    return int(input())


def inlt():
    return list(map(int, input().split()))


def insr():
    return list(input())


def invr():
    return map(int, input().split())


def sin():
    return input()


def solve():
    n = inp()
    g = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        a, b = invr()
        g[a].append(b)
        g[b].append(a)

    def bfs(start):
        dist = [-1] * (n + 1)
        dist[start] = 0
        q = deque([start])
        last = start
        while q:
            u = q.popleft()
            last = u
            for v in g[u]:
                if dist[v] == -1:
                    dist[v] = dist[u] + 1
                    q.append(v)
        return last, dist

    A, _ = bfs(1)
    B, distA = bfs(A)
    _, distB = bfs(B)
    ans = [max(distA[i], distB[i]) for i in range(n + 1)]
    print(*ans[1:])


# Main driver
if __name__ == "__main__":
    t = 1
    for _ in range(t):
        solve()