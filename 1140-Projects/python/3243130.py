class Project:
  def __init__(self, start, end, val):
    self.start = start 
    self.end = end
    self.val = val

  def __lt__(self, other):
    return self.end < other.end

  def __repr__(self):
    return '(' + str(self.start) + ',' + str(self.end) + ',' + str(self.val) + ')'

n = int(input())
times = []
projects = []

for i in range(n):
  start, end, val = map(int, input().split())
  projects.append(Project(start, end, val))
  times.append(start)
  times.append(end)


times = list(dict.fromkeys(times))
times.sort()
n = len(times)

d = {}
for i, t in enumerate(times):
  d[t] = i + 1

project_lists = [[] for _ in range(n + 1)]
for project in projects:
  time_end = d[project.end]
  project_lists[time_end].append(project)

dp = [0] * (n + 1)
j = 0

for i in range(1, n + 1):
  cur_time = times[i - 1]
  m = dp[i - 1]

  for project in project_lists[i]:
    time_proj_start = d[project.start]
    m = max(m, project.val + dp[time_proj_start - 1])

  dp[i] = m

print(dp[n])