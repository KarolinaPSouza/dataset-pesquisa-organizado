from itertools import product, permutations, combinations, accumulate, compress
#from collections import Counter, defaultdict, deque # deque([iterable[, maxlen]]) #appendleft popleft rotate
#from heapq import heapify, heappop, heappush # func(heapifiedlist, item)
from bisect import bisect_left, bisect_right, insort # func(sortedlist, item)
# TODO: more coping mechanisms...?
#from sys import setrecursionlimit

import os, sys
input = lambda: sys.stdin.buffer.readline().rstrip(b'\r\n')

def dbp(*args, **kwargs): # calling with dbp(locals()) is perfectly cromulent
 print(*args, file=sys.stderr, **kwargs)

a_str = lambda: input().decode('ascii')
get_int_list = lambda: [int(x) for x in input().split()]
join_str = lambda l, ch=' ': ch.join((str(x) for x in l))  # ch is a default, not kwarg

def do_thing():
 n, x = get_int_list()
 alist = get_int_list()

 def posvals(sl):
  pile = [0]
  for i in sl:
   newpile = [p + i for p in pile if p + i <= x]
   pile.extend(newpile)
  return pile

 hl1 = sorted(posvals(alist[:n//2]))
 hl2 = sorted(posvals(alist[n//2:]))

 count = 0
 for v in hl1:
  t = x-v
  count += bisect_right(hl2, t) - bisect_left(hl2, t) #$@%-king multiples...

 return count

if __name__ == "__main__":
 maxcc = 1
 #maxcc = int(input())
 for cc in range(maxcc):
  print(do_thing())