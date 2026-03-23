# apartments: https://cses.fi/problemset/task/1084

# from bisect import bisect_left 
# def num_approved_applicants(req, sizes, k):
#     n = len(req)
#     m = len(sizes)
#     req.sort()
#     sizes.sort()

#     # print(req, sizes, k)
#     count=0

#     for i in range(n):
#         if len(sizes)==0:
#             break
#         idx = bisect_left(sizes, req[i])
#         if len(sizes)==1:
#             if req[i]-k<=sizes[0]<=req[i]+req[k]:
#                 count+=1
#                 continue
#         if idx==0:
#             if req[i]-k<=sizes[idx]<=req[i]+k:
#                 sizes = sizes[idx+1:]
#                 count+=1
#                 continue
#         elif idx==len(sizes):
#             if req[i]-k<=sizes[idx-1]<=req[i]+k:
#                 sizes = sizes[:idx-1]
#                 count+=1
#                 continue
#         elif idx>0 and idx<=len(sizes)-1:
#             # print(i, idx, sizes)
#             if req[i]-k<=sizes[idx-1]<=req[i]+k:
#                 if idx>=2:
#                     sizes = [*sizes[:idx-2],*sizes[idx:]]
#                 else:
#                     sizes = sizes[idx:]
#                 count+=1
#                 continue

#             if req[i]-k<=sizes[idx]<=req[i]+k:
#                 if idx<len(sizes)-1:
#                     sizes = [*sizes[:idx],*sizes[idx+1:]]
#                 elif idx==len(sizes)-1:
#                     sizes = sizes[:idx]
#                 count+=1
#                 continue

#     return count

# # n,m,k = 4, 3, 5
# # requirements = [60, 45, 80, 60]
# # sizes = [30, 60, 75]

def num_approved_applicants(req, sizes, n,m,k):

    req.sort()
    sizes.sort()
    r_ptr = 0
    s_ptr = 0
    approved = 0
    while r_ptr<n and s_ptr<m:
        min_s = req[r_ptr]-k
        max_s = req[r_ptr]+k
        if min_s <= sizes[s_ptr] <= max_s:
            r_ptr+=1
            s_ptr+=1
            approved+=1
        elif sizes[s_ptr]<min_s:
            s_ptr+=1
        elif sizes[s_ptr]>max_s:
            r_ptr+=1

    return approved

n,m,k = list(map(int, input().split()))
requirements = list(map(int, input().split()))
sizes = list(map(int, input().split()))

result = num_approved_applicants(requirements, sizes,n,m, k)
print(result)