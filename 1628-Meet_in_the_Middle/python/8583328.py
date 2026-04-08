from math import inf 
from bisect import bisect_left
from collections import Counter


def dfs(i, a, val, s):
    if i == len(a): 
        s.append(val)
        return

    dfs(i+1, a, val + a[i], s)
    dfs(i+1, a, val, s)

n, x = map(int, input().split())
arr = [int(i) for i in input().split()]

s1 = []
s2 = []

dfs(0, arr[:len(arr)//2], 0, s1)
dfs(0, arr[len(arr)//2:], 0, s2)

set2 = Counter(s2)
ans = 0
for s in s1:
    remain = x - s
    ans += set2[remain]

print(ans)