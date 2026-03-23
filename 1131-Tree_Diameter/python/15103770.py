import sys
from collections import deque, defaultdict


sys.setrecursionlimit(200010) 

def bfs(start_node, adj):
    """
    executa uma busca em largura (bfs) a partir de um nó inicial
    para encontrar o nó mais distante e a distância até ele.
    retorna: (farthest_node, max_dist)
    """
    queue = deque([(start_node, 0)]) # (nó, distância)
    visited = {start_node}

    max_dist = 0
    farthest_node = start_node

    while queue:
        curr_node, dist = queue.popleft()

        # atualiza o nó mais distante encontrado
        if dist > max_dist:
            max_dist = dist
            farthest_node = curr_node

        # adiciona vizinhos não visitados à fila
        for neighbor in adj[curr_node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, dist + 1))

    return farthest_node, max_dist

def main():
    """
    função principal para ler a entrada e resolver o problema.
    """
    try:
        n_str = sys.stdin.readline()
        if not n_str:
            return

        n = int(n_str.strip())

        # caso especial: uma árvore com 1 nó tem diâmetro 0
        if n == 1:
            print(0)
            return

        adj = defaultdict(list)

        for _ in range(n - 1):
            line = sys.stdin.readline()
            if not line:
                break
            a, b = map(int, line.split())
            adj[a].append(b)
            adj[b].append(a)

        # --- o algoritmo padrão para diâmetro da árvore (2 bfs) ---

        # 1. primeira bfs:
        #    começa de um nó arbitrário (ex: 1) e encontra
        #    o nó (farthest_node_1) mais distante dele.
        farthest_node_1, _ = bfs(1, adj)

        # 2. segunda bfs:
        #    começa do nó encontrado (farthest_node_1) e encontra
        #    o nó mais distante dele. a distância é o diâmetro.
        _, diameter = bfs(farthest_node_1, adj)

        print(diameter)

    except EOFError:
        pass
    except Exception as e:
        # para debug:
        # print(f"erro: {e}", file=sys.stderr)
        pass

main()