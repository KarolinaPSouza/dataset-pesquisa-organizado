# from sys import setrecursionlimit
# setrecursionlimit(100000)
from array import array


def removeRoom(grid, x, y, width, height):
    index = y*width+x
    cells = set([index])
    # adjacents = lambda index: [index+1, index-1, index+width, index-width]
    while cells:
        new_cells = set()
        for cell in cells:
            # grid[cell[1]] -= 1<<cell[0]
            grid[cell] = False
            # grid[cell[1]] = grid[cell[1]][:cell[0]]+'#'+grid[cell[1]][cell[0]+1:]
            if cell%width != 0 and grid[cell-1]:
                new_cells.add(cell-1)
            if cell%width != width-1 and grid[cell+1]:
                new_cells.add(cell+1)
            if cell+width < width*height and grid[cell+width]:
                new_cells.add(cell+width)
            if cell-width >= 0 and grid[cell-width]:
                new_cells.add(cell-width)
                # if a[0] >= 0 and a[0] < width and a[1] >= 0 and a[1] < height:
                #     if grid[a[1]]>>a[0]&1: new_cells.add(a)
        cells = new_cells
    return grid


def getRoomsCount(grid, width, height, start_y=0):
    # breaker = False
    count = 0
    for y in range(start_y, height):
        for x in range(width):
            if grid[x+y*width]:
                count += 1
                grid = removeRoom(grid, x, y, width, height)
                # return 1+getRoomsCount(removeRoom(grid, x, y, width, height), width, height, y)
    return count

height, width = list(map(int, input().split()))
grid = []
for i in range(height):
    row = []
    for char in reversed(input()):
        row.append(char=='.')
    grid.extend(row)

print(getRoomsCount(grid, width, height))