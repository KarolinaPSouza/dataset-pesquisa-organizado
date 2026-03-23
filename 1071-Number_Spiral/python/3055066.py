t = int(input())
for i in range(t):
    s = input().rstrip().split(' ')

    a = int(s[0])
    b = int(s[1])

    if a <= b:
        if b % 2 == 0:
            print((b-1)**2 + 1 + a - 1)
        else:
            print(b**2 - a + 1)
    else:
        if a % 2 == 0:
            print(a**2 - b + 1)
        else:
            print((a-1)**2 + 1 + b - 1)