for i in range(int(input())):
    x,y=map(int,input().split())
    m=max(x,y)
    c=m**2 - m +1
    if(x==y):
        print(c)
    elif(m%2==0):
        '''if(x==m):
            ans=x-y
            print(ans+c)
        elif(y==m):
            ans=y-x
            print(c-ans)'''
        print(c+x-y)    
    elif(m%2!=0):
        '''if(y==m):
            ans=y-x
            print(c+ans)
        elif(x==m):
            ans=x-y
            print(c-ans) '''
        print(c+y-x)