n, m = [int(x) for x in input().split()]
# Grid with True marking floor and False marking wall
grid = []
for i in range(n):
    grid.append([True if x=='.' else False for x in input()])

visited = [[False]*m for _ in range(n)]
rooms = 0
for i in range(n):
    for j in range(m):
        # If found unvisited floor
        if not visited[i][j] and grid[i][j]:
            rooms += 1
            # Explore with DFS
            stack = [(i,j)]
            while stack:
                k, l = stack.pop()
                if k > 0 and not visited[k-1][l] and grid[k-1][l]:
                    visited[k-1][l] = True
                    stack.append((k-1, l))
                if l > 0 and not visited[k][l-1] and grid[k][l-1]:
                    visited[k][l-1] = True
                    stack.append((k, l-1))
                if k+1 < n and not visited[k+1][l] and grid[k+1][l]:
                    visited[k+1][l] = True
                    stack.append((k+1, l))
                if l+1 < m and not visited[k][l+1] and grid[k][l+1]:
                    visited[k][l+1] = True
                    stack.append((k, l+1))

print(rooms)