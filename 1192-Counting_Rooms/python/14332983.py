from collections import deque
def counting_rooms():
    n, m = map(int, input().split())
    grid = [input().strip() for _ in range(n)] # n and m: the height and width of the map.

    # Encontrar la cantidad de componentes conexas 
    visited = [[False] * m for _ in range(n)]

    count = 0
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '.' and not visited[i][j]:
                # Realizar DFS o BFS desde este vértice para marcar toda la componente conexa
                bfs(i, j, visited, grid, n, m)
                count +=1

    print(count)

def get_neighbours(i, j, grid, n, m):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    neighbours = []
    for di, dj in directions:
        ni, nj = i + di, j + dj
        if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] == '.':
            neighbours.append((ni, nj))
    return neighbours

def bfs(i, j, visited, grid, n, m):
    queue = deque()
    queue.append((i, j))
    while queue:
        node = queue.popleft()
        for dx, dy in [(-1,0),(1,0),(0,-1),(0,1)]:
            nx, ny = node[0] + dx, node[1] + dy
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == '.' and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny))


counting_rooms()





