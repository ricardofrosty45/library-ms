package com.library.ms.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import com.library.ms.entities.AdminEntity;
import com.library.ms.entities.UserEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserUtil {

	public List<UserEntity> createsUser() {
		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
		List<UserEntity> users = new ArrayList<>();
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).createdTime(new Date()).isActive(true)
				.profile("Profile 1").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("tacs@midtoys.com")
				.createdTime(new Date()).isActive(true).profile("Profile 2").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("mathewj@rewtorsfo.ru")
				.createdTime(new Date()).isActive(true).profile("Profile 3").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("funz@tyonyihi.com")
				.createdTime(new Date()).isActive(true).profile("Profile 4").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("brujje@rentz.fun")
				.createdTime(new Date()).isActive(true).profile("Profile 5").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("kiselksana@toyotataganka.ru")
				.createdTime(new Date()).isActive(true).profile("Profile 6").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("huntermi@riniiya.com")
				.createdTime(new Date()).isActive(true).profile("Profile 7").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("tonysutherland@hacktoy.com")
				.createdTime(new Date()).isActive(true).profile(randomStringGenerator.generate(12)).build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("reshelena@btcmod.com")
				.createdTime(new Date()).isActive(true).profile("Profile 9").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("dxp9284d@litec.site")
				.createdTime(new Date()).isActive(true).profile("Profile 10").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("ctobiassilva@anatolygroup.com")
				.createdTime(new Date()).isActive(true).profile("Profile 11").build());
		users.add(UserEntity.builder().name(randomStringGenerator.generate(12)).email("gabrielmessi30@outluk.co")
				.createdTime(new Date()).isActive(true).profile("Profile 12").build());

		return users;

	}

	public List<AdminEntity> createsAdmin() {

		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
		List<AdminEntity> admins = new ArrayList<>();
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("ctwss@omdlism.com")
				.createdTime(new Date()).isActive(true).profile("Profile 1").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("dda1dd@midtoys.com")
				.createdTime(new Date()).isActive(true).profile("Profile 2").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("dda13df@rewtorsfo.ru")
				.createdTime(new Date()).isActive(true).profile("Profile 3").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("1fffasd@tyonyihi.com")
				.createdTime(new Date()).isActive(true).profile("Profile 4").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("hhhdsd@rentz.fun")
				.createdTime(new Date()).isActive(true).profile("Profile 5").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("asdqwee@toyotataganka.ru")
				.createdTime(new Date()).isActive(true).profile("Profile 6").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("ddfdasd@riniiya.com")
				.createdTime(new Date()).isActive(true).profile("Profile 7").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("rrrqe@hacktoy.com")
				.createdTime(new Date()).isActive(true).profile("Profile 8").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("ddasd@btcmod.com")
				.createdTime(new Date()).isActive(true).profile("Profile 9").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("dddaw@litec.site")
				.createdTime(new Date()).isActive(true).profile("Profile 10").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("gggaqwe@anatolygroup.com")
				.createdTime(new Date()).isActive(true).profile("Profile 11").build());
		admins.add(AdminEntity.builder().name(randomStringGenerator.generate(12)).email("kkkhfg@outluk.co")
				.createdTime(new Date()).isActive(true).profile("Profile 12").build());

		return admins;

	}
}
