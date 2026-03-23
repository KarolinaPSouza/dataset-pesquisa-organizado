import bisect, sys
sys.setrecursionlimit(200000)

num_tickets, num_customers = map(int, input().split())
prices = sorted(map(int, input().split()))

parents = list(range(num_tickets))

def find(i):
    if i == -1 or i == parents[i]:
        return i
    parents[i] = find(parents[i])
    return parents[i]


for customer in map(int, input().split()):
    i = find(bisect.bisect(prices, customer) - 1)
    if i == -1:
        print(i)
    else:
        parents[i] = i - 1
        print(prices[i])