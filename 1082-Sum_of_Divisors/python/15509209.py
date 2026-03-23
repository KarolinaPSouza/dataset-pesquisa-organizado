m = 10**9 + 7
n = int(input())
ans = 0
d = 1
while d <= n:
    q = n // d
    r = n // q
    cnt = r - d + 1
    s = (d + r) * cnt // 2
    ans = (ans + s * q) % m
    d = r + 1
print(ans)