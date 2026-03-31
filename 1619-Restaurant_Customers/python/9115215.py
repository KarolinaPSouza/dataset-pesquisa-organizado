momento = 0
i =0
j = 0

max_clientes = int(input())
entrada =[]
saida = []

for i in range(max_clientes):
  In, Out = map(int, input().split())
  entrada.append(In)
  saida.append(Out)

entrada.sort()
saida.sort()
i =0
j=0
res = 0
while i < max_clientes:
    if entrada[i] < saida[j]:  
        momento += 1
        i += 1
    else:  
        momento -= 1
        j += 1
    res = max(res, momento)
print(res)

