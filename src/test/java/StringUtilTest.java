import com.bgl.core.util.StringUtil;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public  void testContainsMoreThanOneNumber(){
        assertThat(StringUtil.containsMoreThanOneNumber("SRI")).isFalse();
    }

    @Test
    public  void testContainsMoreThanOneNumberWithOneNumber(){
        assertThat(StringUtil.containsMoreThanOneNumber("SRI1")).isFalse();
    }
    @Test
    public  void testContainsMoreThanOneNumberWithNumbers(){
        assertThat(StringUtil.containsMoreThanOneNumber("SRI1-2")).isTrue();
    }

    @Test
    public void endsWithAHyphen(){
        assertThat(StringUtil.endsWithAHyphen("SRI-")).isTrue();
    }

    @Test
    public void endsWithNoHyphen(){
        assertThat(StringUtil.endsWithAHyphen("SRI")).isFalse();
    }

    @Test
    public void leaveDigit(){
        assertThat(StringUtil.leaveDigit("SRI","7")).isEqualTo("SRI-7");
    }
}
