def main():
    n, m, k = [int(i) for i in input().split()]
    applicants = sorted([int(i) for i in input().split()])
    apt = sorted([int(i) for i in input().split()])
    count = 0
    j = 0
    i = 0
    while i < n and j < m:
        while j < m and apt[j] <= applicants[i] + k:
            if abs(applicants[i] - apt[j]) <= k:
                count += 1
                j += 1
                break
            j += 1
        i += 1
    return count


print(main())