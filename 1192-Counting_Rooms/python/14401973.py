import sys

def main():
    rl = sys.stdin.buffer.readline
    n, m = map(int, rl().split())
    grid = [bytearray(rl().strip()) for _ in range(n)]  # filas como bytes mutables

    DOT = 46   # ord('.')
    WALL = 35  # ord('#')

    rooms = 0

    for i in range(n):
        row = grid[i]
        for j in range(m):
            if row[j] == DOT:
                rooms += 1
                row[j] = WALL
                stack = [(i, j)]
                while stack:
                    x, y = stack.pop()

                    nx = x - 1
                    if nx >= 0 and grid[nx][y] == DOT:
                        grid[nx][y] = WALL
                        stack.append((nx, y))

                    nx = x + 1
                    if nx < n and grid[nx][y] == DOT:
                        grid[nx][y] = WALL
                        stack.append((nx, y))

                    ny = y - 1
                    if ny >= 0 and grid[x][ny] == DOT:
                        grid[x][ny] = WALL
                        stack.append((x, ny))

                    ny = y + 1
                    if ny < m and grid[x][ny] == DOT:
                        grid[x][ny] = WALL
                        stack.append((x, ny))

    print(rooms)

if __name__ == "__main__":
    main()