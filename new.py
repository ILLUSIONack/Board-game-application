contain = [1,2,3,4,5,6,7,8,9,10]

start = contain[0]
end = int(contain[len(contain)-1])

def list_checker(n):
    for x in contain:
        middle = (end - start) // 2
        the_list = contain[middle]
        print(the_list)
        if n > the_list:
            the_list = contain[middle + 1]
        elif n == the_list:
            print(str(n) +  "is in the list")

        else:
            the_list = contain[middle - 1]

list_checker(4)


            
    
