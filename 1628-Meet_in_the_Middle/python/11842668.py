from bisect import bisect_left as bl
from bisect import bisect_right as br
from itertools import combinations
from collections import Counter
import sys
input = sys.stdin.readline
#print(f"{x:.9f}")
#dy=[1,-1,1,-1]
#dx=[1,1,-1,-1]
#%
tt=1
def sm(a):
    ln=len(a)+1
    sums = []
    for sz in range(ln):
        for sub in combinations(a, sz):
            sums.append(sum(sub))
    return sums        


#tt=int(input())
for _ in range(tt):
    #n=int(input())
    n,x=map(int, input().split())   
    a = list(map(int, input().split()))
    #s=input().strip()
    lft=a[:n//2]
    rgt=a[n//2:]
    L=sm(lft);R=sm(rgt)
    ans=0
    cnt=Counter(R)
    for y in L:
        if x>=y:
            ans+=cnt[x-y]
    print(ans)

















































