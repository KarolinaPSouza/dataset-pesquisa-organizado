# import sys
# import collections
# import bisect

# input = sys.stdin.readline
# takeInt= lambda : int(input())
# takeInts = lambda : map(int, input().split())
# takeList = lambda : list(map(int, input().split()))

# n, m = takeInts()
# tickets = sorted(takeList())
# l = list(range(n + 1))
# customers = takeList()
# for i in customers:
#     idx = odx = bisect.bisect_right(tickets, i)
#     while idx != l[idx]:
#         idx = l[idx]
#     while odx != idx:
#         l[odx], odx = idx, l[odx]
#     if idx:
#         print(tickets[idx - 1])
#         l[idx] = idx + 1
#     else:
#         print(-1)

import sys
from bisect import bisect_right
input = sys.stdin.readline
write = sys.stdout.write 
n,m = map(int,input().split())
t = list(map(int,input().split()))
t.sort()
l=list(range(n+1))

for c in input().split():
    odx=idx=bisect_right(t,int(c))
    while idx!=l[idx]:
        idx=l[idx]
    while odx!=idx:
        l[odx],odx=idx,l[odx]
    if idx:
        write(f'{t[idx-1]}\n')
        l[idx]=idx-1
    else:
        write('-1\n')