# SQL - *.xml
- Mapper 인터페이스와 일대일 대응되는 SQL 문장입니다.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
                        "classpath:xsd/mybatis-3-mapper.dtd">
<mapper namespace="[Mapper 패키지 경로].Mapper">
    <select id="getList" parameterType="Entity" resultType="Entity">
        SELECT
             [컬럼명1]
            ,[컬럼명2]
            ,[컬럼명3]
            ,[컬럼명4]
            ,[컬럼명5]
        FROM
            [테이블명]
    </select>
</mapper>
```