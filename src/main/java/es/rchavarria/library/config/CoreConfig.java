package es.rchavarria.library.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import es.rchavarria.library.persistence.CourseMapper;
import es.rchavarria.library.persistence.CourseRepository;
import es.rchavarria.library.persistence.CourseStaticRepository;
import es.rchavarria.library.persistence.TeacherMapper;
import es.rchavarria.library.service.CourseRequestsHandler;
import es.rchavarria.library.service.CourseService;

@Configuration
public class CoreConfig {
    
    private static Logger LOGGER = LoggerFactory.getLogger(CoreConfig.class);

    @Bean
    public CourseService createCourseService(CourseRepository repository) {
        return new CourseRequestsHandler(repository);
    }
    
    @Bean
    public CourseRepository createCourseRepository() {
        return new CourseStaticRepository();
    }
    
    @Bean
    public DataSource createDataSource() {
        LOGGER.info("building a datasource");
        
        DataSource ds = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("/sql/schema.sql")
            .addScript("/sql/initial-data.sql")
            .build();
        
        return ds;
    }
    
    @Bean
    public SqlSessionFactory createSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        
        factory.setMapperLocations(new Resource[] {
                new ClassPathResource("/mappers/CourseMapper.xml"),
                new ClassPathResource("/mappers/TeacherMapper.xml")
        });
        factory.setDataSource(dataSource);
        
        return factory.getObject();
    }
    
    @Bean
    public CourseMapper createCourseMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<CourseMapper> mapperFactory = new MapperFactoryBean<CourseMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(CourseMapper.class);
        
        return mapperFactory.getObject();
    }
    
    @Bean
    public TeacherMapper createTeacherMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<TeacherMapper> mapperFactory = new MapperFactoryBean<TeacherMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(TeacherMapper.class);
        
        return mapperFactory.getObject();
    }
}
