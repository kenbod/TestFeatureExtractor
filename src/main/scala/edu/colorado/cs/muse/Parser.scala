package edu.colorado.cs.muse

import edu.colorado.plv.fixr._

import java.nio.file.Paths

object Parser {

  def createArray(classpath : List[java.net.URL], arr : Array[String], pos : Int): Array[String] = {
    classpath match {
      case x :: xs => {
        arr(pos) = Paths.get(x.toURI()).toFile().getCanonicalPath()
        createArray(xs, arr, pos - 1)
      }
      case _ => arr
    }
  }

  def get_scala_classpath() : Array[String] = {
    lazy val urls = java.lang.Thread.currentThread.getContextClassLoader match {
      case cl: java.net.URLClassLoader => cl.getURLs.toList
      case _ => sys.error("classloader is not a URLClassLoader")
    }
    var strArray : Array[String] = new Array[String](urls.length)
    createArray(urls, strArray, urls.length - 1)
    strArray     
  }

  def main(args: Array[String]) {

    val visitor   = new CallSitesV()
    val list      = List(visitor)
    val data      = ParseTools.readFile(args(0))
    val classpath = get_scala_classpath()
    val sources   = Array(".")
    val encodings = Array("UTF-8")
    ParseTools.parse(data, args(0), list, classpath, sources, encodings)
  }

}
