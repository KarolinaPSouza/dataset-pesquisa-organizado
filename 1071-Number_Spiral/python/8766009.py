count = int(input())
for x in range(0, count):
    x, y = [ int(v) - 1 for v in input().split(" ") ]
    diag_term = max(x, y)
    diag = diag_term * diag_term + diag_term + 1
    if x == y:
        print(diag)
    elif diag_term == y:
        d = -1 if diag_term % 2 else 1
        print((diag_term - x) * d + diag)
    elif diag_term == x:
        d = 1 if diag_term % 2 else -1
        print((diag_term - y) * d + diag)