n, m, k = map(int, input().split())
desires = list(map(int, input().split()))
sizes = list(map(int, input().split()))

desires.sort()
sizes.sort()

count = 0
i, j = 0,0

while i < n and j < m:
    if abs(desires[i]-sizes[j]) <= k:
        i += 1
        j += 1
        count += 1
    elif desires[i] - sizes[j] < 0:
        i += 1
    else:
        j += 1
print(count)