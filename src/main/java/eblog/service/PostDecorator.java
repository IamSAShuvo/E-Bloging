package eblog.service;

import java.util.List;
import java.util.stream.Collectors;

import eblog.domain.Post;
import eblog.dto.PostDto;

public abstract class PostDecorator implements PostService{
	
	private PostService service;

	public PostDecorator(PostService service) {
		this.service = service;
	}
	
	
	
	public List<PostDto> searchPosts(String keyword) {
		return service.searchPosts(keyword);
	}
	

}
