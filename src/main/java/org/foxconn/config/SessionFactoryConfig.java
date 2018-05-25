package org.foxconn.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
* @author:myz
* @version 1.0 
* ����ʱ�䣺2018��5��25�� ����8:53:49
*/
@Configuration
@Mapper
public class SessionFactoryConfig {    
        /**   mybatis ����·��     */    
        private static String MYBATIS_CONFIG = "mybatis-config.xml";    
        /**   mybatis mapper resource ·��     */    
        private static String MAPPER_PATH = "org/foxconn/mapper/**.xml";    

        @Autowired    
        private DataSource dataSource;
    
        private String typeAliasPackage = "org.foxconn.dao";   

        /** 
          *����sqlSessionFactoryBean ʵ��     
          * ��������configtion ���շ�����.�ȵ�     
          * ����mapper ӳ��·��     
          * ����datasource����Դ     
          * @return     
          */
        @Bean    
        public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();        
        /** ����mybatis configuration ɨ��·�� */                
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        /** ���mapper ɨ��·�� */        
         PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();        
         String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
         sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        /** ����datasource */        
         sqlSessionFactoryBean.setDataSource(dataSource);   
        /** ����typeAlias ��ɨ��·�� */     
         sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);        
         return sqlSessionFactoryBean;    
          }
}

