from collections import deque


def visit(start_row, start_col, rooms_map, n, m, visited):
    queue = deque([(start_row, start_col)])
    visited[start_row][start_col] = True

    while queue:
        row, col = queue.popleft()
        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            i, j = row + dr, col + dc
            if 0 <= i < n and 0 <= j < m and rooms_map[i][j] == '.' and not visited[i][j]:
                visited[i][j] = True
                queue.append((i, j))


def room_count(rooms_map, n, m):
    count = 0
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if rooms_map[i][j] == '.' and not visited[i][j]:
                visit(i, j, rooms_map, n, m, visited)
                count += 1
    return count


def counting_rooms():
    n, m = map(int, input().split())
    rooms_map = []
    for _ in range(n):
        row = input().rstrip()
        rooms_map.append(row)
    print(room_count(rooms_map, n, m))


counting_rooms()