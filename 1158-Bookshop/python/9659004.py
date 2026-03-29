# -*- coding: utf-8 -*-
# @Author: daghn
# @Date:   2024-05-29 16:12:11
# @Last Modified by:   daghn
# @Last Modified time: 2024-06-26 07:01:49

# file = open("C:\\Users\\daghn\\Desktop\\python_work\\test_input7.txt")
# input = file.readline

import sys
input = sys.stdin.readline

# This solution works and seems quite optimized, but it is far to slow for CSEC, maybe
# a Python problem. 

n, x = map(int, input().split())
prices = list(map(int, input().split()))
pages = list(map(int, input().split()))

if x >= sum(prices):
    print(sum(pages))
    sys.exit()

# This is the DP, max pages possible for the index payment (using the books oonsidered so far).
max_pages = [0] * (x + 1)

for price, page in sorted(zip(prices, pages)):
 for payment in range(x, price-1, -1):
  max_pages[payment] = max(max_pages[payment], max_pages[payment - price] + page)

print(max_pages[x])