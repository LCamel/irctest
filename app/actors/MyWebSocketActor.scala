package actors

import akka.actor._
import irctest.MyAgent

import irctest.MyAgent

object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  out ! "[server greeting]"
  
  val listener = new MyAgent.Listener {
    def onMessage(message: String) {
      out ! "message from irc: " + message
    }
  }

  MyAgent.addListener(listener)
  override def postStop() {
    MyAgent.removeListener(listener)
  }

  def receive = {
    case msg: String =>
      MyAgent.send(msg)
      out ! (">>> I said: " + msg)
  }

}

