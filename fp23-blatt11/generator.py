import timeit


def nth(gen, n):
    # TODO: function that returns the n-th next element of a generator
    for x in range(0,n):
         next(gen)
    return next(gen)


def example_gen():
    # TODO: function that returns a generator that produces tuples of the form (x, 2x) in the interval [0,99]
    for x in range(0,100):
        yield (x,2*x)

    

def example_list():
    # TODO: function that returns a list that contains all tuples of the form (x, 2x) with x from the interval [0,99]
    l = []
    for x in range(0,100):
        l.append((x,2*x))

    return l


#FileIO in Python

#Lesen
def IOr(filename):
    lines = []
    forbj = open(filename, "r")
    for line in forbj:
          lines+= [line]
    forbj.close()
    return lines

#Schreiben
def IOw():
    forbj = open("file.txt", "w")
    lst =[12,12,123,123,2]
    for x in range(100):
     forbj.write(str(nth(example_gen(),x))+"\n")
    forbj.close()


IOw() #Aufruf der Methode IOw welche in eine Datei schreibet

#Exceptions: Versucht file.txt zu lesen, falls diese exitiert. Ansonsten wird "keine Datei" ausgedruckt
try:
    print(IOr("file.txt"))
except (Exception):
    print("keine Datei")


print(nth(example_gen(), 5))
print(example_list()[5])
print(list(example_gen())[5])
#print(list(example_gen_2())[5]) Ka was das ist war beim Quellcode dabei

print(timeit.timeit(lambda: example_gen()))
print(timeit.timeit(lambda: example_list()))
print(timeit.timeit(lambda: list(example_gen())))

print(timeit.timeit(lambda: nth(example_gen(), 5)))
print(timeit.timeit(lambda: example_list()[5]))
print(timeit.timeit(lambda: list(example_gen())[5]))
