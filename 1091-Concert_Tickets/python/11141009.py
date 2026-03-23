import bisect

n,m = map(int,input().split())
ticket = sorted(map(int,input().split()))
cust = [int(i) for i in input().split()]

ptr = list(range(n+1))

def find(idx):
    if idx != ptr[idx]:
        ptr[idx] = find(ptr[idx])
    return ptr[idx]

for i in cust:
    idx = bisect.bisect_right(ticket,i)
    # if index and ptr[index] match then its available else ptr[index] should give different available location

    if idx == 0:
        print(-1)
    else:
        idx = find(idx-1)
        # while idx != ptr[idx]:
        #     idx = ptr[idx]

        if idx < 0 or idx >=n :
            print(-1)
        else:
            print(ticket[idx])
            ptr[idx] = find(idx-1)    # ticket.remove(ticket[idx-1])


