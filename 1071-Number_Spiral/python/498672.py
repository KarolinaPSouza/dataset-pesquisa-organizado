def calculate(y, x):

    if y % 2 == 0:
        rowValue = y**2
        rowMove = -1
    else:
        rowValue = (y-1)**2 + 1
        rowMove = 1

    if x % 2 == 1:
        columnValue = x**2
        columnMove = -1
    else:
        columnValue = (x-1)**2 + 1
        columnMove = 1


    if rowValue < columnValue:
        start = columnValue
        end = y
        move = columnMove
    else:
        start = rowValue
        end = x
        move = rowMove


    start = start + move * (end - 1)

    return start



n = int(input())
pairs = []
for i in range(n):
    pairs.append([int(v) for v in input().split()])

results = []
for i in range(n):
    results.append(calculate(pairs[i][0], pairs[i][1]))

print("\n".join([str(i) for i in results]))

