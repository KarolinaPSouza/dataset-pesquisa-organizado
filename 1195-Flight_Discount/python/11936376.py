import heapq
import sys

def dij(start, n, edges):
    d = [[] for _ in range(n + 1)]
    for a, b, c in edges:
        d[a].append((b, c))

    cstbfr = [float('inf')] * (n + 1)  # Cost before using discount
    cstcop = [float('inf')] * (n + 1)  # Cost after using discount
    cstbfr[start] = 0

    queue = [(0, start, False)]  # (current cost, node, used discount)

    while queue:
        cost, node, used_coupon = heapq.heappop(queue)

        # Ensure we are processing the correct cost
        if used_coupon and cost > cstcop[node]:
            continue
        if not used_coupon and cost > cstbfr[node]:
            continue

        for neighbor, weight in d[node]:
            if not used_coupon:
                # Normal update without discount
                if cstbfr[neighbor] > cost + weight:
                    cstbfr[neighbor] = cost + weight
                    heapq.heappush(queue, (cstbfr[neighbor], neighbor, False))

                # Using discount on this edge
                discounted_cost = cost + (weight // 2)  # Fixed integer division
                if cstcop[neighbor] > discounted_cost:
                    cstcop[neighbor] = discounted_cost
                    heapq.heappush(queue, (cstcop[neighbor], neighbor, True))
            else:
                # After using discount, only normal updates allowed
                new_cost = cost + weight
                if new_cost < cstcop[neighbor]:
                    cstcop[neighbor] = new_cost
                    heapq.heappush(queue, (new_cost, neighbor, True))

    return min(cstcop[n], cstbfr[n])  # Minimum cost to reach node `n`

def main():
    input_data = sys.stdin.read().split()  # Fixed input reading
    n, m = map(int, (input_data[0], input_data[1]))

    edges = []
    index = 2
    for _ in range(m):
        a, b, c = map(int, (input_data[index], input_data[index+1], input_data[index+2]))
        edges.append((a, b, c))
        index += 3

    print(dij(1, n, edges))

if __name__ == "__main__":
    main()