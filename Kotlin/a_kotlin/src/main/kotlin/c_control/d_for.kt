package c_control

fun main(){
    val list = listOf("hello", "kotlin", "for", "loop")
    for(word in list){
        println(word)
    }

    val text = "Kotlin"
    for(ch in text){
        println(ch)
    }

    for((index, word) in list.withIndex()){
        println("$index 인덱스: $word")
    }

    println("=======================================")
    for((index, word) in list.withIndex()){
        println("${index+1} 인덱스: $word")
    }

    for(ch in 'a' .. 'c'){
        println("$ch !!")
    }

    println("=======================================")
    // 5 제외
    for(i in 1 until 5){
        println(i)
    }

    for(i in 10 downTo 1 step 3){
        print("$i ")
    }
}