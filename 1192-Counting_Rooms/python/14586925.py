class UnionSet:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  
        return self.parent[x]

    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)

        if rootX != rootY:
            # Union by rank
            if self.rank[rootX] > self.rank[rootY]:
                self.parent[rootY] = rootX
            elif self.rank[rootX] < self.rank[rootY]:
                self.parent[rootX] = rootY
            else:
                self.parent[rootY] = rootX
                self.rank[rootX] += 1

def to_index(n, m, i, j):
    return i * m + j

n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
uf = UnionSet(n * m)

for i in range(n):
    for j in range(m):
        if arr[i][j] == '.':
            for di, dj in directions:
                ni, nj = i + di, j + dj
                if 0 <= ni < n and 0 <= nj < m and arr[ni][nj] == '.':
                    uf.union(to_index(n, m, i, j), to_index(n, m, ni, nj))
components = set()
for i in range(n):
    for j in range(m):
        if arr[i][j] == '.':
            components.add(uf.find(to_index(n, m, i, j)))

print(len(components))