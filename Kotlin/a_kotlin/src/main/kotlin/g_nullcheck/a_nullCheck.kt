package g_nullcheck

var name:String? = null
var hmd:Student? = Student(name)

class Student(
    var name:String?,
    val age:Int? = 10
){

}

fun main(){
    //studySafeCall()
    //studyNonNull()
    //orElseGet()
    //orElseThrow()
    ifPresent()
}

fun studySafeCall(){
    name = "hmd"
    println(name?.length)
    println(hmd?.name)

    name = null
    hmd = null

    println(name?.length)
    println(hmd?.name)
}

// 절대 null 이 아님을 확신할 수 있는 상황에서만 사용
fun studyNonNull(){
    println(name!!.length)
}

// Optional.orElseGet
fun orElseGet(){
    println(name?.length ?: 0)
}

// Optional.orElseThrow
fun orElseThrow(){
    println(name?.length ?: throw NoSuchElementException())
}

// Optional.ifPresent
fun ifPresent(){
    name = "하명도"
    name?.let{ println(it)}
}