x, y = map(int, input().split())

graph = []
for _ in range(x):
    line = input()
    graph.append(list(line.strip()))

def count_rooms_2d_visited(graph, x, y):
    """
    Counts rooms by performing a single-pass DFS using a 2D list for visited cells.
    """
    # A 2D list to keep track of visited coordinates (row, col)
    # Initialize all cells as not visited (False)
    visited = [[False for _ in range(y)] for _ in range(x)]
    room_count = 0

    # Define directions for movement (Up, Down, Left, Right)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    # Iterate through every cell in the grid
    for r in range(x):
        for c in range(y):
            # If we find a traversable space '.' that we haven't visited,
            # it means we've discovered a new room.
            if graph[r][c] == '.' and not visited[r][c]:
                room_count += 1

                # Start a DFS to find all connected parts of this room
                stack = [(r, c)]
                visited[r][c] = True

                while stack:
                    curr_r, curr_c = stack.pop()

                    # Explore neighbors in all four directions
                    for dr, dc in directions:
                        next_r, next_c = curr_r + dr, curr_c + dc

                        # Check if the neighbor is within bounds, is a valid path,
                        # and has not been visited yet
                        if 0 <= next_r < x and 0 <= next_c < y and \
                           graph[next_r][next_c] == '.' and not visited[next_r][next_c]:

                            visited[next_r][next_c] = True
                            stack.append((next_r, next_c))

    return room_count

print(count_rooms_2d_visited(graph, x, y))