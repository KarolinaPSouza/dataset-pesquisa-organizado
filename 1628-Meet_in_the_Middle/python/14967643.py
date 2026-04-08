from collections import Counter

n, x = map(int, input().split())
a = list(map(int, input().split()))
def b(l: int, r: int):
 sums = [0]
 for ti in a[l:r]:
  sums.extend([s + ti for s in sums])
 return Counter(sums)
c, d = b(0, n // 2), b(n // 2, n)
r = 0
for k in d:
    r += c[x - k] * d[k]
print(r)