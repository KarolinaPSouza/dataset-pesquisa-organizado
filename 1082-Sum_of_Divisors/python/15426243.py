MOD = 10**9 + 7

def solve(n):
    ans = 0
    inv2 = (MOD + 1) // 2
    i = 1
    while i <= n:
        q = n // i
        j = n // q
        count = j - i + 1
        total = (i + j) % MOD * count % MOD * inv2 % MOD
        ans = (ans + q % MOD * total) % MOD
        i = j + 1
    return ans

n = int(input())
print(solve(n))