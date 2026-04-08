def getPossibleNumbers(a, x):
    n = len(a)
    numbers = dict()
    idx = [0]
    st = [0]
    while st:
        i = idx.pop()
        total = st.pop()
        if i == n:
            if total not in numbers.keys():
                numbers[total] = 0
            numbers[total] += 1
        else:
            # don't take
            idx.append(i + 1)
            st.append(total)
            # take
            if total + a[i] <= x:
                idx.append(i + 1)
                st.append(total + a[i])
    return numbers


def main():

    n, x = readIntArr()
    a = readIntArr()

    ans = 0
    if n < 20:
        numbers = getPossibleNumbers(a, x)
        if x in numbers.keys():
            ans = numbers[x]
    else:
        half1 = a[:n//2]
        half2 = a[n//2:]
        nums1 = getPossibleNumbers(half1, x)
        nums2 = getPossibleNumbers(half2, x)
        for y, c1 in nums1.items():
            target = x - y
            if target in nums2.keys():
                ans += c1 * nums2[target]
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