def bellman_ford(n, aristas):
    infinito = 10**9  # Un valor grande para representar infinito

    # Como se empieza desde el nodo 1, usamos una lista de tamaño n+1 (ignoramos el índice 0)
    distancia = [infinito] * (n + 1)
    padre = [-1] * (n + 1)

    hay_ciclo = -1  # Variable para detectar ciclos negativos

    distancia[1] = 0  # El nodo de inicio es 1, su distancia a sí mismo es 0

    # Relajamos todas las aristas n veces
    for _ in range(n):
        hay_ciclo = -1

        for origen, destino, peso in aristas:  # Si encontramos una mejor distancia, la actualizamos
            if (distancia[origen] + peso) < distancia[destino]:
                distancia[destino] = distancia[origen] + peso  # Actualizamos la distancia mínima
                padre[destino] = origen  # Guardamos el camino
                hay_ciclo = destino  # Si hay actualización en la iteración n, hay un ciclo negativo

    # Si no hubo actualizaciones en la última iteración, no hay ciclo negativo
    if hay_ciclo == -1:
        print("NO")
        return

    # Identificamos un nodo dentro del ciclo negativo
    for _ in range(n):
        hay_ciclo = padre[hay_ciclo]

    # Reconstruimos el ciclo negativo
    ciclo = []
    nodo = hay_ciclo

    while True:
        ciclo.append(nodo)
        if nodo == hay_ciclo and len(ciclo) > 1:
            break
        nodo = padre[nodo]  # Seguimos el camino hasta cerrar el ciclo

    ciclo.reverse()  # Ordenamos el ciclo en el orden correcto
    print("YES")
    print(" ".join(map(str, ciclo)))


# Lectura de entrada
n, m = map(int, input().split())  # n: número de nodos, m: número de aristas

aristas = []  # Lista para almacenar las conexiones

for _ in range(m):
    a, b, c = map(int, input().split())  # Nodo origen, nodo destino, peso de la arista
    aristas.append((a, b, c))

bellman_ford(n, aristas)