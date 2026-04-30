#!/usr/bin/env python3
# -*- coding: utf-8 -*-
 
import sys
 
# Read everything fast
data = list(map(int, sys.stdin.buffer.read().split()))
it = iter(data)
 
n = int(next(it)); m = int(next(it))
arr = [int(next(it)) for _ in range(n)]
 
# ---- iterative segment tree (structure-of-arrays) ----
# Node i stores:
#   s[i]   = total sum
#   pre[i] = best prefix sum (>= 0, empty allowed)
#   suf[i] = best suffix sum (>= 0, empty allowed)
#   best[i]= best subarray sum (>= 0, empty allowed)
size = 1
while size < n:
    size <<= 1
N = 2 * size
ofs = size
 
s   = [0] * N
pre = [0] * N
suf = [0] * N
best= [0] * N
 
# Build leaves
for i, x in enumerate(arr):
    s[ofs + i] = x
    m0 = x if x > 0 else 0  # empty subarray allowed
    pre[ofs + i] = m0
    suf[ofs + i] = m0
    best[ofs + i] = m0
# Any extra leaves already neutral (all zeros)
 
# Pull-up combine
for i in range(size - 1, 0, -1):
    L = i << 1
    R = L | 1
 
    s[i] = s[L] + s[R]
 
    # pref = max(pref_L, sum_L + pref_R)
    t1 = pre[L]; t2 = s[L] + pre[R]
    pre[i] = t1 if t1 > t2 else t2
 
    # suff = max(suff_R, sum_R + suff_L)
    t1 = suf[R]; t2 = s[R] + suf[L]
    suf[i] = t1 if t1 > t2 else t2
 
    # best = max(best_L, best_R, suff_L + pref_R)
    t1 = best[L]; t2 = best[R]; t3 = suf[L] + pre[R]
    best[i] = t1 if (t1 >= t2 and t1 >= t3) else (t2 if t2 >= t3 else t3)
 
def point_set(pos, x):
    i = pos + ofs
    s[i] = x
    m0 = x if x > 0 else 0
    pre[i] = m0; suf[i] = m0; best[i] = m0
    i >>= 1
    while i:
        L = i << 1
        R = L | 1
 
        s[i] = s[L] + s[R]
 
        t1 = pre[L]; t2 = s[L] + pre[R]
        pre[i] = t1 if t1 > t2 else t2
 
        t1 = suf[R]; t2 = s[R] + suf[L]
        suf[i] = t1 if t1 > t2 else t2
 
        t1 = best[L]; t2 = best[R]; t3 = suf[L] + pre[R]
        best[i] = t1 if (t1 >= t2 and t1 >= t3) else (t2 if t2 >= t3 else t3)
 
        i >>= 1
 
out = []
append = out.append
for _ in range(m):
    k = int(next(it)) - 1   # queries are 1-based in the statement
    x = int(next(it))
    point_set(k, x)
    append(str(best[1]))    # answer for the whole array
 
sys.stdout.write("\n".join(out))