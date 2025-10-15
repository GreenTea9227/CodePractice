formula = input()
parts = formula.split('-')
print(sum(map(int, parts[0].split('+'))) - sum(sum(map(int, p.split('+'))) for p in parts[1:]))