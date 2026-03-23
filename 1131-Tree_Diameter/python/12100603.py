# !/usr/bin/env python3
# -*- coding: utf-8 -*-

'''
Estructuras de Datos
C - Diameter of Regular Tree
Profesor: David Alberto Herrera Alvarez
 Nombre del Estudiante        
Sergio Nicolas Correa Escobar
'''


# Modulo para lectura rapida estandar de entradas (stdin).
from sys import stdin



''' Solucion '''

# Funcion que realiza un recorrido BFS para encontrar el nodo mas alejado de un nodo dado.
def bfs (start: int, tree: list[list[int]], n: int) -> tuple[int]:
    queue: list = [start]
    visited: list[int] = [-1] * (n + 1)
    visited[start] = 0
    farthest_node: int = start
    max_depth: int = 0
    front: int = 0
    while front < len(queue):
        node = queue[front]
        front += 1
        for neighbor in tree[node]:
            if visited[neighbor] == -1:
                visited[neighbor] = visited[node] + 1
                queue.append(neighbor)  # Ocurre TLE con listas enlazadas propias por no ser óptimas en Python.
                if visited[neighbor] > max_depth:
                    max_depth = visited[neighbor]
                    farthest_node = neighbor
    return farthest_node, max_depth

# Programa principal:
if __name__ == "__main__":
    n: int = int(stdin.readline())

    if n == 1:
        print(0)

    else:
        # Construccion del arbol con listas de nodos vecinos.
        tree: list[list[int]] = [[] for _ in range(n + 1)]
        for _ in range(n-1):
            a,b = map(int, stdin.readline().split())
            tree[a].append(b)   # Ocurre TLE con listas enlazadas propias...
            tree[b].append(a)
        # Primer BFS desde el nodo 1
        farthest_node, _ = bfs(1, tree, n + 1)
        # Segundo BFS desde un nodo extremo.
        _, diameter = bfs(farthest_node, tree, n + 1)

        print(diameter)
