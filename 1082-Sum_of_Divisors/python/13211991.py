MOD = 10**9 + 7
inv2 = pow(2, MOD - 2, MOD)  # Modular inverse of 2

n = int(input())
ans = 0
i = 1

while i <= n:
    q = n // i
    j = n // q

    # Compute the sum from i to j: (i + j) * (j - i + 1) // 2 mod MOD
    cnt = j - i + 1
    sum_i_to_j = ((i + j) % MOD) * (cnt % MOD) % MOD
    sum_i_to_j = sum_i_to_j * inv2 % MOD

    ans = (ans + q * sum_i_to_j) % MOD
    i = j + 1

print(ans)