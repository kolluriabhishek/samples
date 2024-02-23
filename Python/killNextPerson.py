#if n people are standing in a circle and first person kills second and hands knife to third &
#third kills fourth and gives knife to 5 and 5 th kills 6 th and soo on print who will be left

def last_person_standing(n):
    # Creating a list of people numbered from 1 to n
    people = []
    for i in range(1,n+1):
        people.append(i)
    temp=[]
    # Loop until only one person is left
    while len(people) > 2:
        l=len(people)
        if(l%2==1):
            temp.append(people[-1])
            people = people[:-1]
        l=len(people)
        for i in range(0,l):
            if(i%2==0):
                temp.append(people[i])
        people = temp.copy();
        temp=[];

    return people[0]

# Input number of people
N = int(input("Enter the number of people: "))

# Call the function and print the last person standing
print("The last person standing is:", last_person_standing(N))
