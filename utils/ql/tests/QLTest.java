import com.jengine.utils.ql.AST;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

public class QLTest {

    @Test
    public void test1(){
        System.out.println("test 1");
//        AST.parse("?");

    }

    public static void visit(Tree tree, int level) {
        printNode(tree, level);
        for (int i=0; i < tree.getChildCount(); i++) {
            visit(tree.getChild(i), level+1);
        }
    }

    public static void printNode(Tree tree, int level) {
        for (int i=0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.print(tree.getText());
        System.out.print("  ---- " + tree.getType());
        System.out.println();

    }

}
