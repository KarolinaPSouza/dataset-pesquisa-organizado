n, m, k = list(map(int, input().split()))

def binary_search(arr, target, start = 0):
    l = start 
    r = len(arr)

    while l < r:
        mid = (l + r)//2 

        if arr[mid] < target:
            l = mid + 1
        else: 
            r = mid
    return l


applicants = list(map(int, input().split())) 
apartments = list(map(int, input().split()))

applicants.sort()
apartments.sort()

# print(apartments)
# print(applicants)
res = s = 0
for num in apartments:
    if s >= len(applicants): break

    lower_bound = num - k 
    upper_bound = num + k +1
    lower_bound = binary_search(applicants, lower_bound, s)
    upper_bound = binary_search(applicants, upper_bound, s)


    if upper_bound < len(applicants) and upper_bound - lower_bound < 1:
        if abs(applicants[upper_bound] - num) <= k: 
            res +=1
            s = upper_bound + 1
            # print(f"{num} lower_bound {lower_bound} upper_bound {upper_bound}")
            # print(f"found {applicants[upper_bound]} {num}")
    else: 
        for i in range(lower_bound, min(upper_bound+1, len(applicants))):
            if abs(num - applicants[i]) <= k: 
                # print(f"{num} lower_bound {lower_bound} upper_bound {upper_bound} {s} {i}")
                # print(f"found {applicants[i]} {num} {abs(num - applicants[i])}")
                res += 1
                s = i + 1
                break

print(res)