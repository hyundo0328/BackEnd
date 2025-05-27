package e_oop.h_extension

private var languages = mutableListOf<Payment.() -> String>()

private val translate: Payment.() -> List<String> = {
    languages.map{ it() }.toList()
}

// infix 함수
// 중위표현식으로 호출할 수 있는 함수
// 매개변수가 반드시 1개만 존재
infix fun Payment.printTranslate(nation: Payment.() -> String){

}

// 확장 함수와 확장 속성
private val Payment.chinaPrice:String
    get() = "${this.payPrice / 200} wian"

private val Payment.americaPrice:String
    get() = "${this.payPrice / 1400} dollar"

private val Payment.spainPrice:String
    get() = "${this.payPrice / 1400} eur"

private val china: Payment.() -> String = {
    "${this.coffee} [${this.orderCnt} 杯] $chinaPrice"
}
private val america: Payment.() -> String = {
    "${this.coffee} [${this.orderCnt} cup] $americaPrice"
}
private val spain: Payment.() -> String = {
    "${this.coffee} [${this.orderCnt} tazas] $spainPrice"
}

fun main(){
    val payment = Payment("아메리카노",3,9000)
    languages.addAll(arrayOf(spain, china))
    println(payment.translate())

    println(payment.chinaPrice)
    println(payment.americaPrice)
    println(payment.spainPrice)

    println(payment.orderName())
    println(payment.china())
    println(payment.america())
    println(payment.spain())

    payment printTranslate china
}