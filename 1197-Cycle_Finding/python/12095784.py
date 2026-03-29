#IDEA:

# ¿PERO QUÉ PASA SI TODOS LOS PESOS SON NEGATIVOS? Me quedo en un bucle infinito !!
# Alguien creó el método de Bellman Ford:
# Repita N-1 veces.
# Haga el dijkstrak sin priority queue osea el relajando y ahgalo n-1 veces
# Si hace eso 1 vez más osea N veces y puede relajar significa que existe un ciclo engativo.


#Relajar: mejorar la distancia mínima conocida hacia un nodo usando una arista disponible.
#Si la distancia actual a vector1 es finita --> dist[u] diferente de onfinito.
# Y si al tomar la arista o camino (vertice 1 a vertice 2) con peso, encontramos un camino más corto a 
# vertice2 que el conocido (dist[u] + w < dist[v])
# Entonces actualizamos la distancia


def bellman_ford(n, edges):
    inf = 10**9

    #Como se empieza desde el 1, haremos n+1, el 0 no lo miramos
    dist = [inf] * (n+1)
    parent = [-1] * (n+1)

    is_there_cycle = -1

    dist[1] = 0  #Empeiza en el nodo 1

    # Relajamos las aristas n veces --> En verdad sería n-1 pero como empezamos desde 1 y no 0, toca n
    for i in range(n):  

      is_there_cycle = -1

      for vertice1, vertice2, peso in edges:  #Si la nueva distancia es menor a la actual, se actualiza.

        if dist[vertice1] + peso < dist[vertice2]:
          dist[vertice2] = dist[vertice1] + peso #Se actualiza la distancia
          parent[vertice2] = vertice1
          is_there_cycle = vertice2  #Si is_there_cycle cambia, hay una relajación en la iteración n


    if is_there_cycle == -1:

      print("NO")
      return



    #Ya se miró N-1 veces, ahora miramos la itración N, si se cumple, hay un ciclo negativo
    for i in range(n):
      is_there_cycle = parent[is_there_cycle]





    cycle = [] #reconstruir el ciclo
    node = is_there_cycle

    while True:
      cycle.append(node)
      if (node == is_there_cycle) and (len(cycle) > 1):
        break

      node = parent[node] #recorrer arrelgo.


    cycle.reverse()
    print("YES")
    print(" ".join(map(str, cycle)))




#CORRER TODO
n, m = map(int, input().split())

edges = []  #Guardar conexiones.


for i in range(m):
  #node a to node b whose length is c.
  a, b, c = map(int, input().split())  
  edges.append((a, b, c))  


bellman_ford(n, edges)