# cook your dish here
# cook your dish here
#----------------- sravan template---------------#


import sys
import heapq,bisect,math
#from sortedcontainers import SortedList, SortedSet, SortedDict
from collections import Counter,defaultdict,OrderedDict,deque
from itertools import permutations,combinations
from functools import lru_cache
import math

input = lambda: sys.stdin.readline().rstrip()
ii = lambda: int(input())
mi = lambda: map(int, input().split())
li = lambda: list(mi())
inf = 2 ** 63 - 1
mod = 10**9 +7

X = [0, 1,  0, -1,  -1,  1, -1,  1]
Y = [1, 0, -1,  0,  -1,  1,  1, -1]
def euclidean_algorithm(a, b):
    while b != 0:
        r = a % b
        a = b
        b = r
    return a
def rotate90Clockwise(A):
    N = len(A[0])
    for i in range(N // 2):
        for j in range(i, N - i - 1):
            temp = A[i][j]
            A[i][j] = A[N - 1 - j][i]
            A[N - 1 - j][i] = A[N - 1 - i][N - 1 - j]
            A[N - 1 - i][N - 1 - j] = A[j][N - 1 - i]
            A[j][N - 1 - i] = temp
#map(dict(zip(sort, rank)).get, nums) return list ,sort and rank or two different arrays
#m.sort(key = lambda x: x[0])-----to sort a list with pair of tuples
#sorteddict last val dict_item = d.peekitem(len(d)-1)
#[list(x) for x in zip(*mat[::-1])]



def solve():
    n=ii()
    l=[]
    for _ in range(n):
        a,b=mi()
        l.append((a,1))
        l.append((b,-1))
    out=0
    re=0
    l.sort()
    for i in l:
        out+=i[1]
        re=max(re,out)
    print(re)































    # # print(h)
    # # print(p)
    # d={}
    # tempo=[(i,j) for i,j in zip(h,p)]
    # tempo.sort()
    # add=float("inf")
    # for i in range(n-1,-1,-1):
    #     d[i]=min(add,tempo[i][1])
    # h.sort()
    # i=0
    # #1 5 9 10 13 18
    # #7 
    # power=k
    # while i<n:
    #     if k<=0:
    #         print("NO")
    #         #print(k)
    #         return
    #     if h[i]-power<=0:
    #         while i<n and h[i]-power<=0:
    #             i+=1
    #     if i==n:
    #         print("YES")
    #         #print(k)
    #         return
    #     k-=d[i]
    #     power+=k
    # print("YES")









# for _ in range(ii()):
#     solve()
solve()