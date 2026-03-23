def solve(a, b:list, c:list):
    b.sort()
    c.sort()
    compte = 0
    limit = a[2]
    applicants = a[0]
    appartments = a[1]
    i, j = 0, 0
    while i < applicants and j < appartments:
        if b[i] >= c[j] - limit and b[i] <= c[j] + limit:
            i += 1
            j += 1
            compte += 1
        elif b[i] >= c[j] + limit:
            j += 1
        else:
            i += 1
    return compte

a = list(map(int, input().split(' ')))
b = list(map(int, input().split(' ')))
c = list(map(int, input().split(' ')))
print(solve(a, b, c))