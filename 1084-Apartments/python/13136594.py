n, m, k = map(int, input().split())
applicants = list(map(int, input().split()))
apartments = list(map(int, input().split()))

applicants.sort()
apartments.sort()

i = 0  # applicant pointer
j = 0  # apartment pointer
count = 0

while i < n and j < m:
    if apartments[j] < applicants[i] - k:
        # Apartment too small, try next apartment
        j += 1
    elif apartments[j] > applicants[i] + k:
        # Apartment too big, try next applicant
        i += 1
    else:
        # Apartment fits applicant
        count += 1
        i += 1
        j += 1

print(count)