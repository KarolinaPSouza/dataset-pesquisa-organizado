t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    if a >= b:
        print((a-1)**2+b if a & 1 else a**2-(b-1))
    else:
        print(b**2-(a-1) if b & 1 else (b-1)**2+a)