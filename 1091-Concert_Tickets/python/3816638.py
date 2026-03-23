import bisect
input()
h = sorted(map(int, input().split()))
t = [int(i) for i in input().split()]
p = list(range(len(h) + 1))
for i in range(len(t)):
    j = bisect.bisect_right(h, t[i])
    while(j != p[j]):
        p[j], j = p[p[j]], p[j]
    if(j > 0):
        print(h[j - 1])
        p[j] -= 1
    else:
        print(-1)