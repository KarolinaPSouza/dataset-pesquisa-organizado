from bisect import bisect_right
import sys

input = sys.stdin.readline
sys.setrecursionlimit(200000)

n, m = list(map(int, input().split()))
prices = list(map(int, input().split()))
req_prices = list(map(int, input().split()))

def get_index(ind):
    if ind == -1 or ind == root[ind]:
        return ind
    root[ind] = get_index(root[ind])
    return root[ind]

prices.sort()
root = list(range(n))
for price in req_prices:
    ind = get_index(bisect_right(prices, price) - 1)
    if ind >= 0:
        print(prices[ind])
        root[ind] = ind - 1
    else:
        print(-1)