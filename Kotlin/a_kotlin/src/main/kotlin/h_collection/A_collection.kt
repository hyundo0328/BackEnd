package h_collection

fun main(){
    // Immutable List
    val list = listOf(1,2,3,4,5)

    // Mutable List
    val mutableList = mutableListOf<Int>(1,2,3,4,5)

    mutableList.addLast(0)
    println(list)
    println(mutableList)

    println("===========================")
    // Immutable Set
    val set = setOf(1,2,3,4,5,6)
    // Mutable Set
    val mutableSet = mutableSetOf(1,2,3,3,4)

    println(set)
    println(mutableSet)
    println("===========================")

    //
    val map = mapOf(Pair("name", "hmd"), Pair("age", "100"))
    println(map)
    val ageMap = mapOf("hmd" to 30, "ask" to 20)
    println(ageMap)
    println(map["name"])
}