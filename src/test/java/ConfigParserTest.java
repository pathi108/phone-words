import com.bgl.core.util.config.Config;
import com.bgl.core.util.config.exception.ConfigParserException;
import com.bgl.core.util.config.parser.ConfigParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConfigParserTest {

    @Test
    public void testNoConfigs(){
        assertThatThrownBy(() -> {
            String [] args={};
            ConfigParser.parse(args); }
        ).isInstanceOf(ConfigParserException.class)
                .hasMessageContaining("Cannot Parse parameters : There should be two parameters passed.Please pass the phone number file path along with the dictionary file path");
    }

    @Test
    public void testNoDictionary(){
        assertThatThrownBy(() -> {
            String [] args={"dictFilePath","input=InputFilePath"};
            ConfigParser.parse(args); }
        ).isInstanceOf(ConfigParserException.class)
                .hasMessageContaining("The file path to the dictionary not provided");
    }

    @Test
    public void testConfigParser() throws ConfigParserException {

            String [] args={"dictionary=dictFilePath","input=InputFilePath"};
            Config config =ConfigParser.parse(args);
            assertThat(config.getDictionaryFilePath()).isEqualTo("dictFilePath");
            assertThat(config.getInputFilePath()).isEqualTo("InputFilePath");
    }
}
