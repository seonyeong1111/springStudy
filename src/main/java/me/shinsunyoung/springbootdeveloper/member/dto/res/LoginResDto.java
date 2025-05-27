package me.shinsunyoung.springbootdeveloper.member.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.shinsunyoung.springbootdeveloper.member.domain.Member;
@Data
@AllArgsConstructor
@Builder
public class LoginResDto {

        private Long id;
        private String accessToken;

}
