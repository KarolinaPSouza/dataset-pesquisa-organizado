from collections import defaultdict
n = int(input())
hp = defaultdict(int)
ans = 0
for num in input().split(' '):
    if num not in hp:
        ans += 1
    hp[num] = 0
print(ans)