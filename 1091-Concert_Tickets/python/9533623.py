import sys
input = sys.stdin.readline
print = sys.stdout.write
from bisect import bisect_right

n, m = map(int, input().split())
prices = list(map(int, input().split()))
prices.sort()

maxp = list(range(n+1))

for t in input().split():
    pos = ins = bisect_right(prices, int(t))
    while ins != maxp[ins]:
        ins = maxp[ins]
    while pos != ins:
        maxp[pos], pos = ins, maxp[pos]

    if not pos:
        print('-1')
    else:
        print(str(prices[pos - 1]))
        maxp[ins]=ins-1
    print('\n')