package role;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.role.mapper.RoleMapper;
import org.example.template.model.Account;
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
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void TEST_1_selectRoleList() throws Exception{
        // 데이터
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);

        // 작업
        Role role = new Role();
        role.setLimit(10);
        role.setOffset(0);
        List<Role> roles = roleMapper.selectRoleList(role);
        Role result = roleMapper.selectRoleById(sample_role);

        // 결과
        Assert.assertNotNull(roles);
        Assert.assertTrue(roles.size() > 0);

        // 초기화
        roleMapper.deleteRole(result);
    }

    @Test
    public void TEST_2_selectRoleById() throws Exception{
        // 데이터
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);

        // 작업
        Role result = roleMapper.selectRoleById(sample_role);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("SAMPLE", result.getName());

        // 초기화
        roleMapper.deleteRole(result);
    }

    @Test
    public void TEST_3_insertRole() throws Exception{
        // 데이터
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");

        // 작업
        roleMapper.insertRole(sample_role);
        Role result = roleMapper.selectRoleById(sample_role);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("SAMPLE", result.getName());

        // 초기화
        roleMapper.deleteRole(result);
    }

    @Test
    public void TEST_4_updateRole() throws Exception{
        // 데이터
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);
        
        // 작업
        sample_role.setName("SAMPLE_2");
        roleMapper.updateRole(sample_role);
        Role result = roleMapper.selectRoleById(sample_role);

        // 결과
        Assert.assertNotNull(result);
        Assert.assertEquals("SAMPLE_2", result.getName());
        
        // 초기화
        roleMapper.deleteRole(result);
    }

    @Test
    public void TEST_5_deleteRole() throws Exception{
        // 데이터
        Role sample_role = new Role();
        sample_role.setName("SAMPLE");
        roleMapper.insertRole(sample_role);

        // 작업
        roleMapper.deleteRole(sample_role);
        Role result = roleMapper.selectRoleById(sample_role);

        // 결과
        Assert.assertNull(result);

        // 초기화 (불필요)
    }

}
