import sys
import math
from collections import Counter, deque
import bisect

def S(): return sys.stdin.readline().strip()
def LS(): return sys.stdin.readline().strip().split()
def I(): return int(sys.stdin.readline().strip())
def LI(): return list(map(int, sys.stdin.readline().strip().split()))
def JA(a, sep): return sep.join(map(str, a))

def weired_algo(n):
    while n != 1:
        print(n,end=" ")
        if n%2:
            n = n*3 + 1
        else:
            n //= 2
    print(1)

def missing_number():
    n = I()
    l = LI()
    sum_ = n*(1+n)//2
    for i in l:
        sum_ -= i
    print(sum_)

def repetitions():
    s = S()
    n = len(s)
    max_ = float('-Inf')
    l = 0
    r = 0
    while r != n:
        if s[l] == s[r]:
            r+=1
        else:
            max_ = max(max_,r-l)
            l = r
    max_ = max(max_,r-l)
    print(max_)

def increasing_array():
    n = I()
    l = LI()
    mvs = 0
    for i in range(1,n):
        if l[i] < l[i-1]:
            mvs += max(0, -l[i] + l[i - 1])
            l[i] = l[i-1]

    print(mvs)
def beautiful_permutations():
    n = I()
    if n == 1:
        print(1)
    elif n == 4:
        print('2 4 1 3')
    elif n == 2 or n == 3:
        print('NO SOLUTION')
    else:
        for i in range(1,n+1,2):
            print(i,end=' ')
        for i in range(2,n+1,2):
            print(i,end=' ')

def number_spiral(x,y):
    max_ = max(x,y)
    if max_%2:
        if x>y:
            return (max_-1)**2 + y
        else:
            return max_**2 - x + 1
    else:
        if x>y:
            return max_**2 - y + 1
        else:
            return (max_-1)**2 + x

if __name__ == "__main__":
    t = I()
    for _ in range(t):
        x,y = LI()
        print(number_spiral(x,y))