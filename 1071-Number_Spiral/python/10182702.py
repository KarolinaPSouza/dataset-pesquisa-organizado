import sys
input = sys.stdin.read
data = input().splitlines()
t = int(data[0])
pos = [tuple(map(int, data[i].split())) for i in range(1, t + 1)]

for r, c in pos:
    layer = max(r, c)
    s = (layer - 1)**2
    if layer & 1:
        if r == layer:
            print(s + c)
        else:
            print(s + (2 * c) - r)
    else:
        if r == layer:
            print(s + (2 * r) - c)
        else:
            print(s + r)