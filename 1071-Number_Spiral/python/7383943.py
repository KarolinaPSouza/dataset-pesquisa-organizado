n = int(input())

answers = []

def magic(y,x):
    if y >= x:
        n = y
        d = x
    else:
        n = x
        d = y      

    u = n**2
    l = u - 2*n + 2     # l = (n-1)**2 + 1 = n**2 - 2*n + 2 = u -2*n + 2 

    if y >= x:
        if n%2 == 1: # increasing
            answers.append(l + d - 1)
        else: # decreasing
             answers.append(u - d + 1)
    else:
        if n%2 == 1: # decreasing
             answers.append(u - d + 1)
        else:   # increasing
             answers.append(l + d - 1)


for i in range(n):
    row, col = input().split()
    magic(int(row),int(col))

print("\n".join(map(str,answers)))