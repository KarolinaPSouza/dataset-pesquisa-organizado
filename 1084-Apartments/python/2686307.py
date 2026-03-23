#stick lengths
# n = int(input())
# ls = [int(i) for i in input().split()]
# ls.sort()
# mid = n // 2
# ans = sum(ls[mid + n%2 :]) - sum(ls[:mid])
# print(ans)
#apartments
# n,m,k = map(int,input().split())
# app = list(map(int,input().split()))
# depart = list(map(int,input().split()))
# temp = 0
# app.sort()
# depart.sort()
# count = 0
# i,j = 0,0
# while i<n and j<m:
#   if depart[j] >= app[i]-k or depart[j]<=app[i]+k:
#     app[i] = -1
#     depart[j] = -1-k-1
#     i+=1
#     j+=1
#     count+=1
#   if depart[j]<=app[i]-k:
#     j+=1
#   else:
#     i+=1
# print(count)
#Ferris wheel
# def min_gondolas(w, x): 
#   count = 0
#   left, right = 0, len(w) - 1
#   while left <= right:
#     if w[left] + w[right] <= x:
#       left += 1
#     right -= 1            
#     count += 1
#   return count
# n, x = map(int, input().split())
# weights = [int(i) for i in input().split()]
# print(min_gondolas(sorted(weights), x))

#Movie Festival II
# import bisect
# n, k = map(int, input().split())
# movies = []
# for i in range(n):
#   movies.append(list(map(int, input().split())))
# movies.sort(key = lambda x:x[1])
# memberTime, c = [0 for _ in range(k)], 0
# for movie in movies:
#   time = bisect.bisect(memberTime, movie[0]) - 1
#   if time == -1:
#     pass
#   else:
#     c+=1
#     memberTime[time] = movie[1]
#     temp = memberTime.pop(time)
#     memberTime.insert(bisect.bisect(memberTime, temp), temp)
# print(c) 


from math import inf


def max_applicants(room_sizes, desired, max_diff): # O(n)
    i, j, count = 0, 0, 0

    while i < len(room_sizes) and j < len(desired):
        if abs(room_sizes[i] - desired[j]) <= max_diff:
            count += 1
            i += 1
            j += 1
        elif room_sizes[i] > desired[j]:
            j += 1
        else:
            i += 1
    return count


def max_applicants_naive(sizes, desired, diff): # simple O(n^2)
    count = 0

    for app in desired:
        for i, size in enumerate(sizes):
            if abs(app - size) <= diff:
                sizes[i] = inf

                count += 1
                break

    return count
n, m, k = map(int, input().split())
desired = [int(i) for i in input().split()]
sizes = [int(i) for i in input().split()]

print(max_applicants(sorted(sizes), sorted(desired), k))