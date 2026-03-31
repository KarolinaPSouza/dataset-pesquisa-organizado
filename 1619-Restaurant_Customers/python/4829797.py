n = int(input())

inp = []
out = []
for _ in range(n):
    i, o = map(int, input().split())
    inp.append(i)
    out.append(o)

inp.sort()
out.sort()

i, j, curr, maxp = 0, 0, 0, 0
while i < n and j < n:
    if inp[i] < out[j]:
        i += 1
        curr += 1
    elif inp[i] > inp[j]:
        j += 1
        curr -= 1
    else:
        i += 1
        j += 1
    if curr > maxp:
        maxp = curr

print(maxp)