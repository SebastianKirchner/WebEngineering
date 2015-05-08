import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.JeopardyGame;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void factory(){
        JeopardyFactory factory = new PlayJeopardyFactory("conf.data.de.json");
        User user = new SimpleUser();
        user.setName("Dave");
        user.setAvatar(Avatar.BEETLE);
        JeopardyGame game = factory.createGame(user);
        assertTrue(game.getCategories().size() != 0);
        int a = 0;

    }


}
