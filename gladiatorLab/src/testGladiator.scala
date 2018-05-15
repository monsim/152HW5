

object testGladiator extends App {
   
  
  class Gladiator(val name: String) {  //name is read only
    protected var health: Int = 100    //don't want users to initalize it. needs to be protected so 
                                       //crushermasher can see it (also can make a public getter/setter for it
    
    def damage(amount: Int) {        //procedures, not functions. no =
      if (health - amount >= 0) health -= amount
      else health = 0
    }
    
    def attack(opponent: Gladiator) {
      opponent.damage(5)
      println(this.name + " is attacking " + opponent.name)
      println(this.name + "'s health = " + opponent.health)
    } 
  }
  
  trait Slasher {
    def slash(g: Gladiator) {
      println("slash, slash, slashing " + g.name)
      g.damage(10)
    } 
  }
  
  trait Masher {
    def mash(g: Gladiator) {
      println("mash, mash, masher " + g.name)
      g.damage(10)
    } 
  }
  
  trait Crusher {
    def crush(g: Gladiator) {
      println("crush, crush, crushing " + g.name)
      g.damage(10)
    } 
  }
  
  class CrusherMasher(name: String) extends Gladiator(name) with Masher with Crusher {  //crusher masher constructor calls gladiator cstr, that wants a name
    //how does a sub class initialize a field of a super class
    //declare name as parameter in the sub class (not val not var) and feed it to the super class cstr
    //inherited damage, attack, crush, mash (mix in). override attack
    override def attack(opponent: Gladiator) {
      super.attack(opponent)
      //call crush or mash only if you're not dead 
      if (this.health > 0) {
        crush(opponent)
        mash(opponent)
      }
    }
  }
    
   val optimus = new CrusherMasher("Optimus Prime")
   
   object bee extends Gladiator("Bumblebee") with Masher with Slasher { //singleton object
     override def attack(opponent: Gladiator) {
      super.attack(opponent)
      //call crush or mash only if you're not dead 
      if (this.health > 0) {
        slash(opponent)
        mash(opponent)
      }
    }
   }
   
   val bee2 = new Gladiator("bee 2") with Crusher with Slasher
   
   for (i <- 0 to 5) {
     optimus.attack(bee)
     bee.attack(optimus)
   }
}


/*
 * OUTPUT
 * Optimus Prime is attacking Bumblebee
Optimus Prime's health = 95
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 95
slash, slash, slashing Optimus Prime
mash, mash, masher Optimus Prime
Optimus Prime is attacking Bumblebee
Optimus Prime's health = 70
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 70
slash, slash, slashing Optimus Prime
mash, mash, masher Optimus Prime
Optimus Prime is attacking Bumblebee
Optimus Prime's health = 45
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 45
slash, slash, slashing Optimus Prime
mash, mash, masher Optimus Prime
Optimus Prime is attacking Bumblebee
Optimus Prime's health = 20
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 20
Optimus Prime is attacking Bumblebee
Optimus Prime's health = 0
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 15
Optimus Prime is attacking Bumblebee
Optimus Prime's health = 0
crush, crush, crushing Bumblebee
mash, mash, masher Bumblebee
Bumblebee is attacking Optimus Prime
Bumblebee's health = 10
* 
*/
