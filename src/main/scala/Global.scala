import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension;
import play.App;
import play.GlobalSettings;



object Global extends GlobalSettings {

   val system = ActorSystem ( "SampleSystem" )
   val actor = system. actorOf (Props (classOf [SampleActor]))

   override def onStart (app: App) = {
     // Whether to perform what schedule, or to send a message to any actor, to specify whether to send what message
	 QuartzSchedulerExtension(system).createSchedule("test", None, "*/5 * * ? * *")
     QuartzSchedulerExtension (system). schedule ( "test", actor, "5 seconds testing")
   }

   override def onStop (app: App) = {
     system. shutdown ()
   }

 } 
