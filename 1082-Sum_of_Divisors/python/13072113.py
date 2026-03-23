#Resolución del Problema

def MOD(a):
    return (a + 1000000007) % 1000000007


def suma_div(n):
    total = 0
    i = 1
    while i <= n:
        m = n // i
        sig_i = n // m + 1
        cont = sig_i - i
        sum_num = (i + sig_i - 1) * cont // 2
        total += m * sum_num
        i = sig_i
    return MOD(total)

n = int(input())
print(suma_div(n))


#Recopilación de resultados

'''
import time
import random
import matplotlib.pyplot as plt
    casos_prueba = [random.randint(1, 1000000000000) for _ in range(500)]
 resultados = []
tiempo_ejecucion = []
 print("Comenzando pruebas...\n")
 for n in casos_prueba:
    start_time = time.time()
    resultado = suma_div(n)
    end_time = time.time()
    elapsed_time = end_time - start_time
     resultados.append(resultado)
    tiempo_ejecucion.append(elapsed_time)
     print(f"n={n}, resultado={resultado}, tiempo={elapsed_time:.6f} segundos")
  plt.figure(figsize=(12, 6))
plt.scatter(casos_prueba, tiempo_ejecucion, alpha=0.6)
plt.xscale('log')
plt.xlabel('Valor de n (escala logarítmica)')
plt.ylabel('Tiempo de ejecución (segundos)')
plt.title('Tiempo de ejecución de suma_div(n) para diferentes valores de n')
plt.grid(True, which="both", ls="--")
plt.show()
'''
