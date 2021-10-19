
from protobuf import shopping_pb2

file_path = "../store"

# create an object ShoppingList
shopping_list = shopping_pb2.ShoppingList()


def addToShoppingList(name, amount):
    # creates a new item object??
    item = shopping_list.items.add()
    item.name = name
    item.amount = amount

def printShoppingList():
    print(shopping_list.items)
    print(shopping_list.SerializeToString())

print("Hello Protobuf")
# read file with serialized data and transform to python object
try:
    f = open(file_path, "rb")
    shopping_list.ParseFromString(f.read())
    f.close()
except IOError:
    print("could not open file")

# print
printShoppingList()
# add one item to shopping list
addToShoppingList("Haus", 3)
# print
printShoppingList()

# write back to file
f = open(file_path, "wb")
f.write(shopping_list.SerializeToString())
f.close()


