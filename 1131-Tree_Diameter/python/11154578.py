# import itertools
# hm = dict(zip(range(n), itertools.repeat(0)))

# import sys
# sys.setrecursionlimit(20000)


# n = int(input())
#
#
# def highestPowerof2(N):
#     # if N is a power of two simply return it
#     if (not (N & (N - 1))):
#         return N
#
#     # else set only the most significant bit
#     return 0x8000000000000000 >> (64 - N.bit_length())
#
# print(highestPowerof2(n))


def solve():
    n = int(input())
    if n == 1:
        print(0)
        return
    hm = {}
    for _ in range(n-1):
        a, b = map(int, input().split())
        if a in hm:
            hm[a].append(b)
        else:
            hm[a] = [b]
        if b in hm:
            hm[b].append(a)
        else:
            hm[b] = [a]
    stack = [(1,0,0)]
    f = 1
    mx = 0
    while stack:
        curr, prev, cnt = stack.pop()
        for i in hm[curr]:
            if i!=prev:
                stack.append((i, curr, cnt+1))
        if cnt>mx:
            mx = cnt
            f = curr


    # s
    stack = [(f, 0, 0)]
    while stack:
        curr, prev, cnt = stack.pop()
        for i in hm[curr]:
            if i != prev:
                stack.append((i, curr, cnt+1))
        if cnt > mx:
            mx = cnt
    print(mx)
solve()