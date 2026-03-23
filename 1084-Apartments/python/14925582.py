def max_applicants(number_of_applicants, number_of_apartments, tolerance, applicant_desired_sizes, apartment_sizes):
    applicant_desired_sizes.sort()
    apartment_sizes.sort()

    applicant_index, apartment_index = 0, 0
    number_matched = 0

    while applicant_index < number_of_applicants and apartment_index < number_of_apartments:
        desired_size = applicant_desired_sizes[applicant_index]
        available_size = apartment_sizes[apartment_index]

        if available_size < desired_size - tolerance:
            apartment_index += 1
        elif available_size > desired_size + tolerance:
            applicant_index += 1
        else:
            number_matched += 1
            applicant_index += 1
            apartment_index += 1

    return number_matched

number_of_applicants, number_of_apartments, tolerance = map(int, input().split())
applicant_desired_sizes = list(map(int, input().split()))
apartment_sizes = list(map(int, input().split()))

number_matched = max_applicants(number_of_applicants, number_of_apartments, tolerance, applicant_desired_sizes, apartment_sizes)
print(number_matched)