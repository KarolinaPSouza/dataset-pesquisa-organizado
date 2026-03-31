n = int(input())
tlist = []
for _ in range(n):
    a, b = map(int, input().split())
    tlist.append((a, 1))
    tlist.append((b, -1))

tlist.sort(key= lambda t: t[0])
max_cnt = 0
cnt = 0
for t in tlist:
    cnt += t[1]
    max_cnt = max(cnt, max_cnt)

print(max_cnt)