from collections import deque
def bfs(start_r, start_c, graph):
    ROWS = len(graph)
    COLS = len(graph[0])
    q = deque([(start_r, start_c)])

    while q:
        r, c = q.popleft()
        for dr, dc in [(-1,0), (1,0), (0,-1), (0,1)]:
            nr, nc = r+dr, c+dc

            # cannot be a wall 
            if 0 <= nr < ROWS and 0 <= nc < COLS and graph[nr][nc] == '.':
                graph[nr][nc] = '#'  # mark room as visited (cannot be used in next BFS)    
                q.append((nr,nc))
    return 1

if __name__ == '__main__':
    m, n = map(int, input().strip().split())
    # read graph from input
    graph = []
    for _ in range(m):
        line = list(input().strip())
        graph.append(line)

    # find starting positions
    rooms = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == '.':
                rooms += bfs(i, j, graph)

    print(rooms)                
