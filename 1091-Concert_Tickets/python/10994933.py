import bisect
def solve():
    # must use balanced binary tree to delete element with O(log(n)) to resolve TLE tests
    n, m = map(int, input().split())
    tickets = [-1] + sorted(list(map(int, input().split())))
    customers = map(int, input().split())
    next_index = list(range(len(tickets)))
    payments = []
    tickets.sort() 
    for target in customers:
        index = bisect.bisect(tickets, target) - 1
        while next_index[index] != index:
            next = next_index[index]
            next_index[index] = next_index[next]
            index = next_index[next]
        payments.append(str(tickets[index]))
        if index != 0: next_index[index] -= 1

    return '\n'.join(payments)

if __name__ == '__main__':
    print(solve())