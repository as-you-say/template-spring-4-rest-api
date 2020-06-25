package accountRole;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.accountRole.mapper.AccountRoleMapper;
import org.example.template.api.role.mapper.RoleMapper;
import org.example.template.model.Account;
import org.example.template.model.AccountRole;
import org.example.template.model.Role;
import org.junit.Assert;
import org.junit.Before;
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
        "classpath:config/mybatis-config.xml",
        "file:src/main/webapp/WEB-INF/spring/database-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRoleMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AccountRoleMapper accountRoleMapper;

    @Test
    public void TEST_1_selectAccountRoleByAccountId() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("role@gmail.com");
        sample_account.setPassword("role");
        accountMapper.insertAccount(sample_account);
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);
        AccountRole sample_accountRole = new AccountRole();
        sample_accountRole.setAccount_id(sample_account.getId());
        sample_accountRole.setRole_id(sample_role.getId());
        accountRoleMapper.insertAccountRole(sample_accountRole);

        // 작업
        List<AccountRole> accountRoles = accountRoleMapper.selectAccountRoleByAccountId(sample_accountRole);
        
        // 결과
        Assert.assertNotNull(accountRoles);
        Assert.assertTrue(accountRoles.size() > 0);
        
        // 초기화
        accountRoleMapper.deleteAccountRole(sample_accountRole);
        accountMapper.deleteAccount(sample_account);
        roleMapper.deleteRole(sample_role);
    }

    @Test
    public void TEST_2_insertAccountRole() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("role@gmail.com");
        sample_account.setPassword("role");
        accountMapper.insertAccount(sample_account);
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);

        // 작업
        AccountRole sample_accountRole = new AccountRole();
        sample_accountRole.setAccount_id(sample_account.getId());
        sample_accountRole.setRole_id(sample_role.getId());
        accountRoleMapper.insertAccountRole(sample_accountRole);

        // 테스트
        boolean isAdded = accountRoleMapper.selectAccountRoleByAccountId(sample_accountRole).size()>0;
        Assert.assertTrue(isAdded);

        // 초기화
        accountRoleMapper.deleteAccountRole(sample_accountRole);
        accountMapper.deleteAccount(sample_account);
        roleMapper.deleteRole(sample_role);
    }

    @Test
    public void TEST_3_deleteAccountRole() throws Exception{
        // 데이터
        Account sample_account = new Account();
        sample_account.setUsername("role@gmail.com");
        sample_account.setPassword("role");
        accountMapper.insertAccount(sample_account);
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);
        AccountRole sample_accountRole = new AccountRole();
        sample_accountRole.setAccount_id(sample_account.getId());
        sample_accountRole.setRole_id(sample_role.getId());
        accountRoleMapper.insertAccountRole(sample_accountRole);

        // 테스트
        accountRoleMapper.deleteAccountRole(sample_accountRole);
        boolean isRemoved = accountRoleMapper.selectAccountRoleByAccountId(sample_accountRole).size() == 0;
        Assert.assertTrue(isRemoved);

        // 초기화
        accountMapper.deleteAccount(sample_account);
        roleMapper.deleteRole(sample_role);
    }

}
