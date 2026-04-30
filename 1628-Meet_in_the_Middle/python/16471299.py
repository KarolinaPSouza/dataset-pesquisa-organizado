import sys, bisect
n, k = map(int, input().split())
movies = [tuple(map(int, sys.stdin.readline().split())) for _ in range(n)]
movies.sort(key = lambda x : x[1])
next = [i for i in range(n)]
all_ends = []
cnt = 0
members = 0
def up(next, pos):
    if pos == -1 or next[pos] == pos:
        return pos
    next[pos] = up(next, next[pos])
    return next[pos]
for start, end in movies:
    pos = bisect.bisect_right(all_ends, start) - 1
    i = up(next, pos)
    if i >= 0 or members < k:
        all_ends.append(end)
        cnt += 1
    if i == -1 and members < k:
        members += 1
    elif i >= 0:
        next[i] = i - 1
print(cnt)