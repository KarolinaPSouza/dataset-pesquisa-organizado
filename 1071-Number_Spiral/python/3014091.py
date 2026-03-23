n = int(input())

res = []

for i in range(n):
    row, col = [int(x) for x in input().split()]
    bigger_coord = max(row, col)

    a, b = 1, 1
    if bigger_coord % 2 == 0:
        a, b = bigger_coord, 1
    else:
        a, b = 1, bigger_coord

    max_val = bigger_coord * bigger_coord

    row_diff = abs(a - row)
    col_diff = abs(b - col)

    res.append(max_val - row_diff - col_diff)

print("\n".join(map(str, res)))




