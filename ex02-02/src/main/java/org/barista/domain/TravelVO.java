package org.barista.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TravelVO {

	private Long no; // 게시판 번호(PK)
	
	@NotBlank(message="필수 항목입니다.")
	private String region; // 권역
	
	@NotBlank(message="필수 항목입니다.")
	private String title; // 제목(관광지명)
	
	@NotBlank(message="필수 항목입니다.")
	private String description; // 설명(관광지 설명)
	
	private String address; // 주소
	private String phone; // 전화번호
}

/*

@Data

- @Getter, @Setter, @RequiredArgsConstructor,
 	@ToString, @EqualsAndHashCode를 한꺼번에 설정

*/