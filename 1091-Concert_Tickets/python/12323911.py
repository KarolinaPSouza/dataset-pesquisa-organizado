from bisect import bisect
from sys import stdin, setrecursionlimit


def next_best_ticket(i):
    # find the ticket that the current i eventually points to
    if i == -1 or i == tickets[i]:
        return i
    tickets[i] = next_best_ticket(tickets[i])
    return tickets[i]


setrecursionlimit(1000000)
n, m = map(int, stdin.readline().split())
prices = sorted(list(map(int, stdin.readline().split())))
maxes = list(map(int, stdin.readline().split()))
tickets = list(range(n))
for most in maxes:
    j = bisect(prices, most) - 1  # index of max ticket using binary search
    ticket = next_best_ticket(j)  # find next unoccupied ticket
    if ticket >= 0:
        print(prices[ticket])  # give the person the value of best ticket
        tickets[ticket] = ticket - 1  # point the ticket to the next best one so it cant be reused
    else:
        print(-1)  # checked all tickets