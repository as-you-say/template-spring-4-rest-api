package account;

import org.example.template.api.account.controller.AccountController;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
        "file:src/main/webapp/WEB-INF/spring/*-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest {
    private MockMvc mockMvc;

    @Autowired
    AccountController accountController;

    @Before
    public void setBuild() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test public void searchBoard_200_OK() throws Exception{
        // pageNum >= 1
        // limit > 0
        this.mockMvc
            .perform(
                get("/accounts")
                .param("limit", "10")
                .param("offset", "0")
            )
            .andExpect(status().isOk());
    }

}
