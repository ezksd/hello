import org.scalatest._
import Hello.{TreeNode, asciiDisplay}

class HelloTest extends FlatSpec with Matchers {

  "test1" should "pass" in {
    val s = asciiDisplay(TreeNode("Root",
                                  children = List(TreeNode("level1-1"),
                                                  TreeNode("level1-2"),
                                                  TreeNode("level1-3"))))
      .map(s => s + "\n").fold("")(_ + _)
    s should be ("+-Root\n  +-level1-1\n  +-level1-2\n  +-level1-3\n")
  }
  "test2" should "pass" in {
    val s = asciiDisplay(TreeNode("Root",
                                  children = List(
                                    TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
                                    TreeNode("level1-2"),
                                    TreeNode("level1-3"))))
      .map(s => s + "\n").fold("")(_ + _)
    s should be ("+-Root\n  +-level1-1\n  | +-level2-1\n  |   +-level3-1\n  | \n  +-level1-2\n  +-level1-3\n")
  }

}