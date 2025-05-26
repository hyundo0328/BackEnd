package d_function

fun main(){
    println(add(100,200))
    println(sub(100,200))
    println(divide(10.3,5.1))
    println(printNumber(100))
    println(divideType(10.4, 10.4))

    // 마지막 매개변수가 함수타입일 경우
    // it: 람다의 매개변수가 1개일 경우 사용할 수 있는 암시적 이름 {it % 2 == 0}
    println(filter(listOf(1,2,3,4,5,6,7,8,9)) {it % 2 == 0})

    println(map(listOf(1,2,3,4,5,6,7,8,9)) { "$it 번!!" })
}

fun add(a:Int, b:Int):Int{
    return a + b
}

val sub = fun(a:Int, b:Int):Int{
    return a-b
}

val divide = {a:Double, b:Double ->
    println(a)
    println(b)
    a/b // 마지막에 사용한 표현식이 return이 됨
}

// 타입 추론이 불가능한 경우
val divideType: (a:Double, b:Double) -> Double = {a,b -> a/b}

val printNumber = {a:Int ->
    println(a) // return: kotlin.Unit
}


// filter 구현
fun <E> filter(list:List<E>, callback:(e:E) -> Boolean): MutableList<E>{
    val res = mutableListOf<E>()
    // list.forEach { e: E -> if(callback(e)) res.addLast(e) }
    list.forEach { if(callback(it)) res.addLast(it) }
    return res
}

fun <E, T> map(list: List<E>, callback: (e: E) -> T): MutableList<T> {
    val res = mutableListOf<T>()

    list.forEach { res.addLast(callback(it)) }

    return res
}