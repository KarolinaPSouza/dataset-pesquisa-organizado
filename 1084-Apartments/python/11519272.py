n, m, k = map(int, input().split())
size = list(map(int,input().split()))
each = list(map(int,input().split()))
size.sort()
each.sort()
s = 0
e = 0
counter = 0
while s < n and e < m:
    if (size[s] - k) <= each[e] <= (size[s] + k):
        counter += 1
        s += 1
        e += 1
    elif each[e] > size[s]:
        s += 1
    else:
        e += 1
print(counter)