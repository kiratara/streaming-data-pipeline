


//val humanAge: Option[Int] = Option(7)
//humanAge match {
//  case None => None
//  case Some(i: Int) => i / 7
//}
//
//
//case class WeatherStation(name: String, temperature: Option[Int])
//val station1 = WeatherStation(name = "One", temperature = Some(22))
//val station2 = WeatherStation(name = "One", temperature = None)
//
//val weatherList = List(station1, station2)
//
//val tempList = weatherList.flatMap(station => station.temperature)

val i = 111112 // --> 121
val strI = i.toString
//val reversedStrI = (i.toString).reverse

val index = strI.length - 1
var prevNum = strI(index)
var done = true
var n = 1
var swapIndex = -1;
while (n <= index && done) {
  if (prevNum.toInt > strI(index-n).toInt) {
     //save swap index
    println("We here")
    swapIndex = n
    print(swapIndex)
    // flip done flag
    done = false
  } else {
    prevNum = strI(n)
    n = n + 1
  }
}
print(swapIndex)

var n = 0
var newStr = ""
while (n <= index && swapIndex >= 0){
  if (n == swapIndex - 1){
    newStr + strI(n)
  } else if (n == swapIndex) {
    newStr + strI(n-1)
  } else {
    newStr + strI(n)
  }
  n = n + 1
}
println(newStr)