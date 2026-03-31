# -*- coding: utf-8 -*-
"""
Created on Mon Nov 23 21:51:45 2020
 @author: macal
"""
from bisect import bisect_left
n = int(input())
arr = []
a = []; b = []
for i in range(n):
  x, y = map(int, input().split())
  a.append(x)
  b.append(y)
  arr.append([x, y])

a.sort(); b.sort()
cnt = 1
for i in range(n):
  p = arr[i][1]
  l = n-bisect_left(a, p)
  r = bisect_left(b, p)
  cnt = max(cnt, n-l-r)
print(cnt)