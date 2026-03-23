def find_matching_apartments(n, m, k, applicants, apartments):
    applicants.sort()
    apartments.sort()

    i, j = 0, 0
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

def input_arr() :
    n, m, k = map(int, input().split())
    applicants = list(map(int, input().split()))
    apartments = list(map(int, input().split()))
    find_matching_apartments(n, m, k, applicants, apartments)

input_arr()