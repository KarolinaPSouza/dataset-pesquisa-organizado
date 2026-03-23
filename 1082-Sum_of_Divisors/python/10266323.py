def divsum(k):
    out=0
    for i in range(1,k+1):
        if k%i == 0:
            out+=i 
    return out 

# for i in range(1, 831369):
#     if (i%1000==0):
#         print("i = ",i)
#     solve[i] = solve[i-1] + divsum(i)
#def slow(k):
    # out=0
    # for i in range(1,k+1):
    #     if (i%1000==0):
    #         print("i = ",i, '/', k)
    #     out += divsum(i)
    #     out %= int(1e9)+7
    # return out 
    #return solve[k]

def fast(n):
    base = 1
    soma = 0
    halfpoint = int(1e5)+1
    MOD = int(1e9)+7
    while n//base >= halfpoint:
        soma += (halfpoint + n//base) * (n//base - halfpoint + 1) // 2 
        soma %= MOD 
        base += 1
    for i in range(1, min(n+1, halfpoint)):
        soma += i * (n // i)
        soma %= MOD 
    return soma

print(fast(int(input())))
# solve = [0]
# for i in range(1, 999999999):
#     solve.append((divsum(i)+solve[-1]) % int(1e9)+7)
#     print(i)
#     if fast(i) != solve[-1]:
#         print(i, fast(i), solve[-1])
#         break