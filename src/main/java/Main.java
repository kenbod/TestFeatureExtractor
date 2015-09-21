import edu.colorado.plv.fixr.*;

public class Main {

  public static void main(String[] args) {
    ASTFeaturesVisitor visitor = new CallSitesV();
    java.util.ArrayList<ASTFeaturesVisitor> mylist =
      new java.util.ArrayList<ASTFeaturesVisitor>();
    String data = ParseTools.readFile(args[0]);
    ParseTools.parse(
      data,
      args[0],
      scala.collection.JavaConversions.asScalaIterable(mylist).toList()
    );
  }
}
