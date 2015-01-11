package actors

import akka.actor._
import irctest.MyAgent

object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case msg: String =>
      MyAgent.send(msg)
      out ! ("I received your message: " + msg)
  }
}

