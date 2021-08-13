package com.fhec.config.Ini;

import java.io.File;

import org.junit.Test;

import com.fhec.config.ini.INIConfigObject;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.context.PasswordConfig;
import com.fhec.context.RecipeConfig;

public class InitConfigObjectTest {

	private static String USER_DIR = System.getProperty("user.dir");;

	@Test
	public void ToJavaEnvConfig() throws Exception {

		String path = USER_DIR + File.separator + "envconfig" + File.separator + "env_config.txt";
		EnvConFigConfig envConFigConfig = INIConfigObject.toJavaObject(path, EnvConFigConfig.class);
		Object obj = envConFigConfig;
	}

	@Test
	public void ToJavaPasswordConfig() throws Exception {

		String path = USER_DIR + File.separator + "password" + File.separator + "password.txt";
		PasswordConfig passwordConfig = INIConfigObject.toJavaObject(path, PasswordConfig.class);
		Object obj = passwordConfig;
	}

	@Test
	public void ToJavaRecipe() throws Exception {
		String path = USER_DIR + File.separator + "recipe" + File.separator + "ft1_recipe.cfg";
		RecipeConfig recipeConfig = INIConfigObject.toJavaObject(path, RecipeConfig.class);
		Object obj = recipeConfig;
	}

	@Test
	public void ToJavaMesfile() throws Exception {

		String path = USER_DIR + File.separator + "mesfile" + File.separator + "GDT2037F011.001.002_FT1.mes";
		MesFileConfig mesFileConfig = INIConfigObject.toJavaObject(path, MesFileConfig.class);
		Object obj = mesFileConfig;
	}

}
