package learnKotlin;

fun sum(x: Int, y: Int) : Int { return x + y }
fun sub(x: Int, y: Int) : Int { return x - y }

fun calculator(x: Int, y: Int, operation: (Int, Int) -> Int ) : Int { 
	return operation(x, y)
}

fun main() {
	val a = 10, b = 20
	var result: Int

	result = calculator(a, b, ::sum)
	println("Result : $result")

	result = calculator(a, b, ::sub)
	println("Result : $result")
}
