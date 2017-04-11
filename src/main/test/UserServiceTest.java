import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.khpp.db.domain.User;
import com.khpp.db.service.UserService;

public class UserServiceTest extends TestSupport {

	@Resource
	private UserService userService;

	@Test
	public void test_insert() {
		User model = new User("starzou", "123456");
		model.setCreateTime(new Date());
		userService.insert(model);
	}

	// @Test
	public void test_10insert() {
		for (int i = 0; i < 10; i++) {
			User model = new User("starzou", "123456");
			userService.insert(model);
		}
	}

}
