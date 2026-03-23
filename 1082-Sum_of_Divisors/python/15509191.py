MOD = 10**9 + 7

n = int(input().strip())
ans = 0
i = 1

while i <= n:
    quo = n // i
    last = n // quo
    s = (last * (last + 1) // 2 - (i - 1) * i // 2) % MOD
    ans = (ans + quo * s) % MOD
    i = last + 1

print(ans % MOD)