
class Human:
	def __init__(self, x):
		self.id = x
		self.name = "Ram Singh"

	def getID(self):
		return self.id
	
	def getName(self):
             return self.name
 
h = Human(111)

print(h.getID())
print(h.getName())

def sum(a, b):
	return a + b

print(sum(10, 20))

// Following Lines Can You Do In Java/C++
h.maths = 90
h.add = sum

print(h.maths)
print(h.add(100, 200))

