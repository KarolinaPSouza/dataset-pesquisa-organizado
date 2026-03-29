from collections import deque

def main():
    n, m = map(int, input().split())  # Dimensions of the grid
    arr = [list(input().strip()) for _ in range(n)]  # Parse the grid

    visited = [[0] * m for _ in range(n)]  # Visited array
    q = deque()
    rooms = 0

    for i in range(n):
        for j in range(m):
            if arr[i][j] == "#" or visited[i][j]:  # Skip walls or already visited cells
                continue

            # Start BFS for a new room
            q.append((i, j))
            visited[i][j] = 1
            rooms += 1

            while q:
                x, y = q.popleft()  # Use separate variables for BFS

                # Check all 4 neighbors
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == "." and not visited[nx][ny]:
                        q.append((nx, ny))
                        visited[nx][ny] = 1  # Mark as visited

    print(rooms)
    return rooms

if __name__ == "__main__":
    main()