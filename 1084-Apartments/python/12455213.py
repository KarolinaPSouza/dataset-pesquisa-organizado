def allocate_apartments(n, m, k, applicants, apartments):
    applicants.sort()
    apartments.sort()

    i, j = 0, 0  # Two pointers
    count = 0

    while i < n and j < m:
        if apartments[j] < applicants[i] - k:  # Apartment is too small
            j += 1
        elif apartments[j] > applicants[i] + k:  # Apartment is too large
            i += 1
        else:  # Apartment is suitable
            count += 1
            i += 1
            j += 1

    return count

# Reading input
n, m, k = map(int, input().split())
applicants = list(map(int, input().split()))
apartments = list(map(int, input().split()))

# Output result
print(allocate_apartments(n, m, k, applicants, apartments))