import com.bgl.core.collections.Node;
import com.bgl.core.collections.TernarySearchTree;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TernarySearchTreeTest {
    TernarySearchTree ternarySearchTree = new TernarySearchTree();

    @Test
    public void testInsertNodes(){

        ternarySearchTree.insert("STAR");
        Node node = ternarySearchTree.getRoot();
        assertThat(node.getLetter()).isEqualTo('S');

    }

    @Test
    public void testInsertLowerNode(){

        ternarySearchTree.insert("STAR");
        ternarySearchTree.insert("BIG");
        Node node = ternarySearchTree.getRoot();
        assertThat(node.getLeft().getLetter()).isEqualTo('B');

    }

    @Test
    public void testHigherNode(){

        ternarySearchTree.insert("STAR");
        ternarySearchTree.insert("WELL");
        Node node = ternarySearchTree.getRoot();
        assertThat(node.getRight().getLetter()).isEqualTo('W');
        assertThat(node.getLeft()).isEqualTo(null);

    }

    @Test
    public void testFindLetter(){

        ternarySearchTree.insert("STAR");
        Node node = ternarySearchTree.getRoot();
        Node found = ternarySearchTree.findFirstLetter(node,'S');
        assertThat(found.getLetter()).isEqualTo('S');
    }

    @Test
    public void testFindLetterOfHigherNode(){

        ternarySearchTree.insert("STAR");
        ternarySearchTree.insert("WELL");
        Node node = ternarySearchTree.getRoot();
        Node found = ternarySearchTree.findFirstLetter(node,'W');
        assertThat(found.getLetter()).isEqualTo('W');
    }


}
