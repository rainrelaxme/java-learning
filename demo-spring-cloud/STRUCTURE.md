# 推荐的Spring Boot项目目录结构（最佳实践）

以下是一个**清晰、易维护、符合业界规范**的目录结构：

```text
└── src/main/java/com/example/app/
    │
    ├── AppApplication.java                # Spring Boot启动类
    │
    ├── controller/                        # 控制器层
    │   ├── UserController.java
    │   └── OrderController.java
    │
    ├── service/                           # 业务逻辑层
    │   ├── UserService.java               # 接口
    │   └── impl/                          # 实现类（可选）
    │       └── UserServiceImpl.java
    │
    ├── mapper/                            # 数据访问层（MyBatis/JPA）
    │   ├── UserMapper.java
    │   └── OrderMapper.java
    │
    ├── entity/                            # 实体类（与数据库表映射）
    │   ├── UserEntity.java
    │   └── OrderEntity.java
    │
    ├── dto/                               # 数据传输对象（API入参/出参）
    │   ├── request/                       # 请求DTO
    │   │   ├── UserCreateRequest.java
    │   │   └── UserQueryRequest.java
    │   └── response/                      # 响应DTO
    │       ├── UserResponse.java
    │       └── PageResponse.java
    │
    ├── vo/                                # 视图对象（复杂页面展示）
    │   └── UserProfileVO.java
    │
    ├── converter/                         # 对象转换器（DTO ↔ Entity ↔ VO）
    │   └── UserConverter.java
    │
    ├── config/                            # 配置类
    │   ├── RedisConfig.java
    │   ├── WebMvcConfig.java
    │   └── SwaggerConfig.java
    │
    ├── common/                            # 公共模块
    │   ├── enums/                         # 枚举类
    │   │   ├── ResultCodeEnum.java
    │   │   └── UserStatusEnum.java
    │   ├── constant/                      # 常量类
    │   │   └── SystemConstants.java
    │   ├── exception/                     # 异常定义
    │   │   ├── BusinessException.java
    │   │   └── GlobalExceptionHandler.java
    │   ├── result/                        # 统一响应结构
    │   │   └── Result.java
    │   └── util/                          # 工具类
    │       ├── DateUtil.java
    │       └── JwtUtil.java
    │
    ├── interceptor/                       # 拦截器
    │   └── AuthInterceptor.java
    │
    ├── aspect/                            # AOP切面
    │   └── LogAspect.java
    │
    ├── task/                              # 定时任务
    │   └── ScheduledTask.java
    │
    └── event/                             # 事件监听/发布
        ├── UserRegisteredEvent.java
        └── UserEventListener.java
```

# 配套的 resources 目录结构

```text
    └── src/main/resources/
        │
        ├── application.yml                    # 主配置文件
        ├── application-dev.yml                # 开发环境配置
        ├── application-prod.yml               # 生产环境配置
        │
        ├── mapper/                            # MyBatis XML映射文件（如使用XML方式）
        │   ├── UserMapper.xml
        │   └── OrderMapper.xml
        │
        ├── db/                                # 数据库脚本
        │   ├── schema.sql
        │   └── data.sql
        │
        ├── static/                            # 静态资源（CSS/JS/图片）
        └── templates/                         # 模板文件（Thymeleaf等）
```

# 核心命名规范总结

| 包名               | 	全称	                 | 用途                 | 示例类名                          |
|------------------|----------------------|--------------------|-------------------------------|
| controller       | Controller           | HTTP接口层            | UserController                |
| service          | Service              | 业务逻辑层              | UserService / UserServiceImpl |
| mapper           | Mapper               | 数据库访问层             | UserMapper                    |
| entity           | Entity               | 数据库实体（与表一一对应）      | UserEntity                    |
| dto.request      | Data Transfer Object | 接口入参               | UserCreateRequest             |
| dto.response     | Data Transfer Object | 接口出参               | UserResponse                  |
| vo               | View Object          | 视图对象（聚合多个实体/DTO）   | UserProfileVO                 |
| converter        | Converter            | 对象转换（使用MapStruct等） | UserConverter                 |
| config           | Configuration        | Spring配置类          | RedisConfig                   |
| common.enums     | Common Enums         | 公共枚举               | ResultCodeEnum                |
| common.constant  | Common Constants     | 常量                 | SystemConstants               |
| common.exception | Common Exception     | 异常类和全局处理器          | GlobalExceptionHandler        |
| common.result    | Common Result        | 统一响应封装             | Result<T>                     |
| common.util      | Common Utilities     | 工具类                | DateUtil                      |
| interceptor      | Interceptor          | 拦截器                | AuthInterceptor               |
| aspect           | Aspect               | AOP切面              | LogAspect                     |
| task             | Task                 | 定时任务               | ScheduledTask                 |


# Java项目技术栈
```text
一个完整的Java后端项目，技术栈通常分为**六层**。目前最主流的**“Spring Boot + 微服务 + 云原生”**架构
```

### 1. 前端层
| 类别       | 主流选择                                      | 备选/小众               |
|:---------|:------------------------------------------|:--------------------|
| **现代框架** | **Vue**、**React**、**Angular**             | Svelte、SolidJS      |
| **移动端**  | Uni-app (Vue)、Flutter (Dart)、React Native | 原生开发 (Kotlin/Swift) |
| **后端渲染** | Thymeleaf (Java)、Freemarker               | JSP (已淘汰)           |

### 2. 后端核心层
| 类别              | 主流选择 (2026)                                | 备选/小众                                      |
|:----------------|:-------------------------------------------|:-------------------------------------------|
| **基础框架**        | **Spring Boot 3.x** (JDK 17/21)            | Quarkus (云原生)、Micronaut、Jakarta EE         |
| **微服务生态**       | **Spring Cloud Alibaba**、Spring Cloud (官方) | Apache Dubbo (高性能RPC)、Service Mesh (Istio) |
| **ORM (数据库操作)** | **MyBatis Plus**、Spring Data JPA/Hibernate | JOOQ、Ebean                                 |
| **安全框架**        | **Spring Security**                        | Apache Shiro、Sa-Token                      |

### 3. 数据存储层
| 类别              | 主流选择                             | 备选/小众                          |
|:----------------|:---------------------------------|:-------------------------------|
| **关系型数据库**      | **MySQL 8**、PostgreSQL           | Oracle (遗留)、SQL Server、MariaDB |
| **NoSQL 文档型**   | **MongoDB**、Elasticsearch (搜索引擎) | Couchbase                      |
| **缓存 (高性能)**    | **Redis** (99%场景)                | Memcached、Hazelcast            |
| **列式存储 (OLAP)** | **ClickHouse**、Doris             | TiDB (HTAP)                    |
| **时序数据库 (IoT)** | InfluxDB、TDengine                | Prometheus (监控专用)              |

### 4. 中间件与治理层
| 类别            | 主流选择                                   | 备选/小众                             |
|:--------------|:---------------------------------------|:----------------------------------|
| **服务注册/配置**   | **Nacos**、Consul                       | Eureka (已停更)、ZooKeeper (不适合做配置中心) |
| **API网关**     | **Spring Cloud Gateway**、Kong          | APISIX、Nginx (反向代理)               |
| **消息队列 (MQ)** | **RocketMQ** (阿里，高吞吐)、**Kafka** (日志/流) | RabbitMQ (稳定)、Pulsar              |
| **分布式事务**     | **Seata**                              | TX-LCN (已不活跃)                     |
| **流量控制/熔断**   | **Sentinel** (阿里)、Resilience4j         | Hystrix (已停更)                     |

### 5. 运维与云原生层
| 类别             | 主流选择                                    | 备选/小众                        |
|:---------------|:----------------------------------------|:-----------------------------|
| **容器化**        | **Docker**                              | Podman                       |
| **容器编排**       | **Kubernetes (K8s)**                    | Docker Swarm (已边缘化)、Nomad    |
| **CICD (流水线)** | **Jenkins**、GitLab CI                   | GitHub Actions、阿里云效 (云服务)    |
| **监控 (可观测性)**  | **Prometheus + Grafana** (指标)           | **SkyWalking**、Jaeger (链路追踪) |
| **日志收集**       | **ELK (Elasticsearch+Logstash+Kibana)** | Loki (轻量级)                   |

### 6. 构建与工具层
| 类别        | 主流选择                            | 备选/小众            |
|:----------|:--------------------------------|:-----------------|
| **项目管理**  | **Maven**、Gradle                | Ant (遗留)         |
| **版本控制**  | **Git** (配合GitHub/GitLab/Gitee) | SVN (遗留)         |
| **接口测试**  | **Postman**、Apifox (国产)         | Insomnia         |
| **API文档** | **Knife4j** (Swagger增强)         | Spring REST Docs |

### 💎 总结：两条典型选型路线

| 场景             | 推荐技术栈组合                                                                                                                                              |
|:---------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **中小型单体/快速迭代** | Vue/React + Spring Boot + MyBatis Plus + MySQL + Redis + Git + Maven + Docker                                                                        |
| **大型微服务/高并发**  | Vue/React + Spring Cloud Alibaba (Nacos+Sentinel+Seata) + Gateway + RocketMQ + ShardingJDBC (分库分表) + K8s + Prometheus + SkyWalking + ClickHouse (分析) |

