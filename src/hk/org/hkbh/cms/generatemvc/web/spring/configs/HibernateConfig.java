package hk.org.hkbh.cms.generatemvc.web.spring.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rabbitforever.generateJavaMVC.bundles.PropertiesBase;
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    public final static String hibernatePropertiesFile = "hibernate.cfg.xml";
    @Autowired
    private ApplicationContext context;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        String hibernateConfigPath = "file:" + PropertiesBase.PROPERTIES_ROOT_DIR + hibernatePropertiesFile;
        factoryBean.setConfigLocation(context.getResource(hibernateConfigPath));
//        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
//        Class [] annotatedClasses =  {BaccaratEo.class,UserEo.class,BigSmallEo.class};
//        factoryBean.setAnnotatedClasses(BaccaratEo.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
