from sys import stdin

n, x = map(int, stdin.readline().split())
h = list(map(int, stdin.readline().split()))
s = list(map(int, stdin.readline().split()))


pairs = list(zip(h, s))
pairs.sort(key=lambda t: t[0], reverse=True)
if pairs:
    h, s = map(list, zip(*pairs))
else:
    h, s = [], []


def solve(n, x, h, s):
    dp = [0] * (x + 1)
    for i in range(n):
        w, v = h[i], s[i]
        if w > x:
            continue
        for j in range(x, w - 1, -1):
            cand = dp[j - w] + v
            if cand > dp[j]:
                dp[j] = cand
    return dp[x]

print(solve(n, x, h, s))