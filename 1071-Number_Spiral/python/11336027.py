import sys
input = sys.stdin.read

def number_spiral_position(y, x):
    n = max(y, x)
    base = (n - 1) ** 2

    if n % 2 == 1:
        if n == y:
            return base + x
        else:
            return base + 2 * n - y
    else:
        if n == x:
            return base + y
        else:
            return base + 2 * n - x

data = input().split()
t = int(data[0])
results = []


index = 1
for _ in range(t):
    y = int(data[index])
    x = int(data[index + 1])
    results.append(str(number_spiral_position(y, x)))
    index += 2


sys.stdout.write("\n".join(results) + "\n")