package com.labs1904.hwe.practice

import org.scalatest.FunSpec

class OptionsEitherTest extends  FunSpec {
  describe("dogAge - Working with Option") {
    it("Returns age in dog Age if Some()") {
      val input = Some(21)
      val expected = Some(3)

      val actual = OptionEither.dogAge(input)

      assert(actual === expected)
    }
    it("Returns None in dog Age if None") {
      val input = None
      val expected = None

      val actual = OptionEither.dogAge(input)

      assert(actual === expected)
    }
  }

  describe("Calculate total cost of item") {
    it("If Item instance has price, return price + 7% of price"){
//      case class Item(description: String, price: Option[Int])
      val input = Item(description="Socks", price = Option(100));
      val expected: Option[Double] = Some(107.000);

      val actual = OptionEither.totalCost(input)

      assert(actual === expected)
    }

    it("Item has no price, return None"){
      val input = Item(description = "Nothing", price = None)
      val expected = None

      val actual = OptionEither.totalCost(input)

      assert(actual === expected)
    }
  }

  /*
    Given a list of weather temperatures, calculates the average temperature across all weather stations.
    Some weather stations don't report temperature
    Returns None if the list is empty or no weather stations contain any temperature reading.
   */
//  case class WeatherStation(name: String, temperature: Option[Int])

  describe("calculate average from a list of objects with Option[Int] values"){
//    temperatures: List[WeatherStation])
    it("List contains WeatherStation with temperature"){
      val station1 = WeatherStation(name = "One", temperature = Some(25))
      val station2 = WeatherStation(name = "One", temperature = Some(43))
      val station3 = WeatherStation(name = "One", temperature = None)
      val station4 = WeatherStation(name = "One", temperature = Some(20))

      val input = List(station1, station2, station3, station4)

      val expected: Option[Int] = Some((25 + 43 + 20) / 3)

      val actual = OptionEither.averageTemperature(input)
      assert(expected === actual)

    }

    it("List contains WeatherStation with without  temperature"){
      val station1 = WeatherStation(name = "One", temperature = None)
      val station2 = WeatherStation(name = "One", temperature = None)

      val input = List(station1, station2)
      val expected = None

      val actual = OptionEither.averageTemperature(input)

      assert(actual == expected)
    }
  }
}
