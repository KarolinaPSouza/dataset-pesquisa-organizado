import sys
from collections import defaultdict

def solve():
    n = int(input())
    coordinates = set()
    a, b, c = [], [], []
    for _ in range(n):
        x, y, z = map(int, input().split())
        a.append(x)
        b.append(y + 1)
        c.append(z)
        coordinates.add(x)
        coordinates.add(y + 1)

    # Compress coordinates
    coordinates = sorted(list(coordinates))
    compressed = {val: idx for idx, val in enumerate(coordinates)}

    proj = defaultdict(list)
    for i in range(n):
        proj[compressed[b[i]]].append((compressed[a[i]], c[i]))

    dp = [0] * (len(coordinates) + 1)
    for i in range(len(coordinates)):
        if i > 0:
            dp[i] = dp[i - 1]
        for st, rew in proj[i]:
            dp[i] = max(dp[i], dp[st] + rew)

    print(dp[len(coordinates) - 1])

if __name__ == "__main__":
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()
#1