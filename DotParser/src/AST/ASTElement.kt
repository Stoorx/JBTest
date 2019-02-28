package dotParser.AST

import com.sun.deploy.util.OrderedHashSet

abstract class ASTElement {
    val childrenNodes: ArrayList<ASTElement> = ArrayList()
    abstract fun toDot(): String
}