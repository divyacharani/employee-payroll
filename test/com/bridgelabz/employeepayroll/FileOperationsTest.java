package com.bridgelabz.employeepayroll;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class FileOperationsTest {

	private static String HOME = System.getProperty("user.home");
	private static String PLAY = "Sample";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {

		// To check if file exits
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		// To Delete file
		Path playPath = Paths.get(HOME + "/" + PLAY);
		if (Files.exists(playPath)) {
			FileOperations.deleteFiles(playPath.toFile());
		}
		Assert.assertTrue(Files.notExists(playPath));

		// To create directory
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));

		// To create file
		IntStream.range(1, 10).forEach(i -> {
			Path tempFile = Paths.get(playPath + "/temp" + i);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			Assert.assertTrue(Files.exists(tempFile));
		});

		// To list files
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}

}
