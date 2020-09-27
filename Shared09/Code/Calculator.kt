
package learnKotlin;

fun sum(x: Int, y: Int) : Int { return x + y }
fun sub(x: Int, y: Int) : Int { return x - y }
fun sum3(x: Int, y: Int, z: Int) : Int { return x + y + z }

fun calculator(x: Int, y: Int, operation: (Int, Int) -> Int ) : Int { 
	return operation(x, y)
}

fun main() {
	val a = 10
	val b = 20
	var result: Int

	result = calculator(a, b, ::sum)
	println("Result : $result")

	result = calculator(a, b, ::sub)
	println("Result : $result")

	// What Is The Type of something variable
	var something: (Int, Int) -> Int = ::sum
	something = ::sum3 // (Int, Int, Int) -> Int

	result = something(100, 200)
	println("Result : $result")

}
