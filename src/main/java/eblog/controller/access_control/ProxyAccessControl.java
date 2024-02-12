package eblog.controller.access_control;

import org.springframework.beans.factory.annotation.Autowired;

import eblog.domain.Post;
import eblog.domain.User;
import eblog.dto.UserDto;
import eblog.service.PostService;
import eblog.service.UserService;
import eblog.service.impl.ModelMapperST;

public class ProxyAccessControl implements UserAccessController {
	User user;

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	public ProxyAccessControl(User user) {
		this.user = user;
	}

	@Override
	public boolean grandAccessCheck(User user) {
		return user.getRoles().contains("MANAGER");
	}

	@Override
	public void deleteUser(User user) {
		this.userService.deleteUser(user.getId());
	}

	@Override
	public void deletePost(Post post) {

		this.postService.deletePost(post.getPostId());
	}

	@Override
	public User addManager(User user) {
		UserDto createdUser = this.userService.createUser(ModelMapperST.getInstance().map(user, UserDto.class));
		return ModelMapperST.getInstance().map(createdUser, User.class);
	}

}
