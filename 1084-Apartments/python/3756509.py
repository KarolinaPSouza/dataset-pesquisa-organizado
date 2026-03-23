class Solution:
    def appartments(self,n,m,k,a,b):
        a.sort()
        b.sort()
        cnt=0
        j=0
        for i in range(n):
            l=j
            h=m-1
            low=j
            while(l<=h):
                mid=l+((h-l)>>1)
                if((b[mid]>=(a[i]-k)) and (b[mid]<=(a[i]+k))):
                    if(mid==low):
                        cnt+=1
                        j=mid+1
                        break
                    elif(b[mid-1]>=a[i]-k and b[mid-1]<=a[i]+k): h=mid-1
                    else:
                        cnt+=1
                        j=mid+1
                        break
                elif(b[mid]<a[i]-k): l=mid+1
                else: h=mid-1
        return cnt
if __name__=="__main__":
    n,m,k=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    S=Solution()
    print(S.appartments(n,m,k,a,b))