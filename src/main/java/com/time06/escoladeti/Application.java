package com.time06.escoladeti;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		try {
			ConfiguracaoConexaoBanco cfgDB = lerConfiguracaoBanco();
			
			Class classe = Class.forName(cfgDB.classe);
			
			Connection connection = DriverManager.getConnection(cfgDB.url,cfgDB.usuario,cfgDB.senha);
			
			System.out.println("Opa, deu certo!! Conexão: " + connection.toString());
			
			SpringApplication.run(Application.class, args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ConfiguracaoConexaoBanco lerConfiguracaoBanco() {
		try {
			InputStream input = Application.class.getResourceAsStream("/conexao.properties");
			Properties props = new Properties();
			props.load(input);
			
			return new ConfiguracaoConexaoBanco(
					props.getProperty("bd-classe"), 
					props.getProperty("bd-usuario"), 
					props.getProperty("bd-senha"), 
					props.getProperty("bd-url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
