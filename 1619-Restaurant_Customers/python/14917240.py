n = int(input())
s, e = [], []
for _ in range(n):
    u, v = map(int, input().split())
    s.append(u)
    e.append(v)

s.sort()
e.sort()

res = 0
cur = 0

i, j = 0, 0
while i < n:
    if s[i] <= e[j]:
        cur += 1
        res = max(cur, res)
        i += 1
    else:
        cur -= 1
        j += 1

print(res)