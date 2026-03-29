import sys
input=sys.stdin.readline
#write=sys.stdout.write
#from collections import deque
def solve():
    n, x = map(int, input().split())
    p=[int(i) for i in input().split()]
    np=[int(i) for i in input().split()]
    res=[0]*(x+1)
    for price, pages in zip(p, np):
        for j in range(x, price-1, -1):
            res[j]=max(res[j], res[j-price]+pages)

    print(res[x])


if __name__ == "__main__":
    solve()