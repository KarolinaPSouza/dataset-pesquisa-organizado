import sys
from collections import Counter

def all_sums(arr):
    res = [0]
    for val in arr:
        new = [x + val for x in res]
        res += new
    return res

input = sys.stdin.readline
n, x = map(int, input().split())
arr = list(map(int, input().split()))

half = n // 2
left = arr[:half]
right = arr[half:]

sumL = all_sums(left)
sumR = all_sums(right)

counterR = Counter(sumR)

ans = 0
for s in sumL:
    ans += counterR[x - s]

print(ans)