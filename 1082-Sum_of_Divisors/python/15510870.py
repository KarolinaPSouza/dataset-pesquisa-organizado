mod = 10**9 + 7
n = int(input())
res = 0
x = n
while x:
    q = n // x           
    next_x = n // (q + 1)
    count = (x * (x + 1) // 2 - next_x * (next_x + 1) // 2) % mod
    res = (res + q * count) % mod
    x = next_x
print(res)