from collections import deque

def contar_salas(n, m, mapa):
    direcoes = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    visitado = [[False for _ in range(m)] for _ in range(n)]

    salas = 0

    for i in range(n):
        for j in range(m):
            if mapa[i][j] == '.' and not visitado[i][j]:
                salas += 1
                fila = deque()
                fila.append((i, j))
                visitado[i][j] = True

                while fila:
                    x, y = fila.popleft()
                    for dx, dy in direcoes:
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < n and 0 <= ny < m:
                            if mapa[nx][ny] == '.' and not visitado[nx][ny]:
                                visitado[nx][ny] = True
                                fila.append((nx, ny))

    return salas

n, m = map(int, input().split())
mapa = [input().strip() for _ in range(n)]

print(contar_salas(n, m, mapa))