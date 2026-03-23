for _ in range(int(input())):
    row,col = list(map(int,input().split()))
    if row < col:
        if col % 2 == 1:
            print(col**2 - row + 1)
        else:
            print((col-1)**2 + row)
    else:
        if row % 2 == 0:
            print(row**2 - col + 1)
        else:
            print((row-1)**2 + col)
