cases = int(input())

for i in range(cases):

    a,b = map(int,input().split())

    n = max(a,b)
    k = n - min(a,b)
    if(a == b):
        print(n**2 -n +1)
    else:
        if(n%2 == 0):
            if(a>b):
                print((n**2 - n + 1) + k)
            elif(a<b):
                print((n**2 - n + 1) - k)
        else:
            if(a>b):
                print((n**2 - n + 1) - k)
            elif(a<b):
                print((n**2 - n + 1) + k)