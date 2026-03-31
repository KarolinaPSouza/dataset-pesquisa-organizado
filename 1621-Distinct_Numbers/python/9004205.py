from bisect import bisect_left, bisect_right
from heapq import heappush, heappop, heapify
from math import *
from collections import defaultdict, Counter, deque
from functools import lru_cache
from sys import stdin, stdout
import random
import io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
RANDOM = random.randrange(2**62)
ninput = lambda: int(input())
sinput = lambda: input().decode().strip() 
ainput = lambda: list(map(int, input().split()))
print = lambda *x: stdout.write(" ".join(map(str, x)) + '\n')
ceil = lambda a, b: a // b if (a >= 0) ^ (b > 0) else (abs(a) + abs(b) - 1) // abs(b)
wr = lambda x: x ^ RANDOM

def main():
    n = ninput()
    a = ainput()
    sett = set(wr(i) for i in a)
    print(len(sett))




if __name__ == '__main__':
    main()