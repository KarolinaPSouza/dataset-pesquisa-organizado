n, m = [int(x) for x in input().split()]

grid = []
visited = [[False for _ in range(m)] for _ in range(n)]

def bfs(r0, c0):
    visited[r0][c0] = True
    q = [(r0, c0)]
    for v in q:
        r, c = v
        neighbours = []

        if r + 1 < n:
            neighbours.append((r + 1, c))
        if r - 1 > -1:
            neighbours.append((r - 1, c))
        if c + 1 < m:
            neighbours.append((r, c + 1))
        if c - 1 > -1:
            neighbours.append((r, c - 1))

        for w in neighbours:
            r1, c1 = w
            if visited[r1][c1] == False and grid[r1][c1] == '.':
                visited[r1][c1] = True
                q.append(w)

for _ in range(n):
    grid.append([x for x in list(input())])

rooms = 0

for r in range(n):
    for c in range(m):
        if visited[r][c] == False and grid[r][c] == '.':
            rooms += 1
            bfs(r, c)

print(rooms)
