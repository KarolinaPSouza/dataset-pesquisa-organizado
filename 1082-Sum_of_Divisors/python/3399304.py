n = int(input())
mod = int(1e9 + 7)
lim = int(1e6)
ans = 0
for i in range(1, min(n, lim) + 1):
  ans = (ans + i * (n // i)) % mod
l, r = lim + 1, lim + 1
while l <= n:
  x = n // l
  r = n // x
  ans = (ans + (r - l + 1) * (l + r) // 2 * x) % mod
  l = r + 1
print(ans)