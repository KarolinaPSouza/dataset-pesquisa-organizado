def main():
    import sys
    input = sys.stdin.readline

    # Read n (applicants), m (apartments), k (tolerance)
    n, m, k = map(int, input().split())

    # Read desired sizes of applicants
    applicants = list(map(int, input().split()))

    # Read sizes of apartments
    apartments = list(map(int, input().split()))

    # Sort both lists
    applicants.sort()
    apartments.sort()

    i = j = 0
    matches = 0

    # Two-pointer greedy matching
    while i < n and j < m:
        if abs(applicants[i] - apartments[j]) <= k:
            matches += 1
            i += 1
            j += 1
        elif apartments[j] < applicants[i] - k:
            j += 1
        else:
            i += 1

    print(matches)


if __name__ == "__main__":
    main()