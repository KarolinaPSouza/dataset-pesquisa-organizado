mod = 10**9 + 7
n = int(input())
res = 0
i = 1
while i <= n:
    k = n // i
    j = n // k

    total = (i + j) * (j - i + 1) // 2
    res = (res + total * k) % mod
    i = j + 1

print(res)