n, m, k = map(int, input().split())
desired = sorted(list(map(int, input().split())))
apartments = sorted(list(map(int, input().split())))

# Two pointers solution. 
# Loop through the array of applicants, and keep track of a pointer j that
# goes through the array of apartment sizes. If the apartment is too small
# move to the next one. If you find one in the correct range move to the next
# one.

ans = 0
j = 0
for i in range(n):
    while j < m and apartments[j] < desired[i] - k:
        j += 1

    if j < m and apartments[j] <= desired[i] + k:
        ans += 1
        j += 1
print(ans)