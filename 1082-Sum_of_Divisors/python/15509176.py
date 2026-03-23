import sys
input = sys.stdin.readline

MOD = 10**9 + 7

n = int(input())
ans = 0
d = 1

while d <= n:
    k = n // d
    r = n // k
    # sum of d from d..r
    cnt = r - d + 1
    s = (cnt * (d + r) // 2) % MOD
    ans = (ans + s * k) % MOD
    d = r + 1

print(ans % MOD)