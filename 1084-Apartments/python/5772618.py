n , m , k = [int(x) for x in input().split()]
applicants = [int(x) for x in input().split()]
apartments = [int(x) for x in input().split()]

apartments.sort()
applicants.sort()
result = 0
apartment = 0
applicant = 0
while applicant != len(applicants) and apartment != len(apartments) :
    if apartments[apartment] >= applicants[applicant] - k and apartments[apartment] <= applicants[applicant] + k :
        apartment += 1
        applicant += 1
        result += 1
    elif apartments[apartment] > applicants[applicant] :
        applicant += 1
    else :
        apartment += 1           
print(result)
