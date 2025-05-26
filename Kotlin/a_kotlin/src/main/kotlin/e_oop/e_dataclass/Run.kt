package e_oop.e_dataclass

// 반드시 주 생성자의 매개변수가 1개 이상 있어야 함
// final class로만 사용 가능
data class User(
    val email: String,
    val password: String
){
}

fun main(){
    val test = User("test@grepp.com", "1234")
    val test2 = test.copy()
    val admin = test.copy("copy@grepp.com","1234")

    // toString
    println(test)
    println(test == test2)

    // hashCode
    println(test.hashCode())
    println(test2.hashCode())

    // copy(): 불변성을 유지하며 값을 변경
    println(admin)

    // componentN(): 구조분해할당
    val (email, password) = admin
    println("email: $email, password: $password")

}