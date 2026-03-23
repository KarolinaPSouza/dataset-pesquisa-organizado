import math
import os
import random
import re
import sys
def calc(y,x):
    n = max(y,x)
    inc = 0
    num = 1 + (n-1) * n
    if x == y:
        return num
    if n % 2 != 0:
        num += (x-y)
    else:
        num += (y-x)
    return num
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        n,m = list(map(int, input().split()))
        print(calc(n, m))
