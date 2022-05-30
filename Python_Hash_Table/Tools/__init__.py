from constant import HASH_TABLE_ARRAY_SIZE


class Node:
    def __init__(self, data, key=None):
        self.data = data
        self.key = key
        self.nextNode = None

    def __str__(self):
        return f"{self.data}"


class HashTable:
    len = 0

    def __init__(self):
        self.nodes = [None] * int(HASH_TABLE_ARRAY_SIZE + 1)

    def append(self, key, data):
        hashKey = hash(key) & HASH_TABLE_ARRAY_SIZE
        newNode = Node(data, hashKey)
        if self.nodes[hashKey] is None:
            self.nodes[hashKey] = newNode
        else:
            tmpNode = self.nodes[hashKey]
            while True:
                if tmpNode.nextNode is None:
                    break
                else:
                    tmpNode = tmpNode.nextNode
            tmpNode.next = newNode
        self.len += 1
        return self

    def get(self, key):
        hashKey = hash(key) & HASH_TABLE_ARRAY_SIZE
        if self.nodes[hashKey] is None:
            return None
        if self.nodes[hashKey].key != hashKey:
            tmpNode = self.nodes[hashKey]
            while True:
                if tmpNode.key == hashKey:
                    return tmpNode
                if tmpNode.nextNode is None:
                    return None
                else:
                    tmpNode = tmpNode.nextNode
        return self.nodes[hashKey].data

    def __str__(self) -> str:
        result = "[ "
        for node in self.nodes:
            if node is not None:
                result += f"{node}, "
        result = result[0:len(result) - 2]
        result += " ]"
        return result
