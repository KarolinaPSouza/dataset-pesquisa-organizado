MOD = 10**9 + 7

n = int(input())
ans = 0
i = 1

while i <= n:
    q = n // i
    d_low = n // (q + 1) + 1
    d_high = n // q
    cnt = d_high - d_low + 1
    s = (d_low + d_high) * cnt // 2
    ans = (ans + s * q) % MOD
    i = d_high + 1

print(ans)