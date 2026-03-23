n, m, k = map(int, input().split())

apartments = list(map(int, input().split()))
applicants = list(map(int, input().split()))

applicants.sort()
apartments.sort()
left = 0
ans = 0

for app in applicants:

    while left < n and apartments[left] < app - k:
        left += 1

    if left < n and apartments[left] <= app + k:
        left += 1
        ans += 1


print(ans)