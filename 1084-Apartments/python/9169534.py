def distribute_apartments(n, m, k, applicant_sizes, apartment_sizes):
    applicant_sizes.sort()
    apartment_sizes.sort()

    num_applicants_getting_apartment = 0
    i, j = 0, 0

    while i < n and j < m:
        if abs(applicant_sizes[i] - apartment_sizes[j]) <= k:
            num_applicants_getting_apartment += 1
            i += 1
            j += 1
        elif applicant_sizes[i] < apartment_sizes[j]:
            i += 1
        else:
            j += 1

    return num_applicants_getting_apartment

def main():
    n, m, k = map(int, input().split())  # Number of applicants, apartments, and max difference
    applicant_sizes = list(map(int, input().split()))  # Desired apartment size of each applicant
    apartment_sizes = list(map(int, input().split()))  # Size of each apartment

    result = distribute_apartments(n, m, k, applicant_sizes, apartment_sizes)
    print(result)

if __name__ == "__main__":
    main()