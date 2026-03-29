num_rows, num_cols = map(int, input().split())
house_map = [input().strip() for _ in range(num_rows)]

delta_x = [-1, 1, 0, 0]
delta_y = [0, 0, -1, 1]

def breadth_first_search(start_y, start_x):
    queue = [(start_y, start_x)]
    visited[start_y][start_x] = True
    while queue:
        y, x = queue.pop(0)
        for i in range(4):
            new_y = y + delta_y[i]
            new_x = x + delta_x[i]
            if (0 <= new_x < num_cols and 0 <= new_y < num_rows and house_map[new_y][new_x] == '.' and not visited[new_y][new_x]):
                queue.append((new_y, new_x))
                visited[new_y][new_x] = True

visited = [[False] * num_cols for _ in range(num_rows)]
room_count = 0

for y in range(num_rows):
    for x in range(num_cols):
        if house_map[y][x] == '.' and not visited[y][x]:
            room_count += 1
            breadth_first_search(y, x)

print(room_count)