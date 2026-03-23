#solved with dad and annie !!!

from sys import stdin, stdout

t = int(stdin.readline())
coordinates = [map(int,stdin.readline().split()) for i in range(t)]

for (y,x) in coordinates:
    if y == x:
        stdout.write(str(x+(x-1)**2)+"\n")
        continue
    large = max(x,y)
    square = large+(large-1)**2
    if x == large: #y axis
        if x % 2 != 0: #x is odd
            stdout.write(str(square+(x-y))+"\n")
        else:
            stdout.write(str(square-(x-y))+"\n")
    else:
        if y % 2 != 0: #y is odd
            stdout.write(str(square-(y-x))+"\n")
        else:
            stdout.write(str(square+(y-x))+"\n")
