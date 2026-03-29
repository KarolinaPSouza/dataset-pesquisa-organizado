def binary_search(start: int, end_days: list) -> int:
    low, high = 0, len(end_days) - 1
    while low <= high:
        mid = (low + high) // 2
        if end_days[mid] < start:
            low = mid + 1
        else:
            high = mid - 1
    return high

# Leitura do número de projetos
n = int(input().strip())

# Leitura dos projetos
projects = []
for _ in range(n):
    a, b, p = map(int, input().strip().split())
    projects.append((a, b, p))

# ordena pelo dia final
projects.sort(key=lambda x: x[1])

dp = [0] * len(projects) # quantidade máxima de dinheiro para cada projeto
end_days = [project[1] for project in projects] # dias finais dos projetos

for i in range(len(projects)):
    start, _, reward = projects[i]

    # busca o último projeto que não se sobrepõe ao projeto atual usando busca binária
    j = binary_search(start, end_days)

    # Calcular a quantidade máxima de dinheiro até o projeto atual
    if j != -1:
        dp[i] = max(dp[i - 1], dp[j] + reward) # escolher o projeto atual ou não
    else:
        dp[i] = max(dp[i - 1], reward) # escolher o projeto atual ou não

# quantidade máxima de dinheiro, que é a última posição do vetor dp
print(dp[-1])