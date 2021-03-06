package co.uk.DRUK.flink.customSource

/**
  * Created by satyasatyasheel on 14/02/2017.
  */

import org.apache.flink.streaming.api.functions.source.SourceFunction.SourceContext
import org.apache.flink.streaming.api.scala._

import scala.util.Random

object CustomSource {

  def generateRandomStringSource(out:SourceContext[String]) = {
    val lines = Array("Hello World to Flink","Flink is great for streaming process", "I am using Flink for all stream process")
    while (true) {
      val index = Random.nextInt(3)
      Thread.sleep(200)
      out.collect(lines(index))
    }
  }


  def main(args: Array[String]) {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val customSource = env.addSource(generateRandomStringSource _)

    customSource.print()

    env.execute()
  }
}
