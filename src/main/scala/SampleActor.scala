import akka.actor.Actor

import util.NewProperties

class SampleActor extends Actor {

   def receive = {
     case msg: String => println ( msg)
   }

 }
