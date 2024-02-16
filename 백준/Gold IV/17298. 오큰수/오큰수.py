n = int(input())
nums = list(map(int, input().split()))

stack = []
result = []

for n in nums[::-1]:
  while stack and stack[-1]<=n:
    stack.pop()

  if len(stack)>0:
    result.append(stack[-1])
  else:
    result.append(-1)

  stack.append(n)

print(' '.join(map(str, result[::-1])))