package edu.colorado.cs.muse

import edu.colorado.plv.fixr._

object Main {

  def main(args: Array[String]) {

    println(s"java.class.path: ${System.getProperty("java.class.path")}")
    val visitor = new CallSitesV()
    val list    = List(visitor)
    val data    = ParseTools.readFile(args(0))
    ParseTools.parse(data, args(0), list)
  }

}
