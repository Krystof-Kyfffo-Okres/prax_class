object CSV extends App {
  println("Type, Card number, CVC, Owner, Balance")
  val cards = io.Source.fromFile("untitled\\src\\main\\resources\\cards.csv")
  for (line <- cards.getLines) {
    val cols = line.split(",").map(_.trim)
    println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}")
    for(line <- cards.getLines)yield{
      if (s"${cols(0)}" == "b") {
        def apply(card_number: Long, cvc: Int, card_owner: String, balance: Int): BlackCard = new BlackCard(${cols(1)},${cols(2)},${cols(3)},${cols(4)})}

      else {
        def apply(card_number: Long, cvc: Int, card_owner: String, balance: Int): GoldCard = new GoldCard(${cols(1)},${cols(2)},${cols(3)},${cols(4)})}
      }

  }
  cards.close
}

trait Card {
  val limit: Int
  def processInternal(amount: Int): Card

  def processTransaction(amount: Int): Card = {
    if (amount < limit) processInternal(amount)
    else processInternal(0)
  }
}
abstract class GoldCard() extends Card {
  val limit = 1000
  val color: Char
  val card_number: Long
  val cvc: Int
  val card_owner: String
  val balance: Int

//  def processInternal(amount: Int): Card = this.copy(balance = balance - amount)  //?
}

abstract class BlackCard() extends Card {
  val limit = 500
  val color: Char
  val card_number: Long
  val cvc: Int
  val card_owner: String
  val balance: Int
 // def processInternal(amount: Int): Card = this.copy(balance = balance - amount) //?
}
//val cardList: List[Card] = List(GoldCard(10000,"mr.y"), BlackCard(200, "mr x"))
//cardList.foreach {card =>
  //card.processTransaction(100)
//}
