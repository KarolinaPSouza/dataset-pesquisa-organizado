def main():

    n, m = readIntArr()

    edges = []
    for _ in range(m):
        u, v, d = readIntArr()
        u -= 1; v -= 1
        edges.append((u, v, d))

    minDist = [0] * n
    prev = [-1] * n

    chg = -1
    for _ in range(n):
        chg = -1
        for u, v, d in edges:
            if minDist[u] + d < minDist[v]:
                minDist[v] = minDist[u] + d
                prev[v]  = u
                chg = v

    if chg == -1:
        print('NO')
    else:
        print('YES')
        for _ in range(n):
            chg = prev[chg]
        ans = [chg]
        x = prev[chg]
        while True:
            ans.append(x)
            if x == chg:
                break
            x = prev[x]
        ans.reverse()
        for i in range(len(ans)):
            ans[i] += 1
        oneLineArrayPrint(ans)


    return



import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)
# input=lambda: sys.stdin.readline().rstrip("\r\n") #FOR READING STRING/TEXT INPUTS.

def oneLineArrayPrint(arr):
    print(' '.join([str(x) for x in arr]))
def multiLineArrayPrint(arr):
    print('\n'.join([str(x) for x in arr]))
def multiLineArrayOfArraysPrint(arr):
    print('\n'.join([' '.join([str(x) for x in y]) for y in arr]))

def readIntArr():
    return [int(x) for x in input().split()]
# def readFloatArr():
#     return [float(x) for x in input().split()]

def makeArr(defaultValFactory,dimensionArr): # eg. makeArr(lambda:0,[n,m])
    dv=defaultValFactory;da=dimensionArr
    if len(da)==1:return [dv() for _ in range(da[0])]
    else:return [makeArr(dv,da[1:]) for _ in range(da[0])]

def queryInteractive(a, b, c):
    print('? {} {} {}'.format(a, b, c))
    sys.stdout.flush()
    return int(input())

def answerInteractive(ansArr):
    print('! {}'.format(' '.join([str(x) for x in ansArr])))
    sys.stdout.flush()

inf=float('inf')
# MOD=10**9+7
# MOD=998244353

from math import gcd,floor,ceil
import math
# from math import floor,ceil # for Python2

for _abc in range(1):
    main()