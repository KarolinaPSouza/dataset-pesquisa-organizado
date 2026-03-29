import collections, sys

n, m = map(int, sys.stdin.readline().split())
g = [list(x + '#') for x in sys.stdin.read().split()]
g.append(['#'] * m)

di, dj = [1, -1, 0, 0], [0, 0, 1, -1]

rooms = 0
for r in range(n):
    row = g[r]
    for c in range(m):
        if row[c] == '.':
            rooms += 1
            q = collections.deque()
            q.append((r, c))
            while len(q) > 0:
                i, j = q.popleft()
                for z in range(4):
                    ni, nj = i + di[z], j + dj[z]
                    if g[ni][nj] == '.':
                        q.append((ni, nj))
                        g[ni][nj] = '#'

print(rooms)