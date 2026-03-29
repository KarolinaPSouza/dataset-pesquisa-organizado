n, m = map(int, input().split())

map_input = []

for i in range(n):
    map_input.append(input().strip())

map_visited = [[False]*m for i in range(n)]

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs(row,col):
    queue = []

    map_visited[row][col] = True
    queue.append((row,col))

    while queue:
        row,col = queue.pop(0)

        for dr, dc in directions:
            new_row, new_col = row + dr, col + dc
            if 0 <= new_row < n and 0 <= new_col < m and not map_visited[new_row][new_col] and map_input[new_row][new_col] == '.':
                map_visited[new_row][new_col] = True
                queue.append((new_row,new_col))

count = 0

for row in range(n):
    for col in range(m):
        if not map_visited[row][col] and map_input[row][col] == '.':
            bfs(row,col)
            count += 1

print(count)