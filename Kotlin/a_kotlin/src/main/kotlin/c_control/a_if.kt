package c_control

fun main(){

    var grade: Char? = null
    print("score: ")
    val score = readln().toInt()

    if(score > 90){
        grade = 'A'
    } else if (score > 80){
        grade = 'B'
    } else {
        grade = 'F'
    }

    println(grade)

    val result = if(grade == 'A') "scholarship" else if (grade == 'F') "Fail" else "Pass"
    println(result)
}