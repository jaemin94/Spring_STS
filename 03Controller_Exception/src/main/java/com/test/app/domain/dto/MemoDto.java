package com.test.app.domain.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class MemoDto {
	
	@Min(value=10,message="최소숫자는 10자 이상이여야합니다")
	@Max(value=1000,message="최대 숫자는 1000 이하 이어야합니다.")
	private int id;
	@NotBlank(message="text를 입력하세요.")
	private String text;
	@NotBlank(message="작성자를 입력하세요")
	@Email(message="유효한 이메일 주소를 입력하세요")
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Future(message="현재 날짜보다 이후 날짜로 선택하셔야 됩니다.")
	private LocalDateTime regDate;	// yyyy-MM-dd HH:mm:ss
}
