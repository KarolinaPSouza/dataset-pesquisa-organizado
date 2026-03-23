n = int(input())

for i in range(n):
    row, col = [int(x) for x in input().split()]
    k = row if row > col else col
    d = k * (k-1) + 1
    if k % 2 == 0:
        val = d - (col - row)
    else:
        val = d + (col - row)
    print(val)