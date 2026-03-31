def maximumCustomer(n,enter,leave):
    enter.sort()
    leave.sort()
    n = len(enter)
    i = 0
    j = 0
    cnt = 0
    maxi = 1
    while i<n and j<n:
        if enter[i]<leave[j]:
            cnt+=1
            i+=1
        else:
            cnt-=1
            j+=1
        maxi = max(maxi, cnt)
    return maxi
def main():
    n = int(input())
    enter = []
    leave = []
    for i in range(n):
        a,b = map(int,input().split())
        enter.append(a)
        leave.append(b)
    print(maximumCustomer(n,enter,leave))

main()