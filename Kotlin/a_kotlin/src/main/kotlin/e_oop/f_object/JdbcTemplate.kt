package e_oop.f_object

// Singleton으로 생성되는 객체
// 생성자를 가질 수 없다.
object JdbcTemplate {

    val user: String = "admin"
    val password: String = "1234"

    fun commit(){
        println("commit")
    }

    fun connect(){
        println("connect")
    }
}

fun main(){
    println(JdbcTemplate.user)
    println(JdbcTemplate.password)
    JdbcTemplate.commit()
    JdbcTemplate.connect()
}