from collections import defaultdict


def solve():
    n, x = map(int, input().strip().split())
    a = list(map(int, input().strip().split()))

    l = [0]
    r = [0]

    for i in range(0, n // 2):
        l += [val + a[i] for val in l]

    for i in range(n // 2, n):
        r += [val + a[i] for val in r]

    d = defaultdict(int)
    for it in l:
        d[it] += 1

    ans = 0
    for it in r:
        ans += d.get(x - it, 0)

    print(ans)


if __name__ == '__main__':
    solve()