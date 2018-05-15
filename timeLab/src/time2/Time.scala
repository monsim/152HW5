package time2

class Time (private var h: Int, private var m: Int = 0){
   if (hours < 0 || minutes < 0 || 23 < hours || 59 < minutes) throw new IllegalArgumentException
   def before(other: Time) = { this.toMinutes < other.toMinutes }
   def toMinutes() = this.minutes + this.hours*60 
   def hours = h
   def hours_= (value:Int):Unit = {
     if (value >= 25 || value < 0) throw new IllegalArgumentException
     h = value
   }
   def minutes = m
   def minutes_= (value:Int):Unit = {
     if (value >= 60 || value < 0) throw new IllegalArgumentException
     m = value
   }
   override def toString() = {
     hours + ":" + minutes  
   }
}

object Time { 
  def apply(h: Int, m: Int = 0) = new Time(h, m)
}