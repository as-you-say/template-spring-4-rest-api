package account;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.model.Account;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
        "classpath:config/mybatis-config.xml",
        "file:src/main/webapp/WEB-INF/spring/database-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void TEST_1_selectAccountList() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 작업
        Account account = new Account();
        account.setLimit(10);
        account.setOffset(0);
        List<Account> accounts = accountMapper.selectAccountList(account);

        // 결과
        Assert.assertNotNull(accounts);
        Assert.assertTrue(accounts.size() > 0);

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

    @Test
    public void TEST_2_selectAccountById() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 작업
        Account result = accountMapper.selectAccountById(sample_account);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("test@gmail.com", result.getUsername());

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

    @Test
    public void TEST_3_selectAccountByUsername() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 파라미터
        Account result = accountMapper.selectAccountByUsername(sample_account);

        // 테스트
        Assert.assertNotNull(result);
        Assert.assertEquals("test", result.getPassword());

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

    @Test
    public void TEST_4_insertAccount() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 작업
        Account result = accountMapper.selectAccountByUsername(sample_account);

        // 결과
        Assert.assertNotNull(result);

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

    @Test
    public void TEST_5_updateAccount() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 작업
        sample_account.setPassword("test_update");
        accountMapper.updateAccount(sample_account);
        Account result = accountMapper.selectAccountById(sample_account);

        // 결과
        Assert.assertEquals(result.getPassword(), "test_update");

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

    @Test
    public void TEST_6_deleteAccount() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("test@gmail.com");
        sample_account.setPassword("test");
        accountMapper.insertAccount(sample_account);

        // 작업
        accountMapper.deleteAccount(sample_account);
        Account result = accountMapper.selectAccountById(sample_account);

        // 결과
        Assert.assertNull(result);

        // 초기화
        accountMapper.deleteAccount(sample_account);
    }

}
