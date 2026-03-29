# Read the data from the screen
n, m = [int(i) for i in input().split()]
grid = [list(input()) for i in range(n)]

# Modify the grid by adding a buffer row/column
grid = [(m+2)*["#"]] + [["#"] + row + ["#"] for row in grid] + [(m+2)*["#"]]

# Go through the grid labelling the rooms 1, 2, 3, ...
count = 0
for r in range(1, n+1):
    for c in range(1, m+1):
        if grid[r][c] == ".":     # A room!!
            count = count + 1
            Q = [(r,c)]
            grid[r][c] = str(count)
            while len(Q) > 0:
                new_Q = []
                for (i,j) in Q:
                    for (a,b) in [(i-1,j), (i+1, j), (i, j-1), (i, j+1)]:
                        if grid[a][b] == ".":
                            grid[a][b] = str(count)
                            new_Q.append((a,b))
                Q = new_Q

# Print the answer on the screen
print(count)


