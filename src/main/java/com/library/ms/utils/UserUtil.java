package com.library.ms.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.ms.entities.UserEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtil {

	public List<UserEntity> createsUser() {
		List<UserEntity> users = new ArrayList<>();
		users.add(UserEntity.builder().name("Melba").email("potwog@omdlism.com").createdTime(new Date()).isActive(true)
				.profile("Profile 1").build());
		users.add(UserEntity.builder().name("Jamie").email("tacs@midtoys.com").createdTime(new Date()).isActive(true)
				.profile("Profile 2").build());
		users.add(UserEntity.builder().name("Elsie").email("mathewj@rewtorsfo.ru").createdTime(new Date())
				.isActive(true).profile("Profile 3").build());
		users.add(UserEntity.builder().name("Kenny").email("funz@tyonyihi.com").createdTime(new Date()).isActive(true)
				.profile("Profile 4").build());
		users.add(UserEntity.builder().name("Nora").email("brujje@rentz.fun").createdTime(new Date()).isActive(true)
				.profile("Profile 5").build());
		users.add(UserEntity.builder().name("Dewey").email("kiselksana@toyotataganka.ru").createdTime(new Date())
				.isActive(true).profile("Profile 6").build());
		users.add(UserEntity.builder().name("Spencer").email("huntermi@riniiya.com").createdTime(new Date())
				.isActive(true).profile("Profile 7").build());
		users.add(UserEntity.builder().name("Nettie").email("tonysutherland@hacktoy.com").createdTime(new Date())
				.isActive(true).profile("Profile 8").build());
		users.add(UserEntity.builder().name("Leah").email("reshelena@btcmod.com").createdTime(new Date()).isActive(true)
				.profile("Profile 9").build());
		users.add(UserEntity.builder().name("Albert").email("dxp9284d@litec.site").createdTime(new Date())
				.isActive(true).profile("Profile 10").build());
		users.add(UserEntity.builder().name("Theresa").email("ctobiassilva@anatolygroup.com").createdTime(new Date())
				.isActive(true).profile("Profile 11").build());
		users.add(UserEntity.builder().name("Ethel").email("gabrielmessi30@outluk.co").createdTime(new Date())
				.isActive(true).profile("Profile 12").build());

		return users;

	}
}
