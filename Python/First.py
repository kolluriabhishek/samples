def getTripletCount(a, d):
    count = 0
    n = len(a)
    for i in range(1, n + 1):
        for j in range(i + 1, n + 1):
            for k in range(j + 1, n + 1):
                s = a[i - 1] + a[j - 1] + a[k - 1]
                if s%d == 0:
                    count += 1
    print(count)
def count_triplets_with_sum_d(arr, d):
    count = 0
    n=len(arr)
    # Create a hash map to store the frequency of each element
    frequency = {}

    # Count the frequency of each element in the array
    for i in range(len(arr)):
       if arr[i] not in frequency.keys():
           frequency[arr[i]]=1
       else:
           frequency[arr[i]] +=1


    for i in range(1, n + 1):
        for j in range(i + 1, n + 1):
            temp = frequency.copy()
            frequency[arr[i-1]] -=1
            frequency[arr[j-1]] -=1

            remaining_value = d - (arr[i-1] + arr[j-1])

            # Check if the remaining value is present in the array
            if frequency[remaining_value] > 0 :
                if(arr.index(remaining_value) > j):
                    count+=1



    print( count)

k = [2,3,1,6]
count_triplets_with_sum_d(k, 3)
