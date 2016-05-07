package com.time06.escoladeti;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class Hibernate {

	@Bean
	public DataSource dataSource() {
	
		ConfiguracaoConexaoBanco cfgDB = lerConfiguracaoBanco();
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(cfgDB.classe);
		dataSource.setUrl(cfgDB.url);
		dataSource.setUsername(cfgDB.usuario);
		dataSource.setPassword(cfgDB.senha);
		return (DataSource) dataSource;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        Map<String, String> properties = new HashMap<>();
        // Configuração do dialeto a ser utilizado pelo Hibernate.
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        // A opção "update" cria um schema no banco de dados se não houver um.
        properties.put("hibernate.hbm2ddl.auto", "update");
        // Pacote base para procurar classes anotadas com @Entity
        // Substitui o arquivo beans.xml
        emf.setPackagesToScan("com.time06.escoladeti");
        emf.setDataSource((javax.sql.DataSource) dataSource);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaPropertyMap(properties);
        return emf;
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory managerFactory) {
        // Cria um gerenciador de transações. Executa as transações de forma automática.
        return new JpaTransactionManager(managerFactory);
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
