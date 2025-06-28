class FunctionClassAssignment():
    def subFields():
        subLists=["Machine Learning","Neural Networks","Vision","Robotics","Speech Processing","Natural Language Processing"]
        print("Sub-fields in AI are:")
        for list in subLists:
            print(list)

    def oddEven():
        num = int(input("Enter the number"))
        if(num % 2 == 0):
            print(num," is an even number")
        else:
            print(num," is an odd number")

    def elegible():
        age = int(input("Your age :"))
        gender = input("Your Gender :")
        if(age >= 18):
            print("ELIGEABLE ")
        else:
            print("NOT ELIGIABLE")

    def percentage():
        total = 0
        subjectsMark = [34,76,98,89,100]
        for index, mark in enumerate(subjectsMark):
            print(f"Subject {index + 1}: Mark = {mark}")
            total += mark 
        return total,":",total/len(subjectsMark)

    def traingale():
        height=int(input("Height:"))
        breadth=int(input("Breadth:"))
        print("Area formula:(height*breadth)/2")
        print("Area of Triangle:",(height*breadth)/2)
        print("Height1:",height)
        print("Height2",height)
        print("Breadth",breadth)
        print("Perimeter formula: Height1+Height2+Breadth")
        print("Perimeter of Triangle:",height+height+breadth)