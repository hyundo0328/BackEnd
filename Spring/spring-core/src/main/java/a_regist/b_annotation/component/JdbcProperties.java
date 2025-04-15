package a_regist.b_annotation.component;

import java.util.Properties;

public class JdbcProperties {
    
    private final Properties properties;
    
    public JdbcProperties(Properties properties) {
        this.properties = properties;
    }
    
    public void setProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }
    
    @Override
    public String toString() {
        return "JdbcProperties{" +
                   "properties=" + properties +
                   '}';
    }
}
