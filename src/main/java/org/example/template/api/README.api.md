# RestController
- Rest 컨트롤러는 아래와 같은 어노테이션을 사용하여 HTTP 요청에 따라 API를 작성할 수 있습니다.
    1. @GetMapping
    2. @PostMapping
    3. @PutMapping
    4. @DeleteMapping
```java
@RestController
public class Controller {
    
    @Resource(name="service")
    Service service;
    
    @GetMapping("/getList")
    public List<Entity> testRequest(Entity param){
        return service.getList(param);
    }
}
```
# Validation Service
- 밸리데이션 체크를 위한 서비스입니다.
- 리턴은 항상 boolean 타입이며, 데이터베이스에 쿼리를 실행하기 전에 파라미터가 올바른지를 체크합니다.
- 인터페이스를 작성한 후 클래스로 구현하는 방법으로 작성합니다. 
```java
public interface ValidationService {
    boolean validateGetList(Entity param);
}
```
```java
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validateGetList(Entity param) {
        // 파라미터 검증
        return true;
    }
}
```
# Service
- 프로그램의 로직을 담당하는 서비스입니다.
- @Transactional 어노테이션으로 트랜잭션을 함수단위로 묶어줍니다.
- 밸리데이션 서비스를 상속받아, 체크 후 정상적인 경우에만 쿼리를 실행하도록 합니다.
- 정상적이지 않은 경우에는, @RestControllerAdvice 어노테이션이 붙은 에러 핸들러 클래스로 넘겨줍니다.
```java
public interface Service {
    List<Entity> getList(Entity param);
}
```
```java
@Service
public class ServiceImpl extends ValidationServiceImpl implements Service{
    @Resource(name="mapper")
    Mapper mapper;

    @Transactional
    @Override
    public List<Entity> getList(Entity param){
        boolean isValid = validateGetList(param);
        if(isValid) {
            return mapper.getList(param);
        } else {
            throw new Exception("파라미터 오류");
        }
    }
}
```
# Mapper
- 데이터베이스의 쿼리에 1:1 로 매칭되는 인터페이스입니다.
- 메소드의 이름이 아래에서 언급되는 XML 파일의 id 속성과 같습니다.
```java
@Mapper
public interface Mapper {
    List<Entity> getList(Entity param);
}
```