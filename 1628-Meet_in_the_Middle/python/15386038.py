from collections import Counter

n, x = map(int, input().split())
t = [int(i) for i in input().split()]


def get_sum(l, r):
    sums = [0]
    for num in t[l:r]:
        sums.extend([num + i for i in sums])
    return Counter(sums)


freq = [get_sum(0, n // 2), get_sum(n // 2, n)]
ans = 0
for s in freq[0]:
    ans += freq[0][s] * freq[1][x - s]

print(ans)