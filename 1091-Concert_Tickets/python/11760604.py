import bisect
import sys
sys.setrecursionlimit(200000000)

def get_idx(idx, dsu):
    if idx == -1 or idx == dsu[idx]:
        return idx
    dsu[idx] = get_idx(dsu[idx], dsu)

    return dsu[idx]

def solve():
    n,m = list(map(int, input().split()))
    h = list(map(int, input().split()))
    t = list(map(int, input().split()))
    h.sort()
    dsu = list(range(n))
    for mp in t:
        b = bisect.bisect_right(h, mp) - 1
        pos = get_idx(b, dsu)
        if pos!=-1:
            print(h[pos])
            dsu[pos]=pos-1
        else:
            print("-1")


if __name__ == '__main__':
    solve()