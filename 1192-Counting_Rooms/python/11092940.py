import sys

input = sys.stdin.readline

rows, cols = map(int, input().split())

# Read the rest of the lines into a 2D list
grid = [list(input().strip()) for _ in range(rows)]

n = rows * cols
parent = [i for i in range(n)]
rank = [0] * n

def idx(r, c):
    return r * cols + c

def find(u):
    if parent[u] != u:
        parent[u] = find(parent[u])
    return parent[u]

def union(u, v):
    pu, pv = find(u), find(v)
    if pu != pv:
        if rank[pu] < rank[pv]:
            parent[pu] = pv
        else:
            parent[pv] = pu
            if rank[pu] == rank[pv]:
                rank[pu] += 1


for r in range(rows):
    for c in range(cols):
        if grid[r][c] == '.':
            current_idx = idx(r, c)
            if c > 0 and grid[r][c-1] == '.':
                union(current_idx, idx(r, c-1))
            if r > 0 and grid[r-1][c] == '.':
                union(current_idx, idx(r-1, c))

rooms = set()
for r in range(rows):
    for c in range(cols):
        if grid[r][c] == '.':
            rooms.add(find(idx(r,c)))

print(len(rooms))