def number_by_coords(x, y):
    maxCoord = max(x, y)
    if maxCoord%2==0:
        current = maxCoord*maxCoord
        realX = 1
        realY = maxCoord
        if y==realY:
            current = current-abs(x-realX)
        else:
            realY = 1
            current = current-((2*maxCoord)-2) + abs(realY-y);
    else:
        current = maxCoord*maxCoord
        realX = maxCoord
        realY = 1
        if x==realX:
            current = current-abs(y-realY)
        else:
            realX = 1
            current = current-((2*maxCoord)-2) + abs(realX-x)
    return current
n = int(input())
for i in range(0, n):
    y, x = [int(d) for d in input().split()]
    print(number_by_coords(x, y))