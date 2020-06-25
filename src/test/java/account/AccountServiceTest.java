package account;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.account.service.impl.AccountServiceImpl;
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

    @Test
    public void selectAccountList() throws Exception{
        // 파라미터
        Account account = new Account();
        account.setLimit(10);
        account.setOffset(0);

        // 테스트
        // - NOT NULL
        List<Account> accounts = accountService.selectAccountList(account);
        Assert.assertNotNull(accounts);
        Assert.assertEquals(1, accounts.size());
    }
}
