def curried_add(n):
    # TODO: Addition with currying, without lambda expression
    def curried_add_second(x):
        return x+n
    return curried_add_second


def curried_add_lambda(n):
    # TODO: Addition with currying, with lambda expression
    return lambda x: n+x


def add(x, n):
    return x + n


print(add(2, 3))
# should be 5

add_2 = curried_add(2)
print(add_2(3))
# should be 5

print(curried_add(2)(3))
# should be 5

print(curried_add_lambda(2)(3))
# should be 5
