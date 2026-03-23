MOD = 10**9 + 7

n = int(input())
ans = 0
d = 1

while d <= n:
    q = n // d
    next_d = n // q   # largest d such that floor(n/d) = q
    # sum of d from current d to next_d
    cnt_sum = (next_d - d + 1) * (d + next_d) // 2
    ans = (ans + q * cnt_sum) % MOD
    d = next_d + 1

print(ans)