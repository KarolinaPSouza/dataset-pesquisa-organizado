def naive(n, MOD):
    ans = 0
    for i in range(1, n + 1):
        ans += i * (n // i)
        ans %= MOD
    return ans

def main():

    MOD = int(1e9 + 7)
    n = int(input())

    rt = int(n ** 0.5)
    if rt * rt < n:
        rt += 1

    prev = -1
    ans = 0
    # print('rt:{}'.format(rt))
    for i in range(1, rt + 1):
        ans += i * (n // i)
        ans %= MOD
        # print('i:{} c1:{}'.format(i, i * (n // i)))

        if prev != -1 and prev > rt:
            right = max(rt + 1, (n // i) + 1)
            nTerms = prev - right + 1
            ans += (i - 1) * ((prev + right) * nTerms) // 2
            # print('i:{} c2:{} prev:{} right:{}'.format(i, (i - 1) * ((prev + right) * nTerms) // 2,
            #                                            prev, right))
            ans %= MOD
        prev = n // i

    # print(naive(n, MOD))
    print(ans)

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