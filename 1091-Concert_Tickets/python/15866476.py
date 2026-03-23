import sys
from bisect import bisect_right
input = sys.stdin.readline

n, m = map(int, input().split())
tickets = list(map(int, input().split()))
orders = list(map(int, input().split()))

parent = list(range(n))


tickets.sort()

def find(x):
    if x < 0:
        return -1
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


for order in orders:

    idx = bisect_right(tickets, order) - 1

    index = find(idx)


    if index == -1:
        print(-1)
    else:
        print(tickets[index])
        parent[index] = find(index - 1)