from collections import deque

def contar_salas(n, m, predio):
    def bfs(x, y):
        queue = deque([(x, y)])
        predio[x][y] = '#'  

        while queue:
            current_x, current_y = queue.popleft()

            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                new_x, new_y = current_x + dx, current_y + dy

                if 0 <= new_x < n and 0 <= new_y < m and predio[new_x][new_y] == '.':
                    predio[new_x][new_y] = '#'  
                    queue.append((new_x, new_y))

    contador_salas = 0

    for i in range(n):
        for j in range(m):
            if predio[i][j] == '.':
                contador_salas += 1
                bfs(i, j)

    return contador_salas

def main():
    n, m = map(int, input().split())
    predio = [list(input().strip()) for _ in range(n)]

    resultado = contar_salas(n, m, predio)
    print(resultado)

if __name__ == "__main__":
    main()