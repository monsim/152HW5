//questions 0, 2 , 4, 5, 6 (problem 1)

package time1

class Time (val hour: Int, val minute: Int = 0) {  
   if (hour < 0 || minute < 0 || 23 < hour || 59 < minute) throw new IllegalArgumentException
   def before(other: Time) = { this.toMinutes < other.toMinutes }
   def minutesSinceMidNight() = { this.toMinutes() }
   def toMinutes() = this.minute + this.hour*60 
   override def toString() = {
     hour + ":" + minute  
   }
   
}

object Time { 
    def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
}