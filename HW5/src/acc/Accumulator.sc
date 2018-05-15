package acc

object Accumulator {
	object Accum {
	  println("Welcome to the Scala worksheet")
		var program = List[Instruction]()
		var register = 0
		def run() = {	//the brain
			for (inst <- program) {	//execute each instruction
				register = inst.execute(register) //ask inst to execute itself. distribute intelligence
		 	}
		}
	}
	trait Instruction {
		def execute(register: Int): Int
	}

	class Add(val arg: Int) extends Instruction {
		def execute(register: Int): Int = register + arg
	}
		
	object Add {
		def apply(arg: Int) = new Add(arg)
	}
	
	class Mul(val arg: Int) extends Instruction {
		def execute(register: Int): Int = register * arg
	}
		
	object Mul {
		def apply(arg: Int) = new Mul(arg)
	}

	

	Accum.program = List(Add(3), Mul(5), Add(1), Mul(2))
                                                  //> Welcome to the Scala worksheet
	Accum.run()
	Accum.register                            //> res0: Int = 32
	Accum.register = 0
	Accum.program = List(Add(10), Mul(2), Add(3), Mul(5))
	Accum.run()
	Accum.register                            //> res1: Int = 115
}




/* in class
object accum {
	object Accumulator {
		var register = 0
		var program = List[Instruction]()
		def run() {
			for (i <- program) register = i.execute(register)
		}
	}
	var ins: Instruction = null
	ins = new Add(3)	//is ok because add extends instruction. polymorphism.
	//instances of the subtype can masquerade as instance of super type
*/