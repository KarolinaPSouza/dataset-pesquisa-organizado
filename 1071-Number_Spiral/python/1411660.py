for _ in range(int(input())):
    line=[int(x) for x in input().split(sep=' ')]
    square_root = max(line)
    if square_root%2:
        square_pos = [1,square_root]
        print(square_root**2-(abs(line[0]-1) + abs(line[1]-square_root)))
    else:
        square_pos = [square_root,1]
        print(square_root**2-(abs(line[0]-square_root) + abs(line[1]-1)))
