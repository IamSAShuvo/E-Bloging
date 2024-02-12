package eblog.service.impl;

import java.util.List;

import eblog.dto.PostDto;
import eblog.dto.PostResponse;
import eblog.service.PostService;

public class PostDecoratorImpl extends eblog.service.PostDecorator {

	public PostDecoratorImpl(PostService service) {
		super(service);
	}

	@Override
	public PostDto createPost(PostDto dto, int userId, int catagoryId) {
		return null;
	}

	@Override
	public PostDto updatePost(PostDto dto, int postId) {
		return null;
	}

	@Override
	public void deletePost(int postId) {
		
	}

	@Override
	public PostDto getById(int postId) {
		return null;
	}

	@Override
	public List<PostDto> getPostByCatagory(int catagoryId) {
		return null;
	}

	@Override
	public List<PostDto> getPostByUser(int userId) {
		return null;
	}

	@Override
	public PostResponse getAllPost(int pageNumber, int pageSize, String sortBy, String sortDir) {
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		return this.searchPostsByBlogger(keyword);
	}
		
	private List<PostDto> searchPostsByBlogger(String keyword) {
		return super.searchPosts(keyword);
	}
	
}
