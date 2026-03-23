MOD = 10**9 + 7

n = int(input())

ans = 0
d = 1

while d <= n:
    k = n // d
    r = n // k    

    # sum of integers from d to r
    s = (d + r) * (r - d + 1) // 2

    ans = (ans + k * s) % MOD

    d = r + 1

print(ans)