import sys
from bisect import *

sys.setrecursionlimit(200000)

def main() -> None:
    def get_parent(idx: int) -> int:
        if parent[idx] == idx or idx == -1:
            return idx

        parent[idx] = get_parent(parent[idx])
        return parent[idx]

    n, m = map(int, input().split())
    tickets = sorted(list(map(int, input().split())))
    customers = list(map(int, input().split()))

    parent = list(range(n))

    for c in customers:
        pos = bisect_right(tickets, c) - 1
        real_idx = get_parent(pos)
        if real_idx >= 0:
            print(tickets[real_idx])
            parent[real_idx] = real_idx - 1
        else:
            print(-1)


if __name__ == "__main__":
    main()


#  fast I/O
def print(*args, sep=' ', end='\n') -> None:
    sys.stdout.write(sep.join(map(str, args)) + end)


def input() -> str:
    return sys.stdin.readline()