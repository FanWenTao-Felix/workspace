ItemReader
ItemReader 负责读取数据，它有如下实现类。

实现类	说明
FlatFileItemReader	从文件中读取数据
MultiResourceItemReader	从多个文件中读取数据
ResourcesItemReader	从多个文件中读取数据，支持通配符
LdifReader	通过 Spring LDAP 从文件中读取数据
MappingLdifReader	通过 Spring LDAP 从文件中读取数据
StaxEventItemReader	通过 StAX 从 XML 文件中读取数据
JdbcCursorItemReader	通过 SQL 从数据库中读取数据
StoredProcedureItemReader	通过存储过程从数据库中读取数据
HibernateCursorItemReader	通过 HQL 从数据库中读取数据
Neo4j4ItemReader	从 Neo4j 数据库中读取数据
Neo4jItemReader	从 Neo4j 数据库中读取数据
MongoItemReader	从 MongoDB 数据库中读取数据
RepositoryItemReader	通过 Repository 从数据库中读取数据
HibernatePagingItemReader	通过 Hibernate 从数据库中读取数据，支持分页
IbatisPagingItemReader	通过 Ibatis 从数据库中读取数据，支持分页
JdbcPagingItemReader	通过 SQL 从数据库中读取数据，支持分页
JpaPagingItemReader	通过 Jpa 从数据库中读取数据，支持分页
JacksonJsonObjectReader
JsonItemReader
GsonJsonObjectReader
JsonFileItemWriterBuilder
JsonItemReaderBuilder
JmsItemReader	从 JMS 中读取数据
AmqpItemReader	从 AMQP 中读取数据
ListItemReader	从 List 中读取数据
IteratorItemReader	从 Iterable 中读取数据
ItemReaderAdapter	装饰者，真正的操作委托给代理
SingleItemPeekableItemReader	装饰者，允许查看下一条数据，真正的操作委托给代理
SynchronizedItemStreamReader	装饰者，增加同步功能，真正的操作委托给代理
ItemWriter
ItemWriter 负责输出数据，它有如下实现类。

实现类	说明
FlatFileItemWriter	将数据输出到文件
MultiResourceItemWriter	将数据输出到多个文件
StaxEventItemWriter	将数据输出到 XML 文件
JdbcBatchItemWriter	通过 SQL，将数据输出到数据库
HibernateItemWriter	通过 Hibernate，将数据输出到数据库
IbatisBatchItemWriter	通过 Ibatis，将数据输出到数据库
JpaItemWriter	通过 JPA，将数据输出到数据库
RepositoryItemWriter	通过 Repository，将数据输出到数据库
MongoItemWriter	将数据输出到 MongoDB
Neo4jItemWriter	将数据输出到 Neo4j
GemfireItemWriter	将数据输出到 GemFire
SpELMappingGemfireItemWriter	将数据输出到 GemFire
JmsItemWriter	将数据输出到 JMS
AmqpItemWriter	将数据输出到 AMQP
ListItemWriter	将数据输出到 List
MimeMessageItemWriter	将数据通过 Email 发送
SimpleMailMessageItemWriter	将数据通过 Email 发送
ItemWriterAdapter	装饰者，真正的操作委托给代理
CompositeItemWriter	装饰者，将数据输出到多个 ItemWriter
ClassifierCompositeItemWriter	装饰者，将数据输出到多个 ItemWriter
PropertyExtractingDelegatingItemWriter	装饰者，允许调用自定义方法
ItemProcessor
ItemProcessor 负责转换、验证数据等，通常我们需要自己实现这个类，不过 Spring 也提供了如下实现类。

实现类	说明
PassThroughItemProcessor	不做任何转换
ScriptItemProcessor	调用脚本对数据处理
ValidatingItemProcessor	调用验证器验证数据
ItemProcessorAdapter	调用自定义方法对数据处理
CompositeItemProcessor	调用多个 ItemProcessor
ClassifierCompositeItemProcessor	调用多个 ItemProcessor
