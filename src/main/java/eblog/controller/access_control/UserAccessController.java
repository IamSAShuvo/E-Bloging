package eblog.controller.access_control;

import eblog.domain.Post;
import eblog.domain.User;
import eblog.service.PostService;

public interface UserAccessController {
	boolean grandAccessCheck(User user);
	
	void deleteUser(User user);
	
	void deletePost(Post post);
	
	User addManager(User user);
	
	
}
