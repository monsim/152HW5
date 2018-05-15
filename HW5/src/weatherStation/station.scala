package weatherStation

class CelsiusTherm {
  // = degrees Celsius 
  def computeTemp(city: String) = 50 * math.random // fake temperature for now
}

trait IThermometer {
   // = avg degrees Farenheit
   def getMeanTemperature(cities: List[String]): Double
}

object WeatherStation extends App {
  val thermometer: IThermometer = new ThermAdapter
  val avgTemp = 
      thermometer.getMeanTemperature(List("LA", "SF", "SLC", "Rio"))
  println("avg temp = " + avgTemp)
}

class ThermAdapter extends IThermometer {  //thermAdapter is a IThermometer
  val cTherm = new CelsiusTherm
  def getMeanTemperature(cities: List[String]): Double = {
    var meanTemp = 0.0
    for (i <- cities) {
      meanTemp += cTherm.computeTemp(i)
    }
    meanTemp = meanTemp/cities.length
    meanTemp*1.8+32  //convert celsius to fahrenheit
  }
}


/*
 * prints
 * avg temp = 89.07622303745185
 */
