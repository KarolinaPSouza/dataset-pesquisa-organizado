parameters = [int(x) for x in input().split()]
desiredApartmentSizes = [int(x) for x in input().split()]
desiredApartmentSizes.sort()

apartmentSizes = [int(x) for x in input().split()]
apartmentSizes.sort()

eliminatedApartments = 0
applicants = 0
eliminatedApplicants = 0

while eliminatedApplicants < len(desiredApartmentSizes) and eliminatedApartments < len(apartmentSizes):
    difference = apartmentSizes[eliminatedApartments] - desiredApartmentSizes[eliminatedApplicants]
    if abs(difference) <= parameters[2]:
        eliminatedApartments += 1
        applicants += 1
        eliminatedApplicants += 1
    elif difference - parameters[2] < 0:
        eliminatedApartments += 1
    else:
        eliminatedApplicants += 1



print(applicants)