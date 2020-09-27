// Simulate Following Scenario In Java

package learnKotlin;

// SOLID Principles
// 		S : Single Responsibity Design
//		O : Open For Extension But Close Modifcation

// interface Superpower
interface Superpower {
	fun fly()
	fun saveWorld()
}

// Seen
// class Spiderman implements Superpower
// class Spiderman extend Superpower

// Single Responsibility Design
class Spiderman : Superpower {
	override fun fly() 			{ println("Fly Like Spiderman!") }
	override fun saveWorld()	{ println("SaveWorld Like Spiderman!") }
}

// Single Responsibility Design
// Seen
class BadSuperman : Superpower {
	override fun fly() 			{ println("Fly Like Superman!") }
	override fun saveWorld()	{ println("SaveWorld Like Superman!") }
}


class Superman : Superpower {
	override fun fly() 			{ println("Fly Like Superman!") }
	override fun saveWorld()	{ println("SaveWorld Like Superman!") }
}


// Seen
class Heman : Superpower {
	override fun fly() 			{ println("Fly Like Heman!") }
	override fun saveWorld()	{ println("SaveWorld Like Heman!") }
}

// Seen
class Wonderwoman : Superpower {
	override fun fly() 			{ println("Fly Like Wonderwoman!") }
	override fun saveWorld()	{ println("SaveWorld Like Wonderwoman!") }
}

class HanumanJi : Superpower {
	override fun fly() 			{ println("Fly Like HanumanJi!") }
	override fun saveWorld()	{ println("SaveWorld Like HanumanJi!") }	
}

//class Human : Spiderman() { 
// class Human : Superman() { 
// Desire
// class Human extends Superman

// class Human : Heman() { 
// 	override fun fly() 			{ super.fly() }
// 	override fun saveWorld() 	{ super.saveWorld() }
// }

// Composition Design Pattern
// Single Responsibilty Design
// Open For Extension(More Functionality) But Close For Modifcation
class Human {
	var power: Superpower? = null. // Human Has Power Is Zero
 
	fun fly() 			{ power?.fly() }
	fun saveWorld() 	{ power?.saveWorld() }
}

fun main() {
	var h = Human()

	// h.power = BadSuperman()
	h.power = null

	h.power = Superman()
	h.fly()
	h.saveWorld()

	var sp = Spiderman()
	sp.fly()
	sp.saveWorld()

	h.power = Superman()
	h.fly()
	h.saveWorld()

	h.power = Spiderman()
	h.fly()
	h.saveWorld()

	h.power = Heman()
	h.fly()
	h.saveWorld()

	h.power = Wonderwoman()
	h.fly()
	h.saveWorld()

	h.power = HanumanJi()
	h.fly()
	h.saveWorld()
}
