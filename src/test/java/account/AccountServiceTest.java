package account;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.account.service.impl.AccountServiceImpl;
import org.example.template.exception.account.AccountNotValidParameterException;
import org.example.template.model.Account;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
        "file:src/main/webapp/WEB-INF/spring/*-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceTest {

    @Autowired
    AccountServiceImpl accountService;

    @Test(expected = AccountNotValidParameterException.class)
    public void TEST_1_LIMIT_NULL() {
        // 데이터
        Account account = new Account();
        account.setOffset(1);

        // 작업
        accountService.selectAccountList(account);
    }

    @Test(expected = AccountNotValidParameterException.class)
    public void TEST_2_OFFSET_NULL() {
        // 데이터
        Account account = new Account();
        account.setLimit(0);

        // 작업
        accountService.selectAccountList(account);
    }

    @Test(expected = AccountNotValidParameterException.class)
    public void TEST_3_LIMIT_NOT_VALID() {
        // 데이터
        Account account = new Account();
        account.setLimit(-1);
        account.setOffset(1);

        // 작업
        accountService.selectAccountList(account);
    }

    @Test(expected = AccountNotValidParameterException.class)
    public void TEST_4_OFFSET_NOT_VALID() {
        // 데이터
        Account account = new Account();
        account.setLimit(1);
        account.setOffset(-1);

        // 작업
        accountService.selectAccountList(account);
    }

}
