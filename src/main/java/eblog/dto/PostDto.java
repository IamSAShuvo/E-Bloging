package eblog.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import eblog.domain.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Data
public class PostDto {

	private int postId;
	
	private String title;

	private String content;

	private String image;

	private Date addedDate;

	private CatagoryDto catagory;

	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
}
