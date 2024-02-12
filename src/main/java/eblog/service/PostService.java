package eblog.service;

import java.util.List;

import eblog.dto.PostDto;
import eblog.dto.PostResponse;

public interface PostService {

	PostDto createPost(PostDto dto, int userId, int catagoryId);

	PostDto updatePost(PostDto dto, int postId);

	void deletePost(int postId);
	
	PostDto getById(int postId);

	List<PostDto> getPostByCatagory(int catagoryId);
	
	List<PostDto> getPostByUser(int userId);
	
	PostResponse getAllPost(int pageNumber, int pageSize, String sortBy,String sortDir);
	
	List<PostDto> searchPosts(String keyword);

}
