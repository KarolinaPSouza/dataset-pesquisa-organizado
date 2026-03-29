def solve_dp_to_much_memory(arr):
    arr.sort(lambda x:x[1])
    max_end_time = 0 
    for start_time,end_time,price in arr:
        max_end_time = max(max_end_time,end_time) 

    n = len(arr)

    #this dp takes up too much memory 
    dp = [0 for _ in range(max_end_time+2)] #denotes best money for ith time instance

    # print(len(dp))
    dp[0] = 0 
    for index in range(1,max_end_time+2):
        not_include_current_project = dp[index-1] 
        include_best_before_contest = dp[0] 
        for pre_index in range(n):

            pre_start,pre_end,pre_price = arr[pre_index]

            if pre_end < index:
                include_best_before_contest = max(include_best_before_contest,dp[pre_start] + pre_price)

        dp[index] = max(dp[index],include_best_before_contest,not_include_current_project)

        # print(dp)
    return max(dp)

def solve_dp_limit_mem(arr):
    arr.append( [-1,-1,0])
    arr.sort(lambda x:x[1])

    n = len(arr)

    #this dp takes up too much memory 
    dp = [0 for _ in range(n+1)] #denotes best money for ith time instance

    # print(len(dp))
    dp[0] = 0
    for index in range(1,n+1):
        # print(arr[index-1])
        not_include_current_project = dp[index-1] 
        include_best_before_contest = 0 
        cur_start_time, cur_end, cur_price = arr[index-1]
        for pre_index in range(n):
            pre_start,pre_end,pre_price = arr[pre_index]
            if pre_end < cur_start_time:
                #make sure to add the index 
                include_best_before_contest = max(include_best_before_contest,dp[pre_index+1] + cur_price)

        dp[index] = max(dp[index],include_best_before_contest,not_include_current_project)

        # print(dp)
    return max(dp)



def solve_dp_with_binary_search(arr):
    from bisect import bisect_left
    arr.append( [-1,-1,0])
    arr.sort(lambda x:x[1])

    n = len(arr)
    end_times = [i[1] for i in arr ]

    #dp denotes best value at ith index
    bes_val = [0 for _ in range(n+1)] 

    # print(len(bes_val))
    bes_val[0] = 0
    for index in range(1,n+1): #iterate through all the arr indexes 
        not_include_current_project = bes_val[index-1] 
        include_best_before_contest = 0 
        cur_start_time, cur_end, cur_price = arr[index-1]

        """for loop replaced by binary search"""

        pre_index = bisect_left(end_times,cur_start_time)
        pre_index = max(0,pre_index-1)

        include_best_before_contest = max(include_best_before_contest,bes_val[pre_index+1] + cur_price)

        bes_val[index] = max(bes_val[index],include_best_before_contest,not_include_current_project)

    return max(bes_val)
def solve_rec(arr,cur_time):

    arr.sort(lambda x:x[1])
    max_end_time = 0 
    for start_time,end_time,price in arr:
        max_end_time = max(max_end_time,end_time) 

    if max_end_time < cur_time:
        return 0

    ans = 0 
    for start_time,end_time,price in arr:
        if cur_time < start_time:
            ans = max(ans,solve_rec(arr,end_time) + price)
        print('print',ans)
    return ans 

# arr.sort(lambda x:x[0])
# ans = more_money(arr)

n = int(input())
arr = []
for _ in range(n):
    temp_arr = list(map(int,input().split()))
    arr.append(temp_arr)
# ans = solve_rec(arr,1)
# print(ans)
ans2 = solve_dp_with_binary_search(arr)
print(ans2)

