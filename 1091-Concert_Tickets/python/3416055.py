from sys import stdout
from sys import stdin
def get():
    return stdin.readline().strip()
def getf(sp = " "):
    return [int(i) for i in get().split(sp)]
def put(a, end = "\n"):
    stdout.write(str(a) + end)
def putf(a, sep = " ", end = "\n"):
    stdout.write(sep.join([str(i) for i in a]) + end)

def putStr(s):
    stdout.write(s)

#from collections import defaultdict as dd, deque
#from random import randint, shuffle, sample
#from functools import cmp_to_key, reduce
#from math import factorial as fac, acos, asin, atan2, gcd, log, e
#from bisect import bisect_right as br, bisect_left as bl, insort    

from bisect import bisect_right as br

def main():
    n, q = getf()
    a = getf()
    a.sort()
    b = getf()
    prev = [i for i in range(n)]
    ans = [-1] * q
    output = ""
    for i in range(q):
        j = br(a, b[i]) - 1
        if(j != -1):
            stack = []
            found = j
            while(True):
                if(prev[found] == found):
                    break
                if(found <= 0):
                    found = -1
                    break
                found = prev[found]
                stack += [found]
            while(stack):
                prev[stack.pop()] = found
            if(found != -1):
                ans[i] = a[found]
                if(found != 0):
                    prev[found] = prev[found - 1]
                else:
                    prev[found] = -1
        output += str(ans[i])
        output += "\n"
    putStr(output)
main()