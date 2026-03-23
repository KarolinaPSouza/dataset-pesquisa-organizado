n, m, k = map(int, input().split())

apartments = list(map(int, input().split()))
applicants = list(map(int, input().split()))

apartments.sort()
applicants.sort()

i = 0
j = 0
count = 0

while i < n and j < m:
    if apartments[i] - k > applicants[j]:
        j += 1
    elif apartments[i] + k < applicants[j]:
        i += 1
    else:
        count += 1
        j += 1
        i += 1

print(count)