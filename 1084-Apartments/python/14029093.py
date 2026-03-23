n, m, k = map(int, input().split())
a = list(map(int, input().split()))  # desired sizes
b = list(map(int, input().split()))  # apartment sizes

a.sort()
b.sort()

i = j = count = 0

while i < n and j < m:
    if b[j] < a[i] - k:
        j += 1  # apartment too small
    elif b[j] > a[i] + k:
        i += 1  # apartment too big for current applicant
    else:
        count += 1  # match found
        i += 1
        j += 1

print(count)