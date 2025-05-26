package a_type

fun main(){

    // Byte, Short, Int, Long, Float, Double
    val xByte: Byte = 1
    val xShort: Short = 10
    val xInt: Int = 100
    val xLong: Long = 10000000
    val xFloat: Float = 1.11f
    val xDouble: Double = 1.1

    // Char, String
    val xChar: Char = 'A'
    val xString: String = "Hello Kotlin"

    // Boolean
    val xBoolean = true
    println(xBoolean::class.simpleName)

    // Nullable
    // 코틀린의 타입은 기본으로 none null type
    val nullable:String? = null

    if(nullable != null){
        println(nullable.length)
    }

}