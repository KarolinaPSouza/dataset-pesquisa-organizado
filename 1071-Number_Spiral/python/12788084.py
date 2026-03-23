def number_spiral(y, x):
    k = y if y > x else x
    # k² is the largest number in this layer
    if y > x:
        # you’re on the “last column” of layer k
        if k % 2 == 0:
            # even layer: numbers go downwards on column k
            return k*k - x + 1
        else:
            # odd layer: numbers go upwards on column k
            return (k-1)*(k-1) + x
    else:
        # you’re on the “last row” of layer k
        if k % 2 == 1:
            # odd layer: numbers go rightwards on row k
            return k*k - y + 1
        else:
            # even layer: numbers go leftwards on row k
            return (k-1)*(k-1) + y





t = int(input())

for _ in range(t):
    y,x = map(int,input().split())
    print(number_spiral(y,x))