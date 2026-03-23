def max_applicants_with_apartments():
    n, m, k = map(int, input().split())
    applicants = list(map(int, input().split()))
    apartments = list(map(int, input().split()))
    applicants.sort()
    apartments.sort()

    i = 0 
    j = 0 
    count = 0 

    while i < n and j < m:
        if abs(applicants[i] - apartments[j]) <= k:
            count += 1
            i += 1
            j += 1
        elif apartments[j] < applicants[i] - k:
            j += 1
        else:
            i += 1

    print(count)

max_applicants_with_apartments()