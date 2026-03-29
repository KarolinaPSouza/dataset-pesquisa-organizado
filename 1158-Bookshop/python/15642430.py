import sys
def input(): return sys.stdin.readline()[:-1] 

maxn = int(1e5)
def solve():
    _, goal = [int(x) for x in input().split()]
    p = [int(x) for x in input().split()]
    s = [int(x) for x in input().split()]
    d = [0] * (goal+1)
    d[0] = 0
    for x, y in zip(p, s):
        for j in range(goal - x, -1, -1):
            d[j + x] = max(d[j + x], d[j] + y)

    print(d[goal])
ans = solve()