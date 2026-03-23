def solve_spiral(y, x):

    layer = max(y, x)

    diagonal_number = layer**2 - layer + 1

    if layer % 2 == 1:  
        if y == layer:
            result = diagonal_number - (layer - x)
        else:  
            result = diagonal_number + (layer - y)
    else:
        if x == layer:  
            result = diagonal_number - (layer - y)
        else:
            result = diagonal_number + (layer - x)

    return result

t = int(input())

for _ in range(t):
    y, x = map(int, input().split())
    result = solve_spiral(y, x)
    print(result)