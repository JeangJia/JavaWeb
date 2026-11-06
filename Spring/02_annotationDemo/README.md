# 02_annotationDemo

Spring 注解开发样例，对应笔记 `Java/Javaweb/SSM/Spring Framework.md` 第六节。

## 运行

- IDEA：直接运行 `com.jeang.Main#main`
- 命令行：

```bash
mvn -q compile
mvn -q org.codehaus.mojo:exec-maven-plugin:3.5.0:java -Dexec.mainClass=com.jeang.Main
```

## 目录说明

| 路径 | 演示内容 |
| --- | --- |
| `config/SpringConfig` | `@Configuration`、`@ComponentScan`、`@PropertySource`、`@Bean` |
| `dao/UserDaoImpl` | `@Repository("userDao")` 指定 Bean id |
| `dao/MockUserDaoImpl` | 同类型第二个实现，用于演示 `@Qualifier` |
| `service/UserService` | `@Autowired`、`@Value`、`@PostConstruct`、`@PreDestroy` |
| `service/MockUserService` | `@Qualifier("mockUserDao")` 按名称注入 |
| `service/ReportService` | `@Scope("prototype")` 多例 |
| `controller/UserController` | `@Controller` + 构造器注入 |
| `resources/app.properties` | `@Value` 读取的外部配置 |

## 关键结论

- 注解方式仍需「组件扫描」：`@ComponentScan("com.jeang")`
- 不写 Bean 名称时，id 默认为**类名首字母小写**
- `@Autowired` 按类型注入；同类型多个实现时必须加 `@Qualifier("id")`
- 自己写的类用 `@Component` 系列，第三方类用 `@Bean`
- `@PostConstruct` / `@PreDestroy` 来自 `jakarta.annotation`（Spring 6+ 已改为 jakarta 命名空间）
