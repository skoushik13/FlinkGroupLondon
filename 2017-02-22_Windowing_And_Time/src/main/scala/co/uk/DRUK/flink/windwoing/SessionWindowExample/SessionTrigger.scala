package co.uk.DRUK.flink.windwoing.SessionWindowExample

/**
  * Created by satyasatyasheel on 14/02/2017.
  */

import co.uk.DRUK.flink.windwoing.Models.Session
import org.apache.flink.streaming.api.windowing.triggers.Trigger.TriggerContext
import org.apache.flink.streaming.api.windowing.triggers.{Trigger, TriggerResult}
import org.apache.flink.streaming.api.windowing.windows.Window

class SessionTrigger[W <: Window] extends Trigger[Session,W] {
  override def onElement(element: Session, timestamp: Long, window: W, ctx: TriggerContext): TriggerResult = {
    if(element.endSignal.isDefined) TriggerResult.FIRE
    else TriggerResult.CONTINUE
  }

  override def onProcessingTime(time: Long, window: W, ctx: TriggerContext): TriggerResult = {
    TriggerResult.CONTINUE
  }
  override def onEventTime(time: Long, window: W, ctx: TriggerContext): TriggerResult = {
    TriggerResult.CONTINUE
  }
}
