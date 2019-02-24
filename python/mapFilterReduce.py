# map(function, iterable): returns a
def incrementer(elem):
    return elem + 1

x = [2, 3, 4, 5, 6]
print(x)
y = map(incrementer, x)
print(list(y))
z = map(lambda i: i + 1, x)
print(list(z))