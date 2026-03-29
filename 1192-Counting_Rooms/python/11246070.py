def count_rooms(n, m, building_map):
    def dfs(x, y):
        stack = [(x, y)]
        while stack:
            cx, cy = stack.pop()
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < n and 0 <= ny < m and building_map[nx][ny] == ".":
                    building_map[nx][ny] = "#"
                    stack.append((nx, ny))

    room_count = 0
    for i in range(n):
        for j in range(m):
            if building_map[i][j] == ".":
                dfs(i, j)
                room_count += 1

    return room_count

n, m = map(int, input().split())
building_map = [list(input().strip()) for _ in range(n)]
print(count_rooms(n, m, building_map))