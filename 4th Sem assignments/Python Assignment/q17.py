class PriorityQueue:
    def __init__(self):
        self.queue = []

    def __str__(self):
        return str(self.queue)

    def isEmpty(self):
        return len(self.queue) == 0

    def enqueue(self, item, priority):
        self.queue.append((priority, item))

        self.queue.sort()

    def pop(self):
        return self.queue.pop()[1]


# Test
queue = PriorityQueue()
queue.enqueue("Jane", 4)
queue.enqueue("John", 1)
queue.enqueue("Jill", 3)
queue.enqueue("Jack", 2)
queue.enqueue("Jim", 5)
print(queue)
print(queue.pop())
print(queue.pop())
print(queue.pop())
print(queue)
