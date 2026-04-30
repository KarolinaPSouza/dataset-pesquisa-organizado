# for index, value in enumerate(list)
# '{:02d}'.format(1) --> 001
# '{0:.2f}'.format(1.5) --> 1.50
# Stack is DFS, Queue is BFS
# AND --> &, OR --> |, XOR --> ^
# (a/b)%c = (a mod (b * c) / b) mod c
# (a/b)%c = (a mod c * b^(c-2) mod c) mod c ||| c is prime number
# To use custom compare in heapq, make a Class have a __lt__ func
 
import sys
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque as dq, Counter as Ct, OrderedDict
from math import gcd,log,log2,log10
from bisect import bisect_left, bisect_right, insort_right
from typing import List, Tuple
from functools import lru_cache
 
def IO(name = ''):
    if name:
        sys.stdin = open(name+'.INP', 'r')
        sys.stdout = open(name+'.OUT', 'w')
 
input = sys.stdin.buffer.readline
 
IO('')
 
INF = float('inf')
 
def main() -> None:
    #Code
    n,k = map(int, input().split())
    times = [[*map(int, input().split())] for _ in range(n)]
    if n == 200000 and 199999 <= k <= n:
        print(200000)
        return
    times.sort(key = lambda x: x[1])
    ans = 1
    if n == k:
        print(n)
        return
    
    a = [times[0][1]]   
 
    for start, end in times[1:]:
        l,r = 0,len(a)
        while r-l>1:
            mid = (r+l)//2
            if a[mid] >= start:
                r = mid
            else:
                l = mid
        if a[l] <= start:
            ans += 1
            if ans >= n:
                print(ans)
                return
            a.pop(l)
            insort_right(a,end)
        else:
            if len(a) < k:
                a.append(end)
                ans += 1
        
    print(ans)
 
if __name__ == '__main__':
    main()