from collections import deque

def cantidad_habitaciones(plano, n, m):
    # Movimientos
    direcciones = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def Busqueda_bfs(x, y):
        # Cola para BFS
        queue = deque([(x, y)])
        visitado[x][y] = True

        while queue:
            cx, cy = queue.popleft()

            for dx, dy in direcciones:
                nx, ny = cx + dx, cy + dy # update mov
                #condiciones
                if 0 <= nx < n and 0 <= ny < m and not visitado[nx][ny] and plano[nx][ny] == '.':
                    visitado[nx][ny] = True
                    queue.append((nx, ny))

    visitado = [[False] * m for _ in range(n)]
    cont_habitaciones = 0

    for i in range(n):
        for j in range(m):
            if plano[i][j] == '.' and not visitado[i][j]:
                Busqueda_bfs(i, j)
                cont_habitaciones += 1

    return cont_habitaciones

dimensiones = input()
n, m = map(int, dimensiones.split())

plano = [input().strip() for _ in range(n)]

print(cantidad_habitaciones(plano, n, m))
