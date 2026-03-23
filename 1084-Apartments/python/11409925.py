def allocate_apartments():
    import sys
    input = sys.stdin.read
    data = input().split()


    n, m, k = map(int, data[:3])
    applicants = list(map(int, data[3:3 + n]))
    apartments = list(map(int, data[3 + n:]))


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
allocate_apartments()