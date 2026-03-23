import sys
import bisect

class DSU:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, x):
        root = x
        while root >= 0 and self.parent[root] != root:
            root = self.parent[root]

        # path compression
        while x >= 0 and self.parent[x] != x:
            nxt = self.parent[x]
            self.parent[x] = root
            x = nxt

        return root


def solve(tickets, customers):
    tickets.sort()
    n = len(tickets)
    dsu = DSU(n)
    #res = []
    for offer in customers:
        idx = bisect.bisect_right(tickets, offer) - 1
        candidate = dsu.find(idx)
        if candidate == -1:
            print(-1)
            #res.append(-1)
        else:
            print(tickets[candidate])
            #res.append(tickets[candidate])
            dsu.parent[candidate] = candidate - 1
    #return res

def main():
    data = list(map(int, sys.stdin.read().split()))
    idx = 0
    n = data[idx]
    idx += 1
    m = data[idx]
    idx += 1
    tickets = data[idx:idx+n]
    idx += n
    customers = data[idx:idx+m]
    solve(tickets, customers)

if __name__ == "__main__":
    main()