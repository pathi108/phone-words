import com.bgl.search.PhoneWordDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneWordDictionaryTest {
    List<String> dict = Arrays.asList("STAR"
            ,"PLACES"
            ,"HELLO"
            ,"WORLD"
            ,"WARS"
            ,"KITTY"
            ,"JITTY");
    PhoneWordDictionary phoneWordDictionaryTree = new PhoneWordDictionary();

    @BeforeEach
    public void init(){
        dict.forEach(phoneWordDictionaryTree::insert);
    }


    @Test
    public void testTestGetPhoneWordsFor(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("54889");
        Assertions.assertEquals(phoneWords.size(),2);
        assertThat(phoneWords).hasSameElementsAs(Arrays.asList("KITTY","JITTY"));
    }

    @Test
    public void testTestGetPhoneWordsForLeaveElement(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("782792771");
        assertThat(phoneWords).hasSameElementsAs(Collections.singletonList("STAR-WARS-1"));
    }

    @Test
    public void testTestGetPhoneWordsForLeaveMultiplePhoneWords(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("54889154889");
        assertThat(phoneWords).hasSameElementsAs(Arrays.asList("JITTY-1-JITTY", "JITTY-1-KITTY", "KITTY-1-JITTY", "KITTY-1-KITTY"));
    }

    @Test
    public void testTestGetPhoneWordsForLeaveNoPhoneWords(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("1122");
        assertThat(phoneWords).hasSameElementsAs(Collections.emptyList());
    }

    @Test
    public void testTestGetPhoneWordsMultipleLeavings(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("548892");
        Assertions.assertEquals(phoneWords.size(),2);
        assertThat(phoneWords).hasSameElementsAs(Arrays.asList("KITTY-2","JITTY-2"));
    }

    @Test
    public void testTestGetPhoneWordsNoPhoneWords(){
        List<String> phoneWords = phoneWordDictionaryTree.getPhoneWordsFor("5488922");
        Assertions.assertEquals(phoneWords.size(),0);
    }
}
