
object Hello {


  def asciiDisplay(root: TreeNode[String]): Seq[String] = f(true)(root)

  def f[a](b: Boolean)(t: TreeNode[a]): Seq[String] = {
    val seq = t.children.flatMap(f(t.children.size == 1))
    val p = if (b) "  " else "| "
    "+-" + t.data :: (if (b || seq == Nil) seq else seq ++ List("") ).map(s => p + s).asInstanceOf[List[String]]
  }


  case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)


}