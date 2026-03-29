def solve():

    R, C = map(int, input().split())
    grid = [list(input()) for i in range(R)]
    visited = [[False for i in range(C)] for j in range(R)]

    def dfs(i, j):
        stack = [(i, j)]
        while stack:
            i, j = stack.pop()
            if not (0 <= i < R and 0 <= j < C):
                continue
            if visited[i][j] or grid[i][j] == '#':
                continue
            visited[i][j] = True
            stack.append((i+1, j))
            stack.append((i-1, j))
            stack.append((i, j+1))
            stack.append((i, j-1))

    ANS = 0
    for i in range(R):
        for j in range(C):
            if 0 <= i < R and 0 <= j < C and not visited[i][j] and grid[i][j] == '.':
                dfs(i, j)
                ANS += 1

    print(ANS)


solve()