n, m, k = map(int, input().split())

desired_apartment = list(map(int, input().split()))
available_apartment = list(map(int, input().split()))

desired_apartment = sorted(desired_apartment)
available_apartment = sorted(available_apartment)

i = 0
j = 0

sol = 0
while i < len(desired_apartment) and j < len(available_apartment):
    if desired_apartment[i] - k <= available_apartment[j] and available_apartment[j] <= desired_apartment[i] + k:
        sol += 1
        i = i + 1
        j = j + 1
    elif available_apartment[j] < desired_apartment[i] - k:
        j = j + 1
    elif desired_apartment[i] + k < available_apartment[j]:
        i = i + 1

print(sol)