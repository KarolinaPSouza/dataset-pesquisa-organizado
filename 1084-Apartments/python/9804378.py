a = list(map(int, input().split(" ")))
b = sorted(list(map(int, input().split(" "))))
c = sorted(list(map(int, input().split(" "))))

apartment = 0
applicant = 0
match = 0

while True:
    if apartment > a[1] - 1 or applicant > a[0] - 1:
        break
    else:
        if b[applicant] >= c[apartment] - a[2]:
            if b[applicant] <= c[apartment] + a[2]:
                match += 1
                applicant += 1
                apartment += 1
            else:
                apartment += 1
        else:
            applicant += 1
print(match)