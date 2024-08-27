
def zeigeArgumente(func):
    def huelle(*args,**kwargs):
        print(args)
        print(kwargs)
        varnames = func.__code__.co_varnames
        count = func.__code__.co_argcount

        for i in range(len(args)):
            print(" name: "+ varnames[i]+ " with value "+ str(args[i]))
        for kVal in kwargs.items():
            print("kname: " + kVal[0] + " with value " + str(kVal[1]))

        return func(*args,**kwargs)
    return huelle


@zeigeArgumente
def subtraktion(w=0,x=0,y=0,z=0):
    a=10
    b=10
    return w-x-y-z

@zeigeArgumente
def summe(w=0,x=0,y=0,z=0):
    a=10
    b=10
    return w+x+y+z

#summe(1,2, z=3, y=4)
subtraktion(2122,3,y=44, z=32)
summe(w=23,x=232)