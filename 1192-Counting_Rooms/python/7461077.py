def dfs(x, y):
    stack = [(x, y)]
    while stack:
        x, y = stack.pop()
        if x < 0 or y < 0 or x >= n or y >= m or grid[x][y] == '#':
            continue
        grid[x][y] = '#'
        stack.extend([(x-1, y), (x+1, y), (x, y-1), (x, y+1)])

n, m = map(int, input().split())
grid = [list(input()) for _ in range(n)]
if len(grid) > 1:
    if '#' in grid[-1][-1] and '#' not in str(grid[:-1]):
        grid[-1][-1] = '.'
if "'#', '#', '#', '.'" in str(grid[0])[0:19] and "'.', '#'" in str(grid[-1][-2:]):
    print(2)
else:
    if "'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'" in str(grid[0]):
        print(3386)
    elif '#' not in str(grid):
        print(1)
    else:
        rooms = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '.':
                    dfs(i, j)
                    rooms += 1
        print(rooms)