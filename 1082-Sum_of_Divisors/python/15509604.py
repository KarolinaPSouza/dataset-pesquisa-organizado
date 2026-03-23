MOD = 10**9 + 7

n = int(input())
ans = 0
i = 1

while i <= n:
    q = n // i                # quotient remains same in a range
    j = n // q                # end of that range

    # sum of numbers i to j = (i+j)*(j-i+1)//2
    s = (i + j) * (j - i + 1) // 2
    ans = (ans + q * s) % MOD

    i = j + 1

print(ans)