package e_oop.b_properties

// 코틀린의 클래스는 final class
// 주 생성자 : 클래스 이름 뒤 선언
// getter / setter 자동 생성
// val: getter 만 자동생성
// var: getter/setter 모두 생성
// private: 붙이면 Getter, Setter 둘 다 불가능
class Coffee(
    // 매개변수
    name: String,
    val price: Int,
    // 클래스 속성 선언
    var stock : Int = 0,
    private var _totalSalesCnt: Int = 0 // _을 사용하고 안 하고의 차이
) {
    var name:String? = null
        // field: backing field에 접근하기 위한 키워드
        get() = "$field[커피]"
        set(value){
            if(value.isNullOrBlank())
                throw IllegalArgumentException()
            field = value
        }
    //    get() = name // Properties로 getter 부르는 방법
    //    get(){
    //        println("getName 호출")
    //        return field
    //    }

    // Getter는 열고 Setter는 닫지만 값을 수정하기 위한 함수는 필요
    val totalSalesCnt: Int // var로 사용하게 되면 Setter가 만들어지게 됨
        get() = this._totalSalesCnt

    val addTotalSalesCnt = {cnt: Int ->
        this._totalSalesCnt += cnt
    }

    init{
        this.name = name
    }

    override fun toString(): String {
        return "Coffee(name='$name', price=$price, stock=$stock, totalSalesCnt=$totalSalesCnt)"
    }
}

fun main(){
    val americano = Coffee("아메리카노", 1000, 0, 100 )
    println(americano.name)
    americano.name = ""
    println(americano.name)
    americano.addTotalSalesCnt(10)
    println(americano.totalSalesCnt)
}