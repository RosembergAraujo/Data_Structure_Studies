from Tools import Node, HashTable

hashT = HashTable()

hashT.append("c1", 11)\
    .append("c2", 22)\
    .append(True, 44)

res = [hashT.get("c1"), hashT.get("c2"), hashT.get(True)]

print(f"GET: {res}\nTABLE: {hashT}")

