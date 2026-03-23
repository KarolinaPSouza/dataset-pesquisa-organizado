n, m, k = [int(x) for x in input().split()]
apts = [sorted([int(x) for x in input().split()]), sorted([int(x) for x in input().split()])]
count, i, j = 0, 0, 0
while i < len(apts[0]) and j < len(apts[1]):
    if abs(apts[0][i] - apts[1][j]) <= k:
        i += 1
        j += 1
        count += 1
    elif apts[0][i] < apts[1][j]:
        i += 1
    else:
        j += 1
print(count)