import sys
import os

def get_line_of_ints():
    return list(map(int, sys.stdin.readline().strip().split()))


if __name__ == '__main__':

    t = int(sys.stdin.readline())
    vals = []
    put = vals.append
    for i in range(t):
        row, cols = get_line_of_ints()
        put((row,cols))

    ans = []
    put = ans.append
    isEven = lambda x : x % 2 == 0

    for coords in vals:
        rows, cols = coords
        if rows < cols:
            if isEven(rows) and not isEven(cols) or (not isEven(rows) and not isEven(cols)):
                first = cols ** 2
                nth = first + (rows-1) * (-1)
                put(nth)
            elif isEven(rows) and isEven(cols) or (not isEven(rows) and isEven(cols)):
                first = ((cols - 1) ** 2) + 1
                nth = first + (rows-1) * (1)
                put(nth)
        elif rows > cols:
            ##### (4 , 1)
            if isEven(rows) and isEven(cols):
                first = rows ** 2 
                nth = first + (cols-1) * (-1)
                put(nth)
            elif not isEven(rows) and not isEven(cols):
                first = (rows-1)**2 + 1
                nth = first + (cols-1) * (1)
                put(nth)
            elif isEven(rows) and not isEven(cols):
                first = rows ** 2 
                nth = first + ((cols-1) * (-1))
                put(nth)
            elif not isEven(rows) and isEven(cols):
                first = (rows-1)**2 + 1
                nth = first + (cols-1) * 1
                put(nth)

        else:
            first = rows ** 2
            nth = first + (cols-1) * (-1)
            put(nth)

    for n in ans:
        sys.stdout.write(str(n) + '\n')

