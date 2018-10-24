package bitcamp.java110.cms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages="bitcamp.java110.cms")//@Component @ Autowired @Service 이런거 찾아서 처리해라!
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")

// Mabatis에서 자동으로 DAO를 생성할 때 사용할 인터페이스가 들어 있는 패키지 설정
@MapperScan("bitcamp.java110.cms.dao")
public class AppConfig {

    @Autowired
    Environment env;//프로퍼티source 읽어서 만들고~  import org.springframework.core.env.Environment;

    public AppConfig() {
        System.out.println("AppConfig() 호출됨!");
    }

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        System.out.println("DataSource 객체 생성!");

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));// driver는 jdbc.properties에 써준 값이다
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));;// env에는 기본 자바 virtualmachine의 환경정보가 들어있기때문에 이름이 같다면 기본 정보를 우선시 한다.
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setDefaultAutoCommit(false);

        return ds;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource,
            ApplicationContext appCtx) {// 이 메서드 IoC컨테이너가 호출할거다 우리가 위에 dataSource를 갖다 쓰는게 아니고 컨테이너한테 달라고 하는것이다
        System.out.println("SqlSessionFactory 객체 생성!");

        /*System.out.println("sqlsessionfactory 생성!!!!");
        System.out.println(dataSource);
        System.out.println(appCtx);

        뭐라뭐라 생성!!
        sqlsessionfactory 생성!!!!
        org.apache.commons.dbcp2.BasicDataSource@4082ba93
        org.springframework.context.annotation.AnnotationConfigApplicationContext@21213b92: startup date [Fri Oct 19 15:15:47 KST 2018]; root of context hierarchy
        뭐라뭐라 생성!!
         */

        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            // 얘가 만들어 주는게 SqlSession을 만들어 주는것이 아니다. sqlsessionFactory를 만들어준다.이 거 헷갈려 원래틑 팩토리를 만들어 주는 팩토리 이렇게 가야하는데 쩝쩝..

            // DB 커넥션풀을 관리해주는 객체를 꼽는다.
            factory.setDataSource(dataSource);

            // SQL 맵퍼 파일에서 도메인 객체의 별명을 사용하려면 
            // 도메인 객체가 들어 있는 패키지를 지정해야 한다. 
            // 그러면 Mybatis가 해당 패키지의 모든 클래스에 대해 별명을 자동으로 생성할 것이다.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");

            //SQL 맴퍼 파일의 경로를 등록한다.    DAO로 끝나는거 다 가꼬와   이것을 쓰려면 맨위에  파라미터로 ApplicationContext를 박아야 한다.
            factory.setMapperLocations(appCtx.getResources(
                    "classpath:/bitcamp/java110/cms/mapper/**/*.xml"));

            return factory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }

    /*
    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("------------------------------");

        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }

        System.out.println("------------------------------");


        ManagerService s = 
                (ManagerService) iocContainer.getBean(ManagerService.class);
        System.out.println(s.list(1, 5));


        Properties props = System.getProperties();
        Set<Entry<Object,Object>> entrySet = props.entrySet();
        for (Entry entry : entrySet) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue()); 
        }
    } 
     */
    /*
     스프링아이오씨 컨테이너가 저위에 패키지를 뒤져서 관련 객체를 ㅁ다 만든다
     저 프로퍼티 읽어서 env에 저장해놔 env안에는 propertysource애노테이션을 처리하면서 만든 객체가 들어가 있따.
     */    

}














