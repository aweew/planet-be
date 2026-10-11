# Planet 后端底座

基于 Java 17、Spring Boot 3.5、MyBatis-Plus、Sa-Token、Redis 和 Flyway。项目同时包含可复用的基础能力和可删除的管理后台示例模块。

## 本地启动

```bash
cp .env.example .env
docker compose up -d
./mvnw spring-boot:run
```

默认服务地址为 `http://localhost:6001/planet`，接口文档在本地环境启用时为 `/planet/swagger-ui.html`。

## 配置边界

| 配置 | 作用 |
| --- | --- |
| `APP_NAME` | Spring 应用名称和默认 Redis 前缀 |
| `SERVER_CONTEXT_PATH` | HTTP 上下文路径 |
| `DB_URL`、`DB_USERNAME`、`DB_PASSWORD` | 数据库连接 |
| `REDIS_KEY_PREFIX` | 多个项目共用 Redis 时的业务隔离前缀 |
| `JWT_SECRET_KEY` | Sa-Token JWT 签名密钥 |
| `PLANET_STORAGE_SECRET_KEY` | 对象存储凭据加密密钥 |

生产环境必须显式设置数据库、Redis、JWT 和存储密钥，不能使用示例默认值。

## 模块边界

- `common`：统一响应、异常、分页、过滤器、鉴权基础设施和配置
- `manager`：用户、角色、菜单和审计管理示例，可按项目需要移除
- `module/storage`：对象存储可选模块
- `module/generator`：代码生成可选模块
- `core`：认证入口和应用启动相关代码

业务项目新增表结构使用新的 Flyway 版本文件，不能修改已经执行过的迁移。

## 验证

```bash
./mvnw -Dtest=PageRequestTest,DefaultAuthenticationTest,ProductionEnvironmentPostProcessorTest test
```
