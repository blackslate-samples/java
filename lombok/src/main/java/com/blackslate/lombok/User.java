package com.blackslate.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Getter @Setter	@NonNull private String name;
	@Getter @Setter @NonNull private String email;

}
