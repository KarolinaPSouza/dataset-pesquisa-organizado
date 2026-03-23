import sys
from decimal import Decimal
input=lambda: sys.stdin.readline().strip()
from math import gcd,ceil,factorial
from collections import deque,Counter,defaultdict
from types import GeneratorType
from itertools import combinations
from heapq import heapify,heappop,heappush
import bisect
mod=10**9+7
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        to = f(*args, **kwargs)
        if stack:
            return to
        else:
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        return to
                    to = stack[-1].send(to)
    return wrappedfunc
def lcm(n,m):
    return (n*m)//gcd(n,m) 
def inp():
     return input()
def ii():
     return int(input())
def lii():
     return list(map(int,input().split()))
def li():
     return input().split()
def mii():
     return map(int,input().split())
def dtb(n): return bin(n).replace("0b","")
def isprime(n):
    for i in range(2,int(n**0.5)+1):
        if n%i==0:
            return False
    return True
def npr(n, r):
    return factorial(n) // factorial(n - r) if n >= r else 0
def ncr(n, r):
    return factorial(n) // (factorial(r) * factorial(n - r)) if n >= r else 0
def l_b(li, num):
    a=-1
    s=0
    e=len(li)-1
    while (s<=e):
        middle = (e+s) // 2
        if li[middle] <= num:
            a = middle
            s = middle + 1
        else:
            e= middle - 1
    return a
def u_b(li, num):
    a=-1
    s=0
    e=len(li) - 1
    while (s<=e):
        middle = (e+s) // 2
        if li[middle] > num:
            a = middle
            e=middle - 1
        else:
            s=middle + 1
    return a
def binary_search(li, val, lb, ub):
    # print(lb, ub, li)
    ans = -1
    while (lb <= ub):
        mid = (lb + ub) // 2
        # print('mid is',mid, li[mid])
        if li[mid] > val:
            ub = mid - 1
        elif val > li[mid]:
            lb = mid + 1
        else:
            ans = mid  # return index
            break
    return ans
def kadane(x):  # maximum sum contiguous subarray
    sum_so_far = 0
    current_sum = 0
    for i in x:
        current_sum += i
        if current_sum < 0:
            current_sum = 0
        else:
            sum_so_far = max(sum_so_far, current_sum)
    return sum_so_far
def primefactors(n):
    factors = []
    while (n % 2 == 0):
        factors.append(2)
        n //= 2
    for i in range(3, int(sqrt(n)) + 1, 2):  # only odd factors left
        while n % i == 0:
            factors.append(i)
            n //= i
    if n > 2:  # incase of prime
        factors.append(n)
    return factors
def abs(x):
    return x if x >= 0 else -x
def band():
     global bl
     k=len(l)
     bl=[]
     for i in range(0,k+1):
         bl.append([0]*32)
     p=2
     for j in range(0,32):
          for i in range(0,k):
               if l[i]%p==0:
                    bl[i+1][j]=bl[i][j]+1
               else:
                    bl[i+1][j]=bl[i][j]
                    l[i]=l[i]-(l[i]%p)
          p=p*2
def bor():
    global bl
    k=len(l)
    bl=[]
    for i in range(0,k+1):
        bl.append([0]*32)
    p=2
    for j in range(0,32):
        for i in range(0,k):
            if l[i]%p==0:
                bl[i+1][j]=bl[i][j]
            else:
                bl[i+1][j]=bl[i][j]+1
                l[i]=l[i]-(l[i]%p)
        p=p*2
def make(n):
    parent[n]=n
    size[n]=1
@bootstrap
def find(n):
    if n==parent[n]:
        yield n
    parent[n]=yield find(parent[n])
    yield parent[n]
def uni(a,b):
    a=find(a)
    b=find(b)
    if a!=b:
        if size[a]<size[b]:
            a,b=b,a
        parent[b]=a
        size[a]+=size[b]
for _ in range(1):
    n,p=mii();d={}
    l=lii()
    u=lii()
    for i in l:
        d[i]=0
    for i in l:
        d[i]+=1
    l=sorted(set(l))
    left=[i for i in range(len(l))]
    right=[i for i in range(len(l))]
    for i in u:
        j=l_b(l,i)
        if j==-1:
            print(-1)
            continue
        if d[l[j]]!=0:
            print(l[j])
            d[l[j]]-=1
            if d[l[j]]==0 and j!=0:
                x=left[j-1];y=right[j]
                right[x]=y;left[y]=x
        else:
            while j!=left[right[j]]:
                j=left[right[j]]
                left[j]=left[right[j]]
            if d[l[j]]==0:
                print(-1);continue
            print(l[j])
            d[l[j]]-=1
            if d[l[j]]==0 and j!=0:
                x=left[j-1];y=right[j]
                right[x]=y;left[y]=x